package steps.APIAutomationTaskSteps;

import API_Automation_Task.com.pages.AutomationAPITask.APIMainPage;
import io.cucumber.java.en.*;

public class AddObjectSteps {
    APIMainPage APIAddObj = new APIMainPage();

    @Given("the user adds an object with required data")
    public void theUserAddsAnObjectWithRequiredData() {
        APIAddObj.addObject();
    }

    @Then("the object should be added successfully")
    public void theObjectShouldBeAddedSuccessfully() {
        APIAddObj.verifyObjectAdded();
    }
}
