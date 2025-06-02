package steps;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/Eshop/AddProductsToCart.feature"},
        glue = {"steps"},tags =" ",
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/reports/report.html"
        }
)
public class runner extends AbstractTestNGCucumberTests {
}


