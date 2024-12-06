package parallel;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author Veena Hegde
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/parallel/RegisterPage.feature",
        glue = {"parallel"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports/Cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/",
                "rerun:target/failedScenarios.txt"
        },
      //  tags = "not @Skip",
        dryRun = false,
        monochrome = true,
        publish = true
)

public class TestRunner {
}
