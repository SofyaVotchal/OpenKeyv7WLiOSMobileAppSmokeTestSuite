package whitelabelauberge.screens;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {

    protected IOSDriver driver;
    protected WebDriverWait wait;

    public BaseScreen(IOSDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(80));
    }

    protected void click(By by) {

        driver.findElement(by).click();
    }
}
