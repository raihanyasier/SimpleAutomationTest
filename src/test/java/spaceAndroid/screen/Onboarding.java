package spaceAndroid.screen;

import io.appium.java_client.android.AndroidDriver;
import spaceAndroid.util.AndroidAbstract;

/**
 * Created by raihan on 10/4/16.
 */
public class Onboarding extends AndroidAbstract {
    public Onboarding(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    public void skipOnboarding() throws Exception {
        androidDriver.findElement(androidMap.getLocator("skip")).click();
    }

    public void getStarted() throws Exception{
        androidDriver.findElement(androidMap.getLocator("started")).click();
    }

    public void logIn() throws Exception{
        androidDriver.findElement(androidMap.getLocator("login")).click();
    }

    public void signUp() throws Exception{
        androidDriver.findElement(androidMap.getLocator("signup")).click();
    }

    public void assertOnboardingTitle() throws Exception {
        System.out.println(androidDriver.findElement(androidMap.getLocator("onboardTitle")).getText());
        if (androidDriver.findElement(androidMap.getLocator("onboardTitle")).getText().equals("HELLO\nWORLD")){
            System.out.print("OK");
        }else {
            throw new Exception("No!");
        }
    }

}
