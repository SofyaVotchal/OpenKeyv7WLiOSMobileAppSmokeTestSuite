package whitelabelauberge.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WLAubergeIOSSplashScreenSteps extends BaseSteps{

    @Before
    public void setupSteps() {

        setupScreens(driver);
    }

    @Given("^Auberge Des Iles App is installed$")
    public void WLAubergeAppInstallStep() throws InterruptedException {

        //openKeyV7IOSSplashScreen.downloadAndInstallOpenKeyGuestAppFromAppStore();
        //openKeyV7IOSSplashScreen.downloadAndInstallFromTestFlight();
        //wlAubergeSplashScreen.downloadAndInstallFromFirebase();
    }

    @When("^Guest click on Auberge Des Iles app icon$")
    public void launchWLAubergeAppStep() throws InterruptedException {

        //openKeyV7IOSSplashScreen.launchOpenKeyApp();
    }

    @Then("^Auberge Des Iles App launched splash screen should be displayed$")
    public void splashScreenStep() {

        wlAubergeSplashScreen.splashScreen();
    }

    @Then("^Permissions screen should be displayed$")
    public void requiredPermissionsScreenStep() {

        wlAubergeSplashScreen.requiredPermissionsScreen();
    }

    @When("^Guest click on Next button$")
    public void allowNotificationsStep() {

        wlAubergeSplashScreen.requiredPermissionScreenNextButton();
    }

    @Then("^Auberge Des Iles would Like to Send You Notifications prompt should be displayed$")
    public void allowToSendPushNotificationPromptStep() {

        wlAubergeSplashScreen.allowToSendPushNotificationPrompt();
    }

    @When("^Guest allows to Send Push Notifications$")
    public void allowPushNotificationStep() {

        wlAubergeSplashScreen.allowPushNotification();
    }

    @Then("^Auberge Des Iles would Like to Use Bluetooth prompt should be displayed$")
    public void enableBluetoothPromptStep() {

        wlAubergeSplashScreen.enableBluetoothPrompt();
    }

    @When("^Guest allows Bluetooth access$")
    public void allowBluetoothAccessStep() {

        wlAubergeSplashScreen.allowBluetoothAccess();
    }

    @Then("^Allow Auberge Des Iles to use your location prompt should be displayed$")
    public void locationAccessPromptStep() {

        wlAubergeSplashScreen.locationAccessPrompt();
    }

    @When("^Guest selects option Allow While Using App$")
    public void allowWhileUsingAppStep() {

        wlAubergeSplashScreen.allowWhileUsingApp();
    }

    @Then("^Guest navigates to Find My Reservation Screen$")
    public void findMyReservationScreenStep() {

        wlAubergeSplashScreen.findMyReservationScreen();
    }
}
