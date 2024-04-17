import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ToDoList {

    static AppiumDriver driver;

    public static void main(String[] args) {

        try {
            openToDoListApp();
        } catch (Exception exp) {
            System.out.println("Cause is: " + exp.getCause());
            System.out.println("Message is: " + exp.getMessage());
            exp.printStackTrace();
        }
    }

    public static void openToDoListApp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium Phone API 31");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.splendapps.splendo");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.splendapps.splendo.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, caps);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("Application Started...");

        MobileElement mePlusButton = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='More options']"));

        mePlusButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        MobileElement result = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.splendapps.splendo:id/title' and @text='Task Lists']"));

        System.out.println("Resultado: " + result.getText());

        Assert.assertEquals(result.getText(),"Task Lists");

    }

}
