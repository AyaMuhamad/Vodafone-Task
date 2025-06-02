package steps.Eshop;

import Eshop.com.pages.Eshop.MainPage_AddProducts;
import Eshop.com.pages.Eshop.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainPage_AddProductsToCart {

    MainPage_AddProducts mainPage = new MainPage_AddProducts();
    SearchPage searchPage = new SearchPage();

    @Given("User is on the Main Page")
    public void userIsOnTheMainPage() {
        mainPage.CheckUserProfileAppearance();
    }


    @Then("User should see the three products added to the cart successfully")
    public void userShouldSeeTheThreeProductsAddedToTheCartSuccessfully() {
        mainPage.CheckIfThreeItemsAddedToTheCart();
    }

@When("User adds a product from tab number {int} and selects product number {int}")
public void userAddsFirstProductFromTab(int tabNum, int productNum) {
    mainPage.selectProduct(tabNum, productNum);
}

    @And("User adds another product from tab number {int} and selects product number {int}")
    public void userAddsSecondProductFromTab(int tabNum, int productNum) {
        mainPage.selectProduct(tabNum, productNum);
    }

    @And("User searches for {string} and selects product number {int}")
    public void userAddsProductBySearch(String searchTerm, int productNum) {
        searchPage.AddProductBySearch(searchTerm, productNum);
    }
}
