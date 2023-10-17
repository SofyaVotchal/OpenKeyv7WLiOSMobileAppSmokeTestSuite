package whitelabelauberge.screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static io.appium.java_client.touch.offset.PointOption.point;
import static whitelabelauberge.setups.CapabilitiesManager.allureReportingManager;

public class WLAubergeIOSLoginScreen extends BaseScreen {

    public WLAubergeIOSLoginScreen(IOSDriver driver) {

        super(driver);
    }

    /**Mobile Elements*/
    By enterCountryCode = By.xpath("//XCUIElementTypeTextField[@name=\"phoneInputCountryCodeField\"]");
    By enterMobileNumberField = By.xpath("//XCUIElementTypeTextField[@name=\"phoneInputPhoneNumberField\"]");
    By submitButton = By.name("myReservationScreenSubmitButton");
    By verificationScreen = By.name("Verification");
    //By enterVerificationCodeField = By.xpath("(//XCUIElementTypeOther[@name=\"otpInput1 otpInput1 otpInput1 otpInput1 otpInput1\"])[2]");
    By enterVerificationCodeField = By.xpath("(//XCUIElementTypeOther[@name=\"otpInput0 otpInput1 otpInput2 otpInput3 otpInput4\"])[2]/XCUIElementTypeOther[1]/XCUIElementTypeTextField");
    By myStaysScreen = By.name("My Stays");

    /**Actions*/
    public void enterMobileNumber() {
        
        /*System.out.println("Hotel Manager enters Country Code");
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterCountryCode)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterCountryCode)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterCountryCode)).sendKeys("+91");
        allureReportingManager.stepsScreenshots();*/

        wait.until(ExpectedConditions.visibilityOfElementLocated(enterMobileNumberField)).click();
        System.out.println("Guest click on Enter Mobile Number Field");
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterMobileNumberField)).sendKeys("4698589763");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(enterMobileNumberField)).sendKeys("4697047122");
        System.out.println("Guest entered register mobile number");
        allureReportingManager.stepsScreenshots();
    }

    public void submitButton() {

        //driver.findElement(By.xpath(String.format("//XCUIElementTypeButton[@name='%s']", "Done"))).click();
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton)).click();
        System.out.println("Guest click on Submit Button");
        allureReportingManager.stepsScreenshots();
    }

    public void verificationScreen() throws InterruptedException {

        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(verificationScreen)).isDisplayed();
        System.out.println("Verification Screen should be displayed");
        System.out.println("Guest received verification code text message");
        allureReportingManager.stepsScreenshots();
    }

    public void readVerificationCode() throws InterruptedException {

        System.out.println("Guest click on Enter Verification Code Field");
        //Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterVerificationCodeField)).click();
        allureReportingManager.stepsScreenshots();
        Thread.sleep(3000);
        new TouchAction(driver)
                .tap(point(213, 334)).perform();
        System.out.println("App auto-read the Verification Code from received text message");
        allureReportingManager.stepsScreenshots();
    }

    public void myStaysScreen() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(myStaysScreen)).isDisplayed();
        System.out.println("My Stays Screen should be displayed");
        allureReportingManager.stepsScreenshots();
    }
}
