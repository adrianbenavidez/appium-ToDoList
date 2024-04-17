import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    AppiumDriver driver;
    public static final long WAIT = 10;

    public PageBase(AppiumDriver appiumDriver){
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        driver = appiumDriver;
    }

    public void waitForVisivility(MobileElement element){
        WebDriverWait wait = new WebDriverWait(driver,WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clear(MobileElement element){
        waitForVisivility(element);
        element.clear();
    }

    public void click(MobileElement element){
        waitForVisivility(element);
        element.click();
    }

    public void sendText(MobileElement element, String text){
        waitForVisivility(element);
        element.sendKeys(text);
    }

    public String getAttribute(MobileElement element, String attribute){
        waitForVisivility(element);
        return element.getAttribute(attribute);
    }



}
