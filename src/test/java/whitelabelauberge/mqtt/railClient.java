package whitelabelauberge.mqtt;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;
import java.net.URL;

import com.fasterxml.jackson.core.type.TypeReference;
import org.eclipse.paho.mqttv5.client.IMqttToken;
import org.eclipse.paho.mqttv5.client.MqttCallback;
import org.eclipse.paho.mqttv5.client.MqttClient;
import org.eclipse.paho.mqttv5.client.MqttDisconnectResponse;
import org.eclipse.paho.mqttv5.common.MqttException;
import org.eclipse.paho.mqttv5.common.MqttMessage;
import org.eclipse.paho.mqttv5.common.packet.MqttProperties;

import com.fasterxml.jackson.databind.ObjectMapper;


public class railClient {
    private static MqttClient mqttClient;
    private static boolean received_message = false;
    private static boolean should_error = false;

    public static void createMqttClient(String railName) throws MqttException {
        mqttClient = new MqttClient("tcp://192.168.1.152:1883", UUID.randomUUID().toString());
        mqttClient.connect();
        Callback callback = new railClient.Callback();
        mqttClient.setCallback(callback);
        mqttClient.subscribe(getTopics(railName)[1], 0);
        System.out.println("Client connected to broker");
    }

    public static void moveToPosition(String railName, int lockNumber, int phoneSlot) throws Exception {
        createMqttClient(railName);
        ObjectMapper mapper = new ObjectMapper();
        List<RailPosition> rail_positions = mapper.readValue(new URL("http://192.168.1.152:8001/rails/" + railName + "/available-positions"), new TypeReference<List<RailPosition>>() { });
        int position_value = getPostionValueFromList(rail_positions, lockNumber, phoneSlot);
        publishMessage("moveToPosition?" + position_value, railName);
    }

    public void calibrate(String railName) throws Exception {
        createMqttClient(railName);
        publishMessage("calibrate", railName);
    }

    private static void publishMessage(String message, String railName) throws Exception {
        String publishTopic = getTopics(railName)[0];
        System.out.println(message);
        byte[] messageToPublish = message.getBytes(StandardCharsets.UTF_8);
        mqttClient.publish(publishTopic , messageToPublish, 0, false);

        long current_time = System.currentTimeMillis();

        long timeout = current_time + 15000;

        while (!received_message && System.currentTimeMillis() < timeout) {
            Thread.sleep(100);
        }

        if (!received_message) {
            mqttClient.disconnect();
            mqttClient.close(true);
            throw new Exception("Did not receive response from rail within timeout");
        }

        mqttClient.disconnect();
        mqttClient.close(true);
        if (should_error) {
            throw new Exception("problem moving rail to position");
        }
    }

    public static String[] getTopics(String railName){
        String[] topics = new String[2];
        topics[0] = railName + "/command";
        topics[1] = railName + "/response";
        return topics;
    }

    public static int getPostionValueFromList(List<RailPosition> rail_positions, int lock_number, int phone_slot) {
        RailPosition rail_position = rail_positions.stream()
                .filter(pos -> pos.lock_number == lock_number && pos.phone_slot == phone_slot)
                .findFirst()
                .get();
        return rail_position.position_value;
    }

    public static class Callback implements MqttCallback {

        @Override
        public void disconnected(MqttDisconnectResponse mqttDisconnectResponse) {

        }

        @Override
        public void mqttErrorOccurred(MqttException e) {

        }

        @Override
        public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
            String message = new String(mqttMessage.getPayload(), StandardCharsets.UTF_8);
            int code = Integer.parseInt(message);
            if(code == -2){
                received_message = true;
                should_error = true;
            }
            received_message = true;
        }

        @Override
        public void deliveryComplete(IMqttToken iMqttToken) {

        }

        @Override
        public void connectComplete(boolean b, String s) {

        }

        @Override
        public void authPacketArrived(int i, MqttProperties mqttProperties) {

        }
    }

    public static class RailPosition {
        public int rail_id;
        public int phone_slot;
        public int lock_number;
        public int position_value;
        public int id;
    }
}

