package whitelabelauberge.setups;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import whitelabelauberge.reporting.AllureReportingManager;
import org.eclipse.paho.mqttv5.common.MqttException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CapabilitiesManager {

    /**Make the driver static. This allows it to be created only once and used across all the test classes.*/
    public static IOSDriver driver;
    public static String platformName;
    public static String platformVersion;
    public static String deviceName;
    public static String bundleId;
    public static String xcodeOrgId;
    public static String xcodeSigningId;
    public static String udid;
    public static String automationName;
    public static int lockCounter=0;

    public static AllureReportingManager allureReportingManager;
    public static SessionId sessionId;

    /**This method runs before any other method, We are setting up our appium client in order to connect ios and iOS devices to appium server*/
    @BeforeTest
    public void preparation() throws IOException, MqttException {

        allureReportingManager = new AllureReportingManager();

        // Use empty DesiredCapabilities object
        DesiredCapabilities capabilities = new DesiredCapabilities();
        YamlConfigReader.inititializeyaml();

        // Reading capabilities from yaml file using getDesired_capabilities() method in YamlConfigReader class
        String [] desiredCapabilities= YamlConfigReader.getDesired_capabilities();
        platformName = desiredCapabilities[0];
        platformVersion = desiredCapabilities[1];
        deviceName = desiredCapabilities[2];
        bundleId = desiredCapabilities[3];
        xcodeOrgId = desiredCapabilities[4];
        xcodeSigningId = desiredCapabilities[5];
        udid = desiredCapabilities[6];
        automationName = desiredCapabilities [7];
        String orientation = desiredCapabilities[8];
        lockCounter = Integer.parseInt(desiredCapabilities[9]);

        System.out.println("Desired Capabilities Manager");
        System.out.println("Device Name : " +deviceName);
        System.out.println("Device Type : " +platformName);
        System.out.println("Platform Version : " +platformVersion);
        System.out.println("bundleId : " +bundleId);
        System.out.println("xcodeOrgId : " +xcodeOrgId);
        System.out.println("xcodeSigningId : " +xcodeSigningId);
        System.out.println("UDID : " +udid);
        System.out.println("automationName : " +automationName);
        System.out.println("Orientation : " +orientation);
        System.out.println("Lock Counter : " +lockCounter);

        // Read the DesiredCapabilities from envds.yaml for OpenKey React Native iOS Mobile App capabilities only for local attached device with system
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, deviceName);

        // Set Device orientation
        capabilities.setCapability(MobileCapabilityType.ORIENTATION, orientation);

        // Appium iOS App Real Device Capabilities
        capabilities.setCapability("bundleId", bundleId);
        capabilities.setCapability("xcodeOrgId", xcodeOrgId);
        capabilities.setCapability("xcodeSigningId", xcodeSigningId);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
        //capabilities.setCapability("autoAcceptAlerts", "true");

        //It will not uninstall on each run existing installed WebDriverAgentRunner in real device
        capabilities.setCapability("usePrebuiltWDA", "true");

        // Start Appium Server - Using appium command in Terminal
        Runtime runtime = Runtime.getRuntime();

         try {
             runtime.exec("appium");
             System.out.println("Appium server starting...");
         } catch (IOException e) {
             e.printStackTrace();
             System.out.println("Appium server not started!");
         }

        // Start Session in iOS Device
        final URL server = new URL("http://localhost:4723/");

        driver = new IOSDriver(server, capabilities);
        System.out.println("Appium server started..." + server);
        System.out.println("iOS session started:" + capabilities);

        // Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println(System.getenv());
        sessionId=driver.getSessionId();
    }
}


