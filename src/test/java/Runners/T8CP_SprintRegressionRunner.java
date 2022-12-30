package Runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(

        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class T8CP_SprintRegressionRunner extends AbstractTestNGCucumberTests {
    @AfterClass // rapor bittiği zaman
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("OS. User Name", System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("User Name", "Team 8");
        ExtentService.getInstance().setSystemInfo("Application Name", "Campus");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Operating System Achitecture", System.getProperty("os.arch"));
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        //ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");
    }
}
