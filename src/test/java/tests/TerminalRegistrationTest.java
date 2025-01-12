package tests;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TerminalRegistrationTest extends BaseTest {
    LoginPage loginPage;
    OnboardingPage onboardingPage;
    MainPage mainPage;
    OTPPage otpPage;
    TRPage trPage;
    @BeforeClass
    public void setup(){
        loginPage = new LoginPage();
        mainPage = new MainPage();
        otpPage = new OTPPage();
        trPage = new TRPage();
        onboardingPage = new OnboardingPage();
        if (onboardingPage.isFirstTime()){
            onboardingPage.skipOnboardingScreen();
        }
        loginPage.login("wocen96075@nalwan.com", "New1234@");
    }

    @Test(priority = 1)
    public void handleOTP() throws InterruptedException {
        otpPage.enterOTP("111111");
        otpPage.submitOTP();
        trPage.selectFirstStore();
        loginPage.acceptLocationForOncTime();
    }
}
