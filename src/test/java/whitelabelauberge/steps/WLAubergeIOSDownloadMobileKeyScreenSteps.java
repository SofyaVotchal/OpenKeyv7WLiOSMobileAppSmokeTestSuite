package whitelabelauberge.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**OpenKey Guest Mobile iOS App Download Mobile Key Screen*/
public class WLAubergeIOSDownloadMobileKeyScreenSteps extends BaseSteps {

    @Before
    public void setupSteps() {

        setupScreens(driver);
    }

    @When("^Guest click on Get My Key$")
    public void getMyKeyButtonStep() throws InterruptedException {

        //openKeyV7IOSDownloadMobileKeyScreen.getMyKeyButton();
        allureReportingManager.stepsScreenshots();
    }

    @And("^Guest navigates to the Downloading Key Screen$")
    public void downloadMobileKeyScreenStep() {

        wlAubergeIOSDownloadMobileKeyScreen.downloadMobileKeyScreen();
    }

    @Then("^Guest should successfully able to download key$")
    public void KeyDownloadScreenStep() {

        wlAubergeIOSDownloadMobileKeyScreen.verifyContentOnActiveKeyScreen();
    }

    @And("^On the My Key Screen Hotel Name and Room Number should be displayed$")
    public void verifyContentOnActiveKeyScreenStep() {

        allureReportingManager.stepsScreenshots();
    }
}


