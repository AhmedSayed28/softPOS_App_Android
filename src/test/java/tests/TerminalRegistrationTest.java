package tests;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TerminalRegistrationTest extends BaseTest {
    private static final String EMAIL = "enter email";
    private static final String PASSWORD = "enter password";

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
        loginPage.login(EMAIL, PASSWORD);
    }

    @Test(priority = 1)
    public void handleOTP() throws InterruptedException {
        otpPage.enterOTP("111111");
        otpPage.submitOTP();
        trPage.selectFirstStore();
        loginPage.acceptLocationForOncTime();
    }
}
