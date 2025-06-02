package steps.APIAutomationTaskSteps;

import API_Automation_Task.com.pages.AutomationAPITask.APIMainPage;
import io.cucumber.java.en.*;

public class DeleteObjectSteps {
    APIMainPage MainObj = new APIMainPage();

    @Given("the user has an existing object already added")
    public void theUserHasAnExistingObjectAlreadyAdded() {
        MainObj.haveExistingObject();
    }

    @When("the user deletes the object using its ID")
    public void theUserDeletesTheObjectUsingItsID() {
        MainObj.deleteObject();
    }

    @Then("the object should be deleted successfully")
    public void theObjectShouldBeDeletedSuccessfully() {
        MainObj.verifyObjectDeleted();
    }
}
