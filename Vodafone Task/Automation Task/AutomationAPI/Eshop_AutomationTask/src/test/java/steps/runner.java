package steps;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/Eshop/AddProductsToCart.feature"},
        glue = {"steps"},tags =" ",
        plugin = {"pretty", "html:target/reports/report.html"}
)
public class runner extends AbstractTestNGCucumberTests {
}


 