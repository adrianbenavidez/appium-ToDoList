package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AllListsPage extends PageBase{

    public AllListsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "fabAddTask")
    MobileElement addFirstTaskBtn;

    public void clickAddFirstTaskBtn(){
        click(addFirstTaskBtn);
    }

}
