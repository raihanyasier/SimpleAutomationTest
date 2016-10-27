package spaceAndroid.test;

import org.testng.annotations.Test;
import spaceAndroid.enums.User;
import spaceAndroid.screen.Login;
import spaceAndroid.screen.Onboarding;
import spaceAndroid.util.APIException;
import spaceAndroid.util.AndroidAbstract;

/**
 * Created by raihan on 10/11/16.
 */
public class LoginTest extends AndroidAbstract {
    Onboarding board;
    Login log;

    @Test
    public void testLoginValidData() throws Exception, APIException {
        try {
            testId = 39468;
            board = new Onboarding(androidDriver);
            board.skipOnboarding();
            board.logIn();
            log = new Login(androidDriver);
            log.inputEmail(User.INVALID);
            log.inputPassword(User.INVALID);
            log.clickLogin();
            testResult = "passed";
            testStatus = 1;
        }catch (Exception e){
            e.printStackTrace();
            testResult = "failed";
            testStatus = 5;
        }finally {
            APIException testrail = new APIException("");
            testrail.sendTestRail(testStatus,testResult,runId,testId);
        }
    }

    @Test
    public void testLoginInvalidData() throws Exception {
        click("skip");
        click("login");
        log = new Login(androidDriver);
        log.fillEmail(User.INVALID);
        log.fillPassword(User.INVALID);
        click("login");
    }
}
