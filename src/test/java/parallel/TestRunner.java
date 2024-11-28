package parallel;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author Veena Hegde
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/parallel",
        glue = {"parallel"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports/Cucumber.json"
        },
        dryRun = false,
        monochrome = true,
        publish = true
)

public class TestRunner {
}
