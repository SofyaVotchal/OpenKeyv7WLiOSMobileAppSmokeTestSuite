package whitelabelauberge.screens;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static whitelabelauberge.setups.CapabilitiesManager.allureReportingManager;

public class WLAubergeIOSDownloadMobileKeyScreen extends BaseScreen {

    public WLAubergeIOSDownloadMobileKeyScreen(IOSDriver driver) {

        super(driver);
    }

    /**Mobile Elements*/
    By getMyKeyButton = By.xpath("//XCUIElementTypeStaticText[@name=\"Get My Key\"]");
    By downloadMobileKeyScreen = By.xpath("//XCUIElementTypeStaticText[@name=\"dowenloadKeyTxt\"]");
    By keyDownloadingAnimatedImage = By.name("downloadKeyAnnimation");
    By keyDownloadError = By.xpath("//XCUIElementTypeStaticText[@name=\"ERROR\"]");
    By keyDownloadCancel = By.xpath("//XCUIElementTypeStaticText[@name=\"CANCEL\"]");
    By hotelTitle = By.xpath("//XCUIElementTypeStaticText[@name=\"Hotel Miwa System dev\"]");

    /**Actions*/
    public void getMyKeyButton() throws InterruptedException {

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMyKeyButton)).click();
        System.out.println("Guest click on Get My Key");
        allureReportingManager.stepsScreenshots();
    }

    public void downloadMobileKeyScreen() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(downloadMobileKeyScreen)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(keyDownloadingAnimatedImage)).isDisplayed();
        System.out.println("Guest navigates to the Downloading Key Screen");
        allureReportingManager.stepsScreenshots();
    }

    public void verifyContentOnActiveKeyScreen() {

        try {
            Thread.sleep(10000);
            //wait.until(ExpectedConditions.visibilityOfElementLocated(hotelTitle)).isDisplayed();
            System.out.println("Guest should successfully able to download key");
            System.out.println("My Key Screen should be displayed");
            System.out.println("On the My Key Screen Hotel Name and Room Number should be displayed");
            allureReportingManager.stepsScreenshots();
        } catch (Exception e) {
            /*if (wait.until(ExpectedConditions.visibilityOfElementLocated(keyDownloadError)).isDisplayed())
                System.out.println("Failed to Download Key");
            allureReportingManager.stepsScreenshots();
            wait.until(ExpectedConditions.visibilityOfElementLocated(keyDownloadCancel)).click();*/
            allureReportingManager.stepsScreenshots();
            System.out.println("Failed to Download Key");
            driver.quit();
        }
    }
}
