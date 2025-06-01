package steps.Eshop;

import Eshop.com.pages.Eshop.MainPage_AddProducts;
import Eshop.com.pages.Eshop.ProductPage;
import Eshop.com.pages.Eshop.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;

public class MainPage_AddProductsToCart {

    MainPage_AddProducts MainPageObj = new MainPage_AddProducts();
    SearchPage SearchPageObj = new SearchPage();
    @Given("User is on the Main Page")
    public void userIsOnTheMainPage() {
        MainPageObj.CheckUserProfileAppearance();
    }

    @When("User adds two products from the main page")
    public void userAddsTwoProductsFromTheMainPage() throws InterruptedException {
       MainPageObj.selectProduct(3 , 4);
        MainPageObj.selectProduct(5, 3);

    }

    @And("User adds one product by searching for a specific item")
    public void userAddsOneProductBySearchingForASpecificItem() throws InterruptedException {
        SearchPageObj.AddProductBySearch(1);
    }

    @Then("User should see the three products added to the cart successfully")
    public void userShouldSeeTheThreeProductsAddedToTheCartSuccessfully() {
        MainPageObj.CheckIfThreeItemsAddedToTheCart();
    }


}
