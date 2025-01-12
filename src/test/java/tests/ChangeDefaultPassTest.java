package tests;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class ChangeDefaultPassTest extends BaseTest {
        private String email = "memof55627@nalwan.com";
        private String defaultPassword = "41687524431";
        private String newPassword = "New1234@";

        LoginPage loginPage;
        OnboardingPage onboardingPage;
        MainPage mainPage;
        ChangeDefaultPasswordPage changeDefaultPasswordPage;
        @BeforeClass
        public void setup(){
            loginPage = new LoginPage();
            mainPage = new MainPage();
            onboardingPage = new OnboardingPage();
            changeDefaultPasswordPage = new ChangeDefaultPasswordPage();
            if (onboardingPage.isFirstTime()){
                onboardingPage.skipOnboardingScreen();
            }
        }
        @Test(priority = 1)
        public void changeDefaultPassword() throws InterruptedException {
            loginPage.login(email, defaultPassword);
            changeDefaultPasswordPage.changePassword(newPassword);
            loginPage.login(email, newPassword);
            loginPage.acceptLocationForOncTime();
        }

}
