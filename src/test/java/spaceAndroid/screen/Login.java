package spaceAndroid.screen;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import spaceAndroid.enums.User;
import spaceAndroid.util.AndroidAbstract;

/**
 * Created by raihan on 10/11/16.
 */
public class Login extends AndroidAbstract {
    public Login(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    public void inputEmail(User user) throws Exception{
        androidDriver.findElement(androidMap.getLocator("email")).click();
        androidDriver.findElement(androidMap.getLocator("email")).clear();
        androidDriver.findElement(androidMap.getLocator("email")).sendKeys(user.getEmail());
        androidDriver.hideKeyboard();
    }

    public void inputPassword(User user) throws Exception{
        androidDriver.findElement(androidMap.getLocator("password")).click();
        androidDriver.findElement(androidMap.getLocator("password")).clear();
        androidDriver.findElement(androidMap.getLocator("password")).sendKeys(user.getPassword());
        androidDriver.hideKeyboard();
    }

    public void fillEmail(User user) throws Exception{
        inputText("email", user.getEmail());
    }

    public void fillPassword(User user) throws Exception{
        inputText("password", user.getPassword());
    }

    public void clickLogin() throws Exception{
        androidDriver.findElement(androidMap.getLocator("login")).click();
    }

    public void checkTitle(String title){

    }
}
