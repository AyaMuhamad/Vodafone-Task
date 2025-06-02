package steps;

import Eshop.com.pages.CommonPages.base;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ExtentReportManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.time.Duration;

public class Hooks extends base {

    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeAll
    public static void setUpReport() {
        extent = ExtentReportManager.getInstance();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        base.setDriver(driver);

        driver.get("https://eshop.vodafone.com.eg/shop/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Before
    public void createScenarioLog(Scenario scenario) {
        test = extent.createTest(scenario.getName());
    }

    @After
    public void captureStatus(Scenario scenario) {
        if (scenario.isFailed()) {
            test.fail("Scenario failed: " + scenario.getName());
        } else {
            test.pass("Scenario passed: " + scenario.getName());
        }
    }

    @AfterAll
    public static void tearDownReport() {
        driver.quit();
        extent.flush();
    }
}
