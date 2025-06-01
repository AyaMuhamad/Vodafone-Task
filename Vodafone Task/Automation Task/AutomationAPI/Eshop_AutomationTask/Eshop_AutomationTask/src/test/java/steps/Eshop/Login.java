package steps.Eshop;

import Eshop.com.pages.Eshop.LoginPage;
import Eshop.com.pages.Eshop.MainPage_AddProducts;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

    MainPage_AddProducts mainPageObj = new MainPage_AddProducts();
    LoginPage loginPageObj = new LoginPage();

    @Given("User is on the Login Page")
    public void userIsOnTheLoginPage() {
        mainPageObj.ProceedToHomePage();
        mainPageObj.ClickOnUserProfileIcon();
    }

    @When("User Fill {string} And {string}")
    public void userFillAnd(String username, String password) {
        loginPageObj.EnterUsername(username);
        loginPageObj.EnterPassword(password);
        loginPageObj.ClickOnLoginButton();
    }

    @Then("User logs in successfully")
    public void userLogsInSuccessfully() {
        mainPageObj.CheckUserProfileAppearance();
    }
}
