package Eshop.com.pages.Eshop;

import Eshop.com.pages.CommonPages.base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class MainPage_AddProducts extends base {

    By UserAccount = By.id("sl-nav-bar-img=3");
    By MainPageButton = By.id("home-button-1");
    By Tabs = By.cssSelector("[class*='item ng-star-inserted']");
    By PageProducts = By.cssSelector("[id*='details-container']");
    By UserProfileMenu = By.id("userProfileMenu");
    By AcceptCookies = By.id("onetrust-accept-btn-handler");
    By CartIcon = By.id("sl-nav-bar-img=4");
    By CartItemNumber = By.cssSelector(".cart-card.ng-star-inserted");
  //  By RemoveIcon = By.className(".cart-actions");
    By Trash = By.cssSelector("img[src=\"/assets/images/delete-system.png\"]");

    ProductPage productPage = new ProductPage();

    public void ProceedToHomePage() {
        WebElement MainPageBTN = new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(MainPageButton));
        MainPageBTN.click();
    }

    public void ClickOnUserProfileIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(webDriver -> Objects.equals(((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState"), "complete"));

        driver.findElements(AcceptCookies).stream().findAny().ifPresent(WebElement::click);
        WebElement UserAccountIcon = new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(UserAccount));
        UserAccountIcon.click();
    }

    public void CheckUserProfileAppearance() {
        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(80));
        localWait.until(ExpectedConditions.visibilityOfElementLocated(UserProfileMenu));
        Assert.assertTrue(driver.findElement(UserProfileMenu).isDisplayed());
    }

//    public void CheckCart(){
//        if(driver.findElement(CartIcon).isEnabled()){
//            List<WebElement> RemovedItems = driver.findElements(RemoveIcon);
//            for(int i =0 ; i< RemovedItems.size(); i++){
//                driver.findElement(Trash).click();
//            }
//        }
//    }

    public void selectProduct(int i, int j) {
        List<WebElement> tabs = driver.findElements(Tabs);
        if (i >= tabs.size()) {
            throw new IllegalArgumentException("Tab index is out of range");
        }

        Actions actions = new Actions(driver);

        WebElement selectedTab = tabs.get(i);
        actions.moveToElement(selectedTab).pause(Duration.ofSeconds(1)).click().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PageProducts));

        List<WebElement> products = driver.findElements(PageProducts);
        if (j >= products.size()) {
            throw new IllegalArgumentException("Product index is out of range");
        }

        WebElement selectedProduct = products.get(j);
        actions.moveToElement(selectedProduct).pause(Duration.ofSeconds(1)).click().perform();

        productPage.ClickOnAddToCartBtn();
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(webDriver -> Objects.equals(((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState"), "complete"));
    }



    public void CheckIfThreeItemsAddedToTheCart() {
        driver.findElement(CartIcon).click();

        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(webDriver -> Objects.equals(((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState"), "complete"));

        List<WebElement> items = driver.findElements(CartItemNumber);
        int actualCount = items.size();
        Assert.assertEquals(actualCount, 3);
    }
}
