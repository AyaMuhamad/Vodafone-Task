package steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/APIAutomationTask/APIObject.feature",
                "src/test/resources/DogsAPI/DogApi.feature"
        },
        glue = {"steps"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        }
)

public class runner extends AbstractTestNGCucumberTests {
}
