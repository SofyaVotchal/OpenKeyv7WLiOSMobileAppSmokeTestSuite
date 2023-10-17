package whitelabelauberge.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import whitelabelauberge.setups.CapabilitiesManager;

/**Auberge Guest Mobile iOS App Opening Door Lock Screen*/
public class WLAubergeIOSDoorLockScreenSteps extends BaseSteps {

    @Before
    public void setupSteps() {

        setupScreens(driver);
    }

    @When("^Guest clicks on Key Icon on My Key Screen$")
    public void openMainDoorLockStep() {

        allureReportingManager.stepsScreenshots();
    }

    @Then("^Access Granted check mark should be displayed$")
    public void accessGrantedCheckStep() {

        allureReportingManager.stepsScreenshots();
    }

    @When("^I clicks the main key for given number of times$")
    public void openMainDoorLockMultipleTimesStep() throws InterruptedException {

        //openKeyV7IOSDoorLockScreen.openMainDoorLockMultipleTimes(CapabilitiesManager.lockCounter);
        openKeyV7IOSDoorLockScreen.openMainDoorLockMultipleTimesOEMLocks(CapabilitiesManager.lockCounter);
        //openKeyV7IOSDoorLockScreen.openSuiteRoomFlowMultipleTimesInSeries(CapabilitiesManager.lockCounter);
    }

    @Then("^It should open the lock successfully each time$")
    public void it_should_open_the_lock_successfully_each_time() {

        allureReportingManager.stepsScreenshots();
    }
}


