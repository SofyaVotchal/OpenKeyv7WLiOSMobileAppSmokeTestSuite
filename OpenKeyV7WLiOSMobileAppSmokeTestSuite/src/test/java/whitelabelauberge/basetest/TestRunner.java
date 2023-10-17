package whitelabelauberge.basetest;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import whitelabelauberge.reporting.AllureReport;
import whitelabelauberge.setups.CapabilitiesManager;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

@CucumberOptions(
        monochrome = true,
        features = "src/main/com.openkey.resources/features",
        glue = {"whitelabelauberge.steps", "whitelabelauberge.reporting"},
        publish = true,
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","whitelabelauberge.reporting.AllureReportingManager"}
)

public class TestRunner extends CapabilitiesManager {

    private TestNGCucumberRunner testNGCucumberRunner;
    static AllureReport allureReport ;

    public TestRunner() {

        allureReport = new AllureReport();
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeTest(alwaysRun = true)
    public void cleanOldReportsData() throws IOException {

        allureReport.cleanUpAllureDirectory();
    }

    @Test(groups = "cucumber", description = "Run Cucumber Features.", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {

        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    //If any step method failing execution failed at this point executions stopped
    @AfterMethod
    public void haltExecutionOnFailure(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            allureReportingManager.stepsScreenshots();
            testNGCucumberRunner.finish();
        }
    }

    @DataProvider
    public Object[][] scenarios() {

        return testNGCucumberRunner.provideScenarios();
    }

    @AfterTest (alwaysRun = true)
    public void createPropFile() throws IOException {

        allureReport.envFileWriter();
        allureReport.executorFileWriter();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {

        /*if (driver.removeApp("co.openkey.aubergeDesIles")) {
            System.out.println("App is uninstalled");
        }*/
        testNGCucumberRunner.finish();
    }
}


