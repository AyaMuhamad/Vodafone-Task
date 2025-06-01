package Eshop.com.pages.CommonPages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.FluentWait;



public class base {

    public static WebDriver driver;
    public static FluentWait<WebDriver> wait = new FluentWait<>(driver);

}

