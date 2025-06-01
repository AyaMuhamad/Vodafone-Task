package Eshop.com.pages.Eshop;

import Eshop.com.pages.CommonPages.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;


public class MainPage_AddProducts extends base {
    By UserAccount = By.id("sl-nav-bar-img=3");
    By MainPageButton = By.id("home-button-1");
    By Tabs= By.cssSelector("[Class*='item ng-star-inserted']");
    By PageProducts = By.cssSelector("[id*='details-container']");
    By UserProfileMenu = By.id("userProfileMenu");
    By AcceptCookies = By.id("onetrust-accept-btn-handler");
    By CartCount = By.cssSelector("#sl-nav-bar-btn\\=3 > span");

    ProductPage ProductObj = new ProductPage();

    List<WebElement> EshopTabs = driver.findElements(Tabs);
    List<WebElement> Products= driver.findElements(PageProducts);


    public void ProceedToHomePage() {
        driver.findElement(MainPageButton).click();
    }

    public void ClickOnUserProfileIcon() {
        driver.findElements(AcceptCookies).stream().findAny().ifPresent(WebElement::click);
        driver.findElement(UserAccount).click();
    }

    public void CheckUserProfileAppearance() {
        wait.withTimeout(Duration.ofSeconds(80)).pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
        Assert.assertTrue(driver.findElement(UserProfileMenu).isDisplayed());
    }


    public void clickTabAndSelectProduct(WebElement tabElement, WebElement productElement){
        tabElement.click();
        productElement.click();
        ProductObj.ClickOnAddToCartBtn();
    }

    public void clickTabAndSelectProduct(WebElement productElement){
        productElement.click();
        ProductObj.ClickOnAddToCartBtn();
    }

    public void selectProduct(int j) {
        clickTabAndSelectProduct(Products.get(j));
    }

    public void selectProduct(int i, int j) {
        clickTabAndSelectProduct(EshopTabs.get(i), Products.get(j));
    }


    public void CheckIfThreeItemsAddedToTheCart(){
        wait.withTimeout(Duration.ofSeconds(80)).pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
        driver.navigate().refresh();
        String actualCount = driver.findElement(CartCount).getText();
        Assert.assertEquals(actualCount, "3");
    }

}

