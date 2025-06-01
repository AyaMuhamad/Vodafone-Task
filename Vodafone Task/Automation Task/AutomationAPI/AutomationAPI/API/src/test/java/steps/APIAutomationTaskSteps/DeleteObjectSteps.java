package steps.APIAutomationTaskSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import API_Automation_Task.com.pages.AutomationAPITask.APIMainPage;


public class DeleteObjectSteps {
    APIMainPage MainObj = new APIMainPage();
    @Given("User has have an existing object added before")
    public void userHasAnExistingObjectAddedBefore() {
        MainObj.haveExistingObject();
    }

    @When("User delete the object using its ID")
    public void userDeleteTheObjectUsingItsID() {
        MainObj.deleteObject();
    }

    @Then("The object will be deleted successfully")
    public void theObjectWillBeDeletedSuccessfully() {
        MainObj.verifyObjectDeleted();
    }
}
