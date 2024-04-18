import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindByAllSet;

public class NewTaskPage extends PageBase{

    public NewTaskPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "edtTaskName")
    MobileElement taskNameText;

    @AndroidFindBy(id = "edtDueD")
    MobileElement dueDateText;

    @AndroidFindBy(id = "button1")
    MobileElement okBtn;

    @AndroidFindBy(id = "fabSaveTask")
    MobileElement saveTaskBtn;

    public void enterTaskName(String taskName){
        clear(taskNameText);
        sendText(taskNameText,taskName);
    }

    public void enterDueDate(){
        click(dueDateText);
        click(okBtn);
    }

    public void saveTask(){
        click(saveTaskBtn);
    }

}
