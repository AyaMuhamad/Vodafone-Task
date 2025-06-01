package Eshop.com.pages.Eshop;

import Eshop.com.pages.CommonPages.base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends base {
    public LoginPage(){}
    By MobileNumber = By.id("username");
    By Password = By.id("password");
    By LoginBtn = By.id("submitBtn");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));

    public void EnterUsername(String username) {
        WebElement mobileField = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileNumber));
        mobileField.sendKeys(username);
    }

    public void EnterPassword(String pass) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
        passwordField.sendKeys(pass);
    }

    public void ClickOnLoginButton() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).pause(30).build().perform();

    }
}
