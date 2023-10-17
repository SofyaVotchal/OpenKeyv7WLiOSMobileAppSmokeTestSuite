package whitelabelauberge.steps;

import io.appium.java_client.ios.IOSDriver;
import whitelabelauberge.screens.WLAubergeIOSDoorLockScreen;
import whitelabelauberge.screens.WLAubergeIOSDownloadMobileKeyScreen;
import whitelabelauberge.screens.WLAubergeIOSLoginScreen;
import whitelabelauberge.screens.WLAubergeIOSSplashScreen;
import whitelabelauberge.setups.CapabilitiesManager;

public class BaseSteps extends CapabilitiesManager {

    protected WLAubergeIOSSplashScreen wlAubergeSplashScreen;
    protected WLAubergeIOSLoginScreen wlAubergeLoginScreen;
    protected WLAubergeIOSDownloadMobileKeyScreen wlAubergeIOSDownloadMobileKeyScreen;
    protected WLAubergeIOSDoorLockScreen openKeyV7IOSDoorLockScreen;

    public void setupScreens(IOSDriver driver) {

        wlAubergeSplashScreen = new WLAubergeIOSSplashScreen(driver);
        wlAubergeLoginScreen = new WLAubergeIOSLoginScreen(driver);
        wlAubergeIOSDownloadMobileKeyScreen = new WLAubergeIOSDownloadMobileKeyScreen(driver);
        openKeyV7IOSDoorLockScreen = new WLAubergeIOSDoorLockScreen(driver);
    }
}


