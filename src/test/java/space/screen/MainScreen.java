package space.screen;

import io.appium.java_client.ios.IOSDriver;
import space.util.Abstract;

/**
 * Created by raihan on 6/28/16.
 */
public class MainScreen extends Abstract{
    public MainScreen(IOSDriver driver){
        this.driver = driver;
    }

    public void tapLocation() throws Exception{
        driver.findElement(map.getLocator("location")).click();
    }

    public void selectCurrentLocation() throws Exception {
        driver.findElement(map.getLocator("current_location")).click();
    }

    public void openDateSelection() throws Exception{
        driver.findElement(map.getLocator("date_section")).click();
    }

    public void selectCheckInDate() throws Exception {
        driver.findElement(map.getLocator("check_in")).click();
    }
}
