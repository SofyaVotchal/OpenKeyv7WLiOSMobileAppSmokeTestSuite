package whitelabelauberge.reporting;

import io.qameta.allure.Allure;
import whitelabelauberge.screens.WLAubergeIOSDoorLockScreen;
import whitelabelauberge.setups.CapabilitiesManager;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.*;
import java.util.Properties;

public class AllureReport extends CapabilitiesManager {

    String path;
    String allureDirectPath = "allure-results";
    Properties properties;
    File screenshotFile;
    File fl = new File(allureDirectPath);

    /**Checking if allure-results is not empty and clean it*/
    public void createAllureDirectory() {

        if (fl.mkdir()==true) {

            System.out.println("'allure-results' directory is now created");
        }

        else {

            System.out.println("Unable to create Directory");
        }
    }

    public void cleanUpAllureDirectory() throws IOException {

        if (fl.exists() && fl.isDirectory()) {

            if (new File("allure-results").list().length > 0) {

                FileUtils.cleanDirectory(new File(allureDirectPath));
            }
        }
        else {

            createAllureDirectory();
        }
    }

    /**Writing Data into the Environment variable*/
    public void envFileWriter() throws IOException {

        path = "allure-results/environment.properties";

        FileOutputStream outputStream = new FileOutputStream(path, true);

        properties = new Properties();

        properties.put("Device Name :", deviceName);
        properties.store(outputStream,"Allure Report Results");
        properties.put("deviceType :", platformName);
        properties.store(outputStream,"Allure Report Results");
        properties.put("platformVersion :", platformVersion);
        properties.store(outputStream,"Allure Report Results");

        /**Main Room Lock Statistics*/
        properties.put("Total number of times the Main Room test executed :", String.valueOf(WLAubergeIOSDoorLockScreen.totalNumberOfLockOpeningAttempts));
        properties.store(outputStream,"Allure Report Results");
        properties.put("Number of times Main Room lock opened successfully :", String.valueOf(WLAubergeIOSDoorLockScreen.lockOpenSuccessCount));
        properties.store(outputStream,"Allure Report Results");
        properties.put("Number of times Main Room lock failed to open :",  String.valueOf(WLAubergeIOSDoorLockScreen.lockOpenFailureCount));
        properties.store(outputStream,"Allure Report Results");

        /**Suite Room Lock Statistics*/
        properties.put("Total number of times the Suite Room test executed", String.valueOf(WLAubergeIOSDoorLockScreen.totalNumberOfLockOpeningAttempts));
        properties.store(outputStream,"Allure Report Results");
        properties.put("Number of times Suite Room lock opened successfully : ", String.valueOf(WLAubergeIOSDoorLockScreen.lockOpenSuccessCount_SuiteRoom));
        properties.store(outputStream,"Allure Report Results");
        properties.put("Number of times Suite Room lock failed to open  : ",  String.valueOf(WLAubergeIOSDoorLockScreen.lockOpenFailureCount_SuiteRoom));
        properties.store(outputStream,"Allure Report Results");

        /**Additional Room Lock Statistics*/
        properties.put("Total number of times the Additional Room test executed", String.valueOf(WLAubergeIOSDoorLockScreen.totalNumberOfLockOpeningAttempts));
        properties.store(outputStream,"Allure Report Results");
        properties.put("Number of times Additional Room lock opened successfully : ", String.valueOf(WLAubergeIOSDoorLockScreen.lockOpenSuccessCount_AdditionalRoom));
        properties.store(outputStream,"Allure Report Results");
        properties.put("Number of times Additional Room lock failed to open  : ",  String.valueOf(WLAubergeIOSDoorLockScreen.lockOpenFailureCount_AdditionalRoom));
        properties.store(outputStream,"Allure Report Results");

        /**Designated/Common Area Access Lock Statistics*/
        properties.put("Total number of times the Common Room test executed", String.valueOf(WLAubergeIOSDoorLockScreen.totalNumberOfLockOpeningAttempts));
        properties.store(outputStream,"Allure Report Results");
        properties.put("Number of times Common Room lock opened successfully : ", String.valueOf(WLAubergeIOSDoorLockScreen.lockOpenSuccessCount_CommonRoom));
        properties.store(outputStream,"Allure Report Results");
        properties.put("Number of times Common Room lock failed to open : ",  String.valueOf(WLAubergeIOSDoorLockScreen.lockOpenFailureCount_CommonRoom));
        properties.store(outputStream,"Allure Report Results");
    }

    /**Writing Data into the Executor Details*/
    public void executorFileWriter() throws IOException {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", System.getenv("USER"));
        jsonObject.put("buildName", bundleId);
        jsonObject.put("type", "LocalRun");

        FileWriter fr = new FileWriter("allure-results/executor.json");
        fr.write(jsonObject.toString());
        fr.flush();
    }

    public void methodtakescreenShot() throws IOException {

        screenshotFile  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File targetFile=new File("allure-results/"+System.currentTimeMillis()+".png");

        FileUtils.copyFile(screenshotFile,targetFile);
    }

    public void addScreenshot(String name) throws FileNotFoundException {

        Allure.addAttachment(name, new FileInputStream(screenshotFile));
    }
}
