package steps.APIAutomationTaskSteps;

import io.cucumber.java.en.*;
import API_Automation_Task.com.pages.AutomationAPITask.APIMainPage;

public class AddObjectSteps {
    APIMainPage AddObj= new APIMainPage();
    @Given("User add an object with required data")
    public void userAddAnObjectWithRequiredData() {
        AddObj.AddObject();
    }

    @Then("The object will be added successfully")
    public void theObjectWillBeAddedSuccessfully() {
        AddObj.verifyObjectAdded();

    }
}
