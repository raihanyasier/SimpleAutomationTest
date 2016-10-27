package spaceAndroid.util;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mexan on 10/4/16.
 */
public abstract class AndroidAbstract {
    protected AndroidDriver androidDriver;
    protected WebDriver driver;
    protected Mapping androidMap = new Mapping("/Users/raihan/IdeaProjects/Space/src/test/java/spaceAndroid/util/spaceandroid.properties");
    protected int runId = 866;
    protected String testResult;
    protected int testStatus;
    protected int testId;

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.5.2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability("appPackage", "ph.com.space.integration");
        capabilities.setCapability("deviceName", "Galaxy S5");
        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() throws Exception {
        androidDriver.quit();
    }

    protected void click(String element) throws Exception {
        androidDriver.findElement(androidMap.getLocator(element)).click();
    }

    protected void inputText(String element, String text) throws Exception {
        click(element);
        androidDriver.findElement(androidMap.getLocator(element)).clear();
        androidDriver.findElement(androidMap.getLocator(element)).sendKeys(text);
        androidDriver.hideKeyboard();
    }

    public void assertTitle(String element, String title) throws Exception {
        if (androidDriver.findElement(androidMap.getLocator(element)).getText().equals(title)){
            System.out.print("OK");
        }else {
            throw new Exception("No!");
        }
    }
}
