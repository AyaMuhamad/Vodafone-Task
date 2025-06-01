package Eshop.com.pages.Eshop;

import Eshop.com.pages.CommonPages.base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends base {

    private final By Searchbar = By.id("searchInput");
    private final By ElementAppearance = By.xpath("//p[contains(text(), 'Results For')]");
    private final By PageProducts = By.cssSelector("[id*='details-container']");

    ProductPage productPage = new ProductPage();

    public void AddProductBySearch(String productName, int productIndex) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement searchField = explicitWait.until(ExpectedConditions.elementToBeClickable(Searchbar));

        searchField.sendKeys(productName);
        searchField.sendKeys(Keys.ENTER);

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(ElementAppearance));

        WebElement product = driver.findElements(PageProducts).get(productIndex);
        product.click();
        productPage.ClickOnAddToCartBtn();
    }
}
