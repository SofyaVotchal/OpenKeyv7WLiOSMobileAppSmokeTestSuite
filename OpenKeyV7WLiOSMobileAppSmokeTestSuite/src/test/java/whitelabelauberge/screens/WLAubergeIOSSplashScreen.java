package whitelabelauberge.screens;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;

import static whitelabelauberge.setups.CapabilitiesManager.allureReportingManager;

public class WLAubergeIOSSplashScreen extends BaseScreen{
    public WLAubergeIOSSplashScreen(IOSDriver driver) {

        super(driver);
    }

    /**Mobile Elements of App Store*/
    By appStoreSearchIcon = By.xpath("//XCUIElementTypeButton[@name=\"UIA.AppStore.TabBar.search\"]");
    By appStoreSearchTextField = By.xpath("//XCUIElementTypeSearchField[@name=\"UIA.AppStore.SearchTextField\"]");
    By openKeyGuestAppSearchResult = By.xpath("//XCUIElementTypeStaticText[@name=\"openkey\"]");
    By selectOpenKeyGuestApp = By.xpath("//XCUIElementTypeButton[@name=\"OpenKey, Travel\"]");
    By downloadInstallOpenButtonInAppStore = By.xpath("//XCUIElementTypeButton[@name='UIA.AppStore.OfferButton']");
    By permissionsRequiredScreen = By.xpath("//XCUIElementTypeStaticText[@name=\"Permissions\"]");
    By nextButton = By.name("permissionScreenNextButton");
    By allowToSendNotificationsPrompt = By.xpath("//XCUIElementTypeStaticText[@name=\"“Auberge des Iles” Would Like to Send You Notifications\"]");
    By allowToSendNotifications = By.xpath("//XCUIElementTypeButton[@name=\"Allow\"]");
    By enableBluetoothPrompt = By.xpath("//XCUIElementTypeAlert[@name=\"“Auberge des Iles” Would Like to Use Bluetooth\"]");
    By enableBluetooth = By.xpath("//XCUIElementTypeButton[@name=\"OK\"]");
    By locationAccessPrompt = By.xpath("//XCUIElementTypeAlert[@name=\"Allow “Auberge des Iles” to use your location?\"]");
    By allowWhileUsingApp = By.xpath("//XCUIElementTypeButton[@name=\"Allow While Using App\"]");
    By findMyReservationScreen = By.xpath("//XCUIElementTypeStaticText[@name=\"Find My Reservation\"]");

    /**Firebase App Elements*/
    By selectAubergeAppInFirebase = By.xpath("//XCUIElementTypeStaticText[@name=\"OpenKey\"]");
    By aubergeAppLatestBuildInFirebase = By.xpath("//XCUIElementTypeStaticText[@name=\"Latest\"]");
    By downloadButtonInFirebase = By.xpath("//XCUIElementTypeButton[@name=\"Download\"]");
    By installButtonInFirebase = By.xpath("//XCUIElementTypeButton[@name=\"install\"]");

    /**TestFlight App Elements*/
    By openKeyGuestAppBuildInTestFlight = By.xpath("//XCUIElementTypeStaticText[@name=\"OpenKey\"]");
    By installButtonInTestFlight = By.xpath("//XCUIElementTypeButton[@name=\"INSTALL\"]");
    By openButtonInTestFlight = By.xpath("//XCUIElementTypeButton[@name=\"OPEN\"]");

    /**Actions*/
    /**APP Install from Firebase - Dev Build*/
    public void downloadAndInstallFromFirebase() {

        System.out.println("Firebase Distribution App is opened");
        allureReportingManager.stepsScreenshots();
        System.out.println("Auberge App is displayed");
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectAubergeAppInFirebase)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(aubergeAppLatestBuildInFirebase)).isDisplayed();
        System.out.println("Auberge latest dev build is displayed");
        allureReportingManager.stepsScreenshots();
        try {
            // If GET button wasn't found, the app has been purchased before and there's a Download button instead
            if (driver.isAppInstalled("co.openkey.aubergeDesIles")) {
                allureReportingManager.stepsScreenshots();
                System.out.println("If App is already installed, Uninstall the App and Re-Install it");
                driver.removeApp("co.openkey.aubergeDesIles");
                allureReportingManager.stepsScreenshots();
            } else {
                System.out.println("Download and Install the latest dev build");
            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(downloadButtonInFirebase)).click();
            allureReportingManager.stepsScreenshots();
            Thread.sleep(50000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(installButtonInFirebase)).click();
            allureReportingManager.stepsScreenshots();
            Thread.sleep(10000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(openButtonInTestFlight)).click();
            System.out.println("Auberge dev build is installed");
            allureReportingManager.stepsScreenshots();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**APP Install from TestFlight - Stage Build*/
    public void downloadAndInstallFromTestFlight() {

        System.out.println("TestFlight app is opened");
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(openKeyGuestAppBuildInTestFlight)).isDisplayed();
        System.out.println("OpenKey Guest installation build is displayed");
        allureReportingManager.stepsScreenshots();
        try {
            // If GET button wasn't found, the app has been purchased before and there's a Download button instead
            if (driver.isAppInstalled("com.openkey.guestapp")) {
                allureReportingManager.stepsScreenshots();
                System.out.println("If App is already installed, Uninstall the App and Re-Install it");
                driver.removeApp("com.openkey.guestapp");
                allureReportingManager.stepsScreenshots();
            } else {
                System.out.println("Install the latest TestFlight build");
                allureReportingManager.stepsScreenshots();
            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(installButtonInTestFlight)).click();
            allureReportingManager.stepsScreenshots();
            Thread.sleep(20000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(openButtonInTestFlight)).isDisplayed();
            System.out.println("OpenKey Guest App is installed");
            allureReportingManager.stepsScreenshots();
            //driver.closeApp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**APP Install from App Store - Production Build*/
    public void downloadAndInstallOpenKeyGuestAppFromAppStore() throws InterruptedException {

        System.out.println("App store is opened");
        allureReportingManager.stepsScreenshots();
        System.out.println("Search OpenKey Guest App");
        allureReportingManager.stepsScreenshots();
        System.out.println("Click on Search Icon");
        wait.until(ExpectedConditions.visibilityOfElementLocated(appStoreSearchIcon)).click();
        allureReportingManager.stepsScreenshots();
        System.out.println("Type OpenKey");
        wait.until(ExpectedConditions.visibilityOfElementLocated(appStoreSearchTextField)).sendKeys("OpenKey");
        allureReportingManager.stepsScreenshots();
        Thread.sleep(5000);
        System.out.println("Select OpenKey from Search Text");
        wait.until(ExpectedConditions.visibilityOfElementLocated(openKeyGuestAppSearchResult)).click();
        allureReportingManager.stepsScreenshots();
        Thread.sleep(300);
        allureReportingManager.stepsScreenshots();
        Thread.sleep(5000);
        allureReportingManager.stepsScreenshots();
        System.out.println("Click on OpenKey Guest App from the list");
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectOpenKeyGuestApp)).click();
        allureReportingManager.stepsScreenshots();
        Thread.sleep(5000);

        try {
            // If GET button wasn't found, the app has been purchased before and there's a Download button instead
            if (driver.isAppInstalled("com.openkey.guestapp")) {
                allureReportingManager.stepsScreenshots();
                System.out.println("If App is already installed, Uninstall the App and Re-Install it");
                driver.removeApp("com.openkey.guestapp");
                allureReportingManager.stepsScreenshots();
            } else {
                System.out.println("Download and Install the App");
                allureReportingManager.stepsScreenshots();
            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(downloadInstallOpenButtonInAppStore)).click();
            allureReportingManager.stepsScreenshots();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchOpenKeyApp() throws InterruptedException {
        //While launching from App Store
        Thread.sleep(30000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(downloadInstallOpenButtonInAppStore)).click();
        allureReportingManager.stepsScreenshots();

/*      //While launching from TestFlight
        HashMap<String, Object> args = new HashMap<>();
        args.put("bundleId", "com.openkey.guestapp");
        driver.executeScript("mobile: launchApp", args);*/

        System.out.println("Open the OpenKey Guest App");
        System.out.println("OpenKey Guest App is Launched");
    }

    public void splashScreen() {

        System.out.println("Splash screen should be displayed");
        allureReportingManager.stepsScreenshots();
    }

    public void requiredPermissionsScreen() {

        System.out.println("Permissions Screen should display");
        wait.until(ExpectedConditions.visibilityOfElementLocated(permissionsRequiredScreen)).isDisplayed();
        allureReportingManager.stepsScreenshots();
    }

    public void requiredPermissionScreenNextButton() {

        System.out.println("Click on Next Button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton)).click();
        allureReportingManager.stepsScreenshots();
    }

    public void allowToSendPushNotificationPrompt() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(allowToSendNotificationsPrompt)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(allowToSendNotificationsPrompt)).getText();
        System.out.println("Allow OpenKey would Like to send You Notifications prompt should display " +allowToSendNotificationsPrompt);
        allureReportingManager.stepsScreenshots();
    }

    public void allowPushNotification() {

        System.out.println("Guest click on Allow button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(allowToSendNotifications)).click();
        allureReportingManager.stepsScreenshots();
    }

    public void enableBluetoothPrompt() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(enableBluetoothPrompt)).isDisplayed();
        System.out.println("OpenKey Would Like to Use Bluetooth prompt should be displayed");
        allureReportingManager.stepsScreenshots();
    }

    public void allowBluetoothAccess() {

        System.out.println("Guest click on Ok button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(enableBluetooth)).click();
        allureReportingManager.stepsScreenshots();
    }

    public void locationAccessPrompt() {

        System.out.println("Allow “OpenKey” to use your location? prompt should display");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locationAccessPrompt)).isDisplayed();
        allureReportingManager.stepsScreenshots();
    }

    public void allowWhileUsingApp() {

        System.out.println("Guest selects option Allow While Using App");
        wait.until(ExpectedConditions.visibilityOfElementLocated(allowWhileUsingApp)).click();
        allureReportingManager.stepsScreenshots();
    }

    public void findMyReservationScreen() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(findMyReservationScreen)).isDisplayed();
        System.out.println("Guest navigates to Find My Reservation Screen");
        allureReportingManager.stepsScreenshots();
    }
}

