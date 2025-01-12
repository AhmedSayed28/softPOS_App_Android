package tests;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.OnboardingPage;

public class NormalPaymentTest extends BaseTest {
    private String email = "memof55627@nalwan.com";
    private String newPassword = "New1234@";
    private String amount = "1234";
    LoginPage loginPage;
    OnboardingPage onboardingPage;
    MainPage mainPage;
    @BeforeClass
    public void setup(){
        loginPage = new LoginPage();
        mainPage = new MainPage();
        onboardingPage = new OnboardingPage();
        if (onboardingPage.isFirstTime()){
            onboardingPage.skipOnboardingScreen();
        }
        loginPage.login(email, newPassword);
    }

    @Test(priority = 1)
    public void makeNormalPaymentTest() throws InterruptedException {
        Thread.sleep(1000);
        mainPage.clickNewPayment();
        mainPage.makeNormalPayment(amount);
//        loginPage.acceptLocationForOncTime();
        Thread.sleep(1000);
        mainPage.enterCardPassword();
    }


}
