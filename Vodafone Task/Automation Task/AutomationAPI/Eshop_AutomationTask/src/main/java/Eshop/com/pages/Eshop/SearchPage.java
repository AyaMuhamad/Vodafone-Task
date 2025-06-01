package Eshop.com.pages.Eshop;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class SearchPage extends MainPage_AddProducts {
    By Searchbar = By.id("searchInput");
    By ElementAppearance = By.xpath("//p[contains(text(), 'Results For')]");
    MainPage_AddProducts MainObj = new MainPage_AddProducts();

    public void AddProductBySearch(int i) {

        driver.findElement(Searchbar).sendKeys("Iphone 15");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).pause(30).build().perform();
        wait.until(driver1 -> {
            WebElement element = driver1.findElement(ElementAppearance);
            return element.isDisplayed();
        });

        MainObj.selectProduct(i);
    }

}
