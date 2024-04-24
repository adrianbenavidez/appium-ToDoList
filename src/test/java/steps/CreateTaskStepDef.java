package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AllListsPage;
import pageObjects.NewTaskPage;
import tests.TestBase;

import java.net.MalformedURLException;

public class CreateTaskStepDef extends TestBase {

    AllListsPage allListPage;
    NewTaskPage newTaskPage;

    @Given("Click Add new Task")
    public void clickAddNewTask() throws MalformedURLException {
        setUp();
        allListPage = new AllListsPage(driver);
        newTaskPage = new NewTaskPage(driver);

        allListPage.clickAddFirstTaskBtn();
    }

    @Given("Enter Due Date")
    public void enterDueDate() {
        newTaskPage.enterDueDate();
    }

    @Given("Enter Taskname")
    public void enterTaskname() {
        newTaskPage.enterTaskName("Taks 1");
    }

    @Given("Enter Time")
    public void enterTime() {
        newTaskPage.enterTime();
    }

    @When("Click Save")
    public void clickSave() {
        newTaskPage.saveTask();
    }

    @Then("Task added successfully")
    public void taskAddedSuccessfully() {
        driver.hideKeyboard();
    }

    @Given("Enter {string}")
    public void enter(String taskName) {
        newTaskPage.enterTaskName(taskName);
    }
}
