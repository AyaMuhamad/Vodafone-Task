package Eshop.com.pages.Eshop;

import Eshop.com.pages.CommonPages.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ProductPage extends base {

    By AddToCartBTN = By.xpath("//div[1]/div[1]/div/div[2]/div");

    public void ClickOnAddToCartBtn()  {
        WebElement CartBTN = driver.findElement(AddToCartBTN);
        scroll(CartBTN);
        driver.findElement(AddToCartBTN).click();
    }

    public void scroll(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).pause(30).perform();
    }


}
