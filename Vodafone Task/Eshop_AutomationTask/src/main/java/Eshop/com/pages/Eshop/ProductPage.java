package Eshop.com.pages.Eshop;

import Eshop.com.pages.CommonPages.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends base {

    // TODO: Replace with a more reliable locator if possible >>>>>>>>>>>>> IMPORTANT <<<<<<<<<<<<<<<<<<<<
    private final By AddToCartBTN = By.cssSelector("button.add-to-cart");

    public void ClickOnAddToCartBtn() {
        WebElement cartBTN = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(AddToCartBTN));

        scrollToElement(cartBTN);
        cartBTN.click();
    }

    private void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform(); // You don't need pause here
    }
}
