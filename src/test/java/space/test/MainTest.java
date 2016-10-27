package space.test;

import org.testng.annotations.Test;
import space.screen.MainScreen;
import spaceAndroid.util.APIException;
import space.util.Abstract;

/**
 * Created by raihan on 6/28/16.
 */
public class MainTest extends Abstract{
    MainScreen main;

    @Test
    public void testSelectCurrentLocation() throws Exception, APIException {
        try {
            testID = 39416;
            main = new MainScreen(driver);
            main.tapLocation();
            main.selectCurrentLocation();
            result = "passed";
            status = 1;
        } catch (Exception e){
            e.printStackTrace();
            result = "failed";
            status = 5;
        }finally {
            APIException test = new APIException("");
            test.sendTestRail(status, result, runID, testID);
        }
    }
}
