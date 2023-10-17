package whitelabelauberge.setups;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YamlConfigReader {

    protected static String[] desiredCapabilities = new String[10];
    private static ClassLoader classLoader;
    private static File file;
    private static ObjectMapper objectmapper;
    private static YAMLGetterSetter yamlGetterSetter;

    public static void inititializeyaml() {

        classLoader = Thread.currentThread().getContextClassLoader();
        // To run it on Mac machine
        file = new File("src/main/com.openkey.resources/envds.yaml");
        System.out.println(file.getAbsoluteFile());
        objectmapper = new ObjectMapper(new YAMLFactory());

    }

    public static String[] getDesired_capabilities() throws IOException {

        yamlGetterSetter = objectmapper.readValue(file, YAMLGetterSetter.class);
        System.out.println("Name of the Application : " + yamlGetterSetter.getName());
        System.out.println("Environment : " + yamlGetterSetter.getEnvironment());

        desiredCapabilities[0] = yamlGetterSetter.getDesired_capabilities().get(0).getType();
        desiredCapabilities[1] = yamlGetterSetter.getDesired_capabilities().get(0).getOS_version();
        desiredCapabilities[2] = yamlGetterSetter.getDesired_capabilities().get(0).getDevice();
        desiredCapabilities[3] = yamlGetterSetter.getDesired_capabilities().get(0).getBundleId();
        desiredCapabilities[4] = yamlGetterSetter.getDesired_capabilities().get(0).getXcodeOrgId();
        desiredCapabilities[5] = yamlGetterSetter.getDesired_capabilities().get(0).getXcodeSigningId();
        desiredCapabilities[6] = yamlGetterSetter.getDesired_capabilities().get(0).getUDID();
        desiredCapabilities[7] = yamlGetterSetter.getDesired_capabilities().get(0).getAutomationName();
        desiredCapabilities[8] = yamlGetterSetter.getDesired_capabilities().get(0).getOrientation();
        desiredCapabilities[9] = String.valueOf(yamlGetterSetter.getDesired_capabilities().get(0).getDoorLockTotalCount());
        return desiredCapabilities;
    }
}


