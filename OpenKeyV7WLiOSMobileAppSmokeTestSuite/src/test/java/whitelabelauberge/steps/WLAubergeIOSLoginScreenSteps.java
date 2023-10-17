package whitelabelauberge.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**Auberge Mobile iOS App Login Screen*/
public class WLAubergeIOSLoginScreenSteps extends BaseSteps {

    @Before
    public void setupSteps() {

        setupScreens(driver);
    }

    @When("^Guest entered register mobile number$")
    public void enterMobileNumberStep() {

        wlAubergeLoginScreen.enterMobileNumber();
    }

    @And("^Guest click on Request Verification Code Button$")
    public void getVerificationCodeStep() {

        wlAubergeLoginScreen.submitButton();
    }

    @Then("^Verification Screen should be displayed$")
    public void verificationScreenStep() throws InterruptedException {

        wlAubergeLoginScreen.verificationScreen();
    }

    @When("^Read the Verification Code$")
    public void readVerificationCodeStep() throws InterruptedException {

        wlAubergeLoginScreen.readVerificationCode();
    }

    @Then("^Downloading key screen should be displayed$")
    public void myStaysScreenStep() {

        //openKeyV7IOSLoginScreen.myStaysScreen();
        allureReportingManager.stepsScreenshots();
    }
}