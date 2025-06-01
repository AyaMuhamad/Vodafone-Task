package steps;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import Eshop.com.pages.CommonPages.base;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Hooks extends base {


    @BeforeAll
    public static void start () {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://eshop.vodafone.com.eg/shop/home");
        driver.manage().window().maximize();
      //  driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @AfterAll
    public static void quit()
    {
        driver.quit();
    }

}

