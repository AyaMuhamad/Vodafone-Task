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

    @When("User adds two products from the main page")
    public void userAddsTwoProductsFromTheMainPage() {
        mainPage.selectProduct(3, 4);
        mainPage.selectProduct(5, 3);
    }

    @And("User adds one product by searching for a specific item")
    public void userAddsOneProductBySearchingForASpecificItem() {
        searchPage.AddProductBySearch("Iphone 15",1);
    }

    @Then("User should see the three products added to the cart successfully")
    public void userShouldSeeTheThreeProductsAddedToTheCartSuccessfully() {
        mainPage.CheckIfThreeItemsAddedToTheCart();
    }
}
