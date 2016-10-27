package space.util;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import spaceAndroid.util.Mapping;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by raihan on 6/28/16.
 */
public abstract class Abstract {
    protected IOSDriver driver;
    protected Mapping map = new Mapping("/Users/raihan/IdeaProjects/Space/src/test/java/space/util/spaceui.properties");

    protected int runID = 866;
    protected int testID;
    protected int status;
    protected String result;

    @BeforeMethod
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium-version", "1.5.2");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "8.4");
        caps.setCapability("bundleId", "com.ph.space.SPACE-iOS-STG");
        caps.setCapability("appName", "SPACE");
        caps.setCapability("deviceName", "iPhone 6");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
