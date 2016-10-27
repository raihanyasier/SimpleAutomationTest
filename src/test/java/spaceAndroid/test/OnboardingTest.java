package spaceAndroid.test;

import org.testng.annotations.Test;
import spaceAndroid.screen.Onboarding;
import spaceAndroid.util.AndroidAbstract;

/**
 * Created by raihan on 10/4/16.
 */
public class OnboardingTest extends AndroidAbstract {
    Onboarding board;


    @Test
    public void testDisplayOnboarding() throws Exception {
        board = new Onboarding(androidDriver);
        board.assertOnboardingTitle();
    }

    @Test
    public void testSelectLogin() throws Exception {
        board = new Onboarding(androidDriver);
        board.skipOnboarding();
        board.logIn();
    }
}
