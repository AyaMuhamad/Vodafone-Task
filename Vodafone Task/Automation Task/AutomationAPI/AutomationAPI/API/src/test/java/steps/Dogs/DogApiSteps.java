package steps.Dogs;

import DogsRandomImages.DogsAPI;
import io.cucumber.java.en.*;


public class DogApiSteps {

    private final DogsAPI dogApi = new DogsAPI();

    @Given("I send a GET request to the endpoint {string}")
    public void iSendAGETRequestTo(String endpoint) {
        dogApi.sendRequest(endpoint);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        dogApi.checkStatusCode(expectedStatusCode);
    }

    @And("the response content type should be {string}")
    public void theResponseContentTypeShouldBe(String expectedContentType) {
        dogApi.checkContentType(expectedContentType);
    }

    @And("the response should contain a valid image URL")
    public void theResponseShouldContainAValidImageURL() {
        dogApi.checkImageUrlIsValid();
    }

    @And("the response should not contain a valid image URL")
    public void theResponseShouldNotContainAValidImageURL() {
        dogApi.checkImageUrlIsInvalid();
    }
    @Then("the response shouldn't contain a valid image URL")
    public void theResponseShouldNotContainAValidImageUrl() {
        dogApi.checkImageUrlIsInvalid();
    }

}
