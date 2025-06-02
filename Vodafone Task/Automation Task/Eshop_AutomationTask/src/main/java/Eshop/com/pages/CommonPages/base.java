package Eshop.com.pages.CommonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class base {
    public static WebDriver driver;
    public static FluentWait<WebDriver> wait;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }
}
