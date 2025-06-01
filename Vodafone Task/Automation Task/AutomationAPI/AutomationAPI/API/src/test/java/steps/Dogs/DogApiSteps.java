package steps.Dogs;

import DogsRandomImages.DogsAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DogApiSteps {

    DogsAPI DogImgObj =new DogsAPI();
    @Given("I send a GET request to the endpoint {string}")
    public void iSendAGETRequestTo(String arg0) {
        DogImgObj.SendRequest(arg0);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int arg0) {
        DogImgObj.CheckTheStatusCode(arg0);
    }

    @And("the response content type should be {string}")
    public void theResponseContentTypeShouldBe(String arg0) {
        DogImgObj.CheckTheContentType(arg0);
    }

    @And("the response should contain a valid image URL")
    public void theResponseShouldContainAValidImageURL() {
        DogImgObj.CheckTheResponseContainTheDogImage();
    }

    @And("the response shouldn't contain a valid image URL")
    public void theResponseShouldNotContainAValidImageURL() {
        DogImgObj.CheckTheInvalidResponse();
    }
}
