package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ToDoListTestNG {

    AndroidDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
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

        driver = new AndroidDriver<MobileElement>(url, caps);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("Application Started...");
    }


    @Test
    public void clickAllListTest() {

        MobileElement meAllListButton = driver.findElement(By.id("spinnerToolbar"));
        meAllListButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("Test clickAllListTest Started...");
    }

   /* @Test
    public void clickOptionsTest() {
        MobileElement mePlusButton = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='More options']"));
        mePlusButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        MobileElement result = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.splendapps.splendo:id/title' and @text='Task Lists']"));

        System.out.println("Resultado: " + result.getText());

        Assert.assertEquals(result.getText(), "Task Lists");

    }
*/

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Application Completed...");
    }


}
