package steps;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/APIAutomationTask/APIObject.feature"},
        glue = {"steps"},tags = " ",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class runner extends AbstractTestNGCucumberTests {
}

