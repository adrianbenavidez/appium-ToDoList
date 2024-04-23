import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import pageObjects.AllListsPage;
import pageObjects.NewTaskPage;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class ToDoListTest extends TestBase{

    AllListsPage allListPage;
    NewTaskPage newTaskPage;

    @DataProvider(name = "tasks data")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJSONData
                (System.getProperty("user.dir")+"/data/TasksData.json",
                        "Tasks Data", 1);
    }

    @Test(dataProvider = "tasks data")
    public void test_add_task(String taskName) throws MalformedURLException, InterruptedException {
        setUp();
        allListPage = new AllListsPage(driver);
        newTaskPage = new NewTaskPage(driver);

        allListPage.clickAddFirstTaskBtn();
        newTaskPage.enterTaskName(taskName);
        newTaskPage.enterDueDate();
        newTaskPage.enterTime();
        newTaskPage.saveTask();
        allListPage.esperar();

        tearDown();

    }

}
