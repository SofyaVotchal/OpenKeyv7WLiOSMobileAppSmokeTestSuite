package whitelabelauberge.screens;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static whitelabelauberge.setups.CapabilitiesManager.allureReportingManager;
//import static openkey.setups.CapabilitiesManager.mqttClient;


public class WLAubergeIOSDoorLockScreen extends BaseScreen {

    public static int counter = 0;
    public static int lockOpenSuccessCount = 0;
    public static int lockOpenFailureCount = 0;
    public static int totalNumberOfLockOpeningAttempts=0;
    public static int multipleRoomAccessCounter = 0;

    /**Suite Room Lock*/
    public static int lockOpenSuccessCount_SuiteRoom = 0;
    public static int lockOpenFailureCount_SuiteRoom = 0;

    /**Additional Room Lock*/
    public static int lockOpenSuccessCount_AdditionalRoom = 0;
    public static int lockOpenFailureCount_AdditionalRoom = 0;

    /**Designated/Common Area Access Lock*/
    public static int lockOpenSuccessCount_CommonRoom = 0;
    public static int lockOpenFailureCount_CommonRoom = 0;

    String accessGranted;

    public WLAubergeIOSDoorLockScreen(IOSDriver driver) {

        super(driver);
    }

    /**Mobile Elements*/
    By mainDoorKey = By.xpath("//XCUIElementTypeOther[@name=\"mainKey1\"]");
    By accessGrantedCheck = By.name("accessGranted1");
    By yourDoorIsNowUnlocked = By.name("Door Unlocked");
    By failedToOpenDoorLockErrorPrompt = By.xpath("//XCUIElementTypeStaticText[@name=\"DialogTitle\"]");
    By failedToOpenDoorLockErrorPromptTryAgainButton = By.xpath("//XCUIElementTypeOther[@name=\"submitBtn\"]");
    By multipleLockKeyFoundPrompt = By.xpath("//XCUIElementTypeStaticText[@name=\"MULTIPLE LOCKS FOUND\"]");
    By suiteRoomKey = By.xpath("//XCUIElementTypeStaticText[@name=\"btnsuite008Text\"]");
    By additionalRoomKey = By.xpath("//XCUIElementTypeStaticText[@name=\"btn700Text\"]");
    By commonAreaAccessKey = By.xpath("//XCUIElementTypeStaticText[@name=\"btn103Text\"]");

    /**Actions*/
    public void openMainDoorLock() throws Exception {

        Thread.sleep(20000);
        System.out.println("Lock move to 5th Position");
        whitelabelauberge.mqtt.railClient.moveToPosition("Miwa1", 5, 1);

        System.out.println("Guest click on Main Key Icon");
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainDoorKey)).click();
        allureReportingManager.stepsScreenshots();
    }
    public void accessGrantedCheck() throws Exception {

        try {
            if (driver.findElement(accessGrantedCheck).isDisplayed()) {
                accessGranted = wait.until(ExpectedConditions.visibilityOfElementLocated(yourDoorIsNowUnlocked)).getText();
                lockOpenSuccessCount = lockOpenSuccessCount + 1;
                counter = counter + 1;
                if (lockOpenSuccessCount == 1)
                    System.out.println(accessGranted + " Your door is unlocked successfully for the first time");
                else System.out.println(accessGranted + " Your door is unlocked " + lockOpenSuccessCount + " times");
            }
        } catch (Exception e) {
                allureReportingManager.stepsScreenshots();
            if (driver.findElement(failedToOpenDoorLockErrorPrompt).isDisplayed()) {
                lockOpenFailureCount = lockOpenFailureCount + 1;
                if (lockOpenFailureCount == 1)
                    System.out.println("UNABLE TO OPEN LOCK " + lockOpenFailureCount + " time");
                else System.out.println("UNABLE TO OPEN LOCK " + lockOpenFailureCount + " times");
                counter = counter + 1;
                wait.until(ExpectedConditions.visibilityOfElementLocated(failedToOpenDoorLockErrorPromptTryAgainButton)).click();
                allureReportingManager.stepsScreenshots();
            }
        }
    }
    public void openMainDoorLockMultipleTimes(int numberOfTimes) {

        totalNumberOfLockOpeningAttempts=numberOfTimes;
        while (counter < numberOfTimes) {
            try {
                openMainDoorLock();
                accessGrantedCheck();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total number of attempts to open door lock " + numberOfTimes);
        System.out.println("Door Lock opened successfully " + lockOpenSuccessCount + " times");
        System.out.println("Door Lock failed to opened " + lockOpenFailureCount + " times");
        allureReportingManager.stepsScreenshots();
    }
    public void accessGrantedCheckOEMLocks() throws Exception {

        try {
            if (driver.findElement(accessGrantedCheck).isDisplayed()) {
                accessGranted = wait.until(ExpectedConditions.visibilityOfElementLocated(yourDoorIsNowUnlocked)).getText();
                lockOpenSuccessCount = lockOpenSuccessCount + 1;
                counter = counter + 1;
                if (lockOpenSuccessCount == 1)
                    System.out.println(accessGranted + " Your door is unlocked successfully for the first time");
                else System.out.println(accessGranted + " Your door is unlocked " + lockOpenSuccessCount + " times");
            }
             whitelabelauberge.mqtt.railClient.moveToPosition("Miwa1", 4, 1);
             System.out.println("Lock move to home Position");
            
        } catch (Exception e) {
            allureReportingManager.stepsScreenshots();
            if (driver.findElement(failedToOpenDoorLockErrorPrompt).isDisplayed()) {
                lockOpenFailureCount = lockOpenFailureCount + 1;
                if (lockOpenFailureCount == 1)
                    System.out.println("UNABLE TO OPEN LOCK " + lockOpenFailureCount + " time");
                else System.out.println("UNABLE TO OPEN LOCK " + lockOpenFailureCount + " times");
                counter = counter + 1;
                wait.until(ExpectedConditions.visibilityOfElementLocated(failedToOpenDoorLockErrorPromptTryAgainButton)).click();
                allureReportingManager.stepsScreenshots();
            }
            whitelabelauberge.mqtt.railClient.moveToPosition("Miwa1", 4, 1);
            System.out.println("Lock move to home Position");
        }
    }
    public void openMainDoorLockMultipleTimesOEMLocks(int numberOfTimes) {

        totalNumberOfLockOpeningAttempts=numberOfTimes;
        while (counter < numberOfTimes) {
            try {
                openMainDoorLock();
                accessGrantedCheckOEMLocks();
                System.out.println("Total counter" + counter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total number of attempts to open door lock " + numberOfTimes);
        System.out.println("Door Lock opened successfully " + lockOpenSuccessCount + " times");
        System.out.println("Door Lock failed to opened " + lockOpenFailureCount + " times");
        allureReportingManager.stepsScreenshots();
    }
    public void accessGrantedCheckSuiteRoom() throws InterruptedException {

        try {
            if (driver.findElement(accessGrantedCheck).isDisplayed()) {
                accessGranted = wait.until(ExpectedConditions.visibilityOfElementLocated(yourDoorIsNowUnlocked)).getText();
                lockOpenSuccessCount_SuiteRoom = lockOpenSuccessCount_SuiteRoom + 1;
                if (lockOpenSuccessCount_SuiteRoom == 1)
                    System.out.println(accessGranted + " Suite Room door is unlocked " + lockOpenSuccessCount_SuiteRoom + " times");
            }

        } catch (Exception e) {
            allureReportingManager.stepsScreenshots();
            if (driver.findElement(failedToOpenDoorLockErrorPrompt).isDisplayed()) {
                lockOpenFailureCount_SuiteRoom = lockOpenFailureCount_SuiteRoom + 1;
                if (lockOpenFailureCount_SuiteRoom == 1)
                    System.out.println("UNABLE TO OPEN SUITE ROOM LOCK " + lockOpenFailureCount_SuiteRoom + " time");
                else System.out.println("UNABLE TO OPEN SUITE ROOM LOCK " + lockOpenFailureCount_SuiteRoom + " times");
                wait.until(ExpectedConditions.visibilityOfElementLocated(failedToOpenDoorLockErrorPromptTryAgainButton)).click();
                allureReportingManager.stepsScreenshots();
            }
        }
    }
    public void accessGrantedCheckAdditionalRoom() throws InterruptedException {

        try {
            if (driver.findElement(accessGrantedCheck).isDisplayed()) {
                accessGranted = wait.until(ExpectedConditions.visibilityOfElementLocated(yourDoorIsNowUnlocked)).getText();
                lockOpenSuccessCount_AdditionalRoom = lockOpenSuccessCount_AdditionalRoom + 1;
                if (lockOpenSuccessCount_AdditionalRoom == 1)
                    System.out.println(accessGranted + " Additional Room door is unlocked " + lockOpenSuccessCount_AdditionalRoom + " times");
            }

        } catch (Exception e) {
            allureReportingManager.stepsScreenshots();
            if (driver.findElement(failedToOpenDoorLockErrorPrompt).isDisplayed()) {
                lockOpenFailureCount_AdditionalRoom = lockOpenFailureCount_AdditionalRoom + 1;
                if (lockOpenFailureCount_AdditionalRoom == 1)
                    System.out.println("UNABLE TO OPEN ADDITIONAL ROOM LOCK " + lockOpenFailureCount_AdditionalRoom + " time");
                else
                    System.out.println("UNABLE TO OPEN ADDITIONAL ROOM LOCK " + lockOpenFailureCount_AdditionalRoom + " times");
                wait.until(ExpectedConditions.visibilityOfElementLocated(failedToOpenDoorLockErrorPromptTryAgainButton)).click();
                allureReportingManager.stepsScreenshots();
            }
        }
    }
    public void accessGrantedCheckCommonAreaAccess() throws InterruptedException {

        try {
            if (driver.findElement(accessGrantedCheck).isDisplayed()) {
                accessGranted = wait.until(ExpectedConditions.visibilityOfElementLocated(yourDoorIsNowUnlocked)).getText();
                lockOpenSuccessCount_CommonRoom = lockOpenSuccessCount_CommonRoom + 1;
                if (lockOpenSuccessCount_CommonRoom == 1) //System.out.println(accessGranted + " Your door is unlocked successfully for the first time");
                    System.out.println(accessGranted + "Guest is able to access Designated/Common Area " + lockOpenSuccessCount_CommonRoom + " times");
            }

        } catch (Exception e) {
            allureReportingManager.stepsScreenshots();
            if (driver.findElement(failedToOpenDoorLockErrorPrompt).isDisplayed()) {
                lockOpenFailureCount_CommonRoom = lockOpenFailureCount_CommonRoom + 1;
                if (lockOpenFailureCount_CommonRoom == 1)
                    System.out.println("UNABLE TO OPEN DESIGNATED/COMMON AREA ACCESS LOCK " + lockOpenFailureCount_CommonRoom + " time");
                else
                    System.out.println("UNABLE TO OPEN DESIGNATED/COMMON AREA ACCESS LOCK " + lockOpenFailureCount_CommonRoom + " times");
                wait.until(ExpectedConditions.visibilityOfElementLocated(failedToOpenDoorLockErrorPromptTryAgainButton)).click();
                allureReportingManager.stepsScreenshots();
            }
        }
    }
    public void openSuiteRoomFlowMultipleTimesInSeries (int numberOfTimes) throws InterruptedException {

        totalNumberOfLockOpeningAttempts = numberOfTimes;
        System.out.println("Guest can access multiple times suite room key, additional room and Common/Designated Access Area");
        while (multipleRoomAccessCounter < numberOfTimes) {
            try {
                openMainDoorLock();
                if (wait.until(ExpectedConditions.visibilityOfElementLocated(multipleLockKeyFoundPrompt)).isDisplayed()) {
                System.out.println("MULTIPLE LOCKS FOUND prompt should be displayed");
                    multipleRoomAccessCounter = multipleRoomAccessCounter + 1;

                    wait.until(ExpectedConditions.visibilityOfElementLocated(suiteRoomKey)).click();
                    System.out.println("Guest click on Suite Room Lock Key");
                    allureReportingManager.stepsScreenshots();
                    accessGrantedCheckSuiteRoom();

                    openMainDoorLock();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(additionalRoomKey)).click();
                    System.out.println("Guest click on Additional Room Lock Key");
                    allureReportingManager.stepsScreenshots();
                    accessGrantedCheckAdditionalRoom();

                    openMainDoorLock();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(commonAreaAccessKey)).click();
                    System.out.println("Guest click on Designated/Common Area Access Lock Key");
                    allureReportingManager.stepsScreenshots();
                    accessGrantedCheckCommonAreaAccess();
               }
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
        }

        System.out.println("Total number of attempts to open Suite Room Lock " + numberOfTimes);
        System.out.println("Suite Room Lock opened successfully " + lockOpenSuccessCount_SuiteRoom + " times");
        System.out.println("Suite Room failed to opened " + lockOpenFailureCount_SuiteRoom + " times");
        allureReportingManager.stepsScreenshots();

        System.out.println("Total number of attempts to open Additional Room Lock " + numberOfTimes);
        System.out.println("Additional Room Lock opened successfully " + lockOpenSuccessCount_AdditionalRoom + " times");
        System.out.println("Additional Room Lock failed to opened " + lockOpenFailureCount_AdditionalRoom + " times");
        allureReportingManager.stepsScreenshots();

        System.out.println("Total number of attempts to open DESIGNATED/COMMON Area Access Door Lock " + numberOfTimes);
        System.out.println("DESIGNATED/COMMON Area Access Door Lock opened successfully " + lockOpenSuccessCount_CommonRoom + " times");
        System.out.println("DESIGNATED/COMMON Area Access Door Lock failed to opened " + lockOpenFailureCount_CommonRoom + " times");
        allureReportingManager.stepsScreenshots();
    }
}
