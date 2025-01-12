package tests;

import base.BaseTest;
import base.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OnboardingPage;


public class LoginTest extends BaseTest {
    LoginPage loginPage;
    OnboardingPage onboardingPage;
    @BeforeClass
    public void setup(){
         loginPage = new LoginPage();
         onboardingPage = new OnboardingPage();
         if (onboardingPage.isFirstTime()){
             onboardingPage.skipOnboardingScreen();
         }
    }

    @Test(priority = 1)
    public void invalidLogin_emptyUserNameTest(){
        loginPage.login("", "10203040");
        Assert.assertEquals(loginPage.getEmailErrorText(), "Required");
    }

    @Test(priority = 2)
    public void invalidLogin_emptyPasswordTest(){
        loginPage.login("bob@example.com", "");
        Assert.assertEquals(loginPage.getPasswordErrorText(), "Required");
    }

    @Test(priority = 3)
    public void invalidLogin_InvalidCredTest(){
        loginPage.login("bob@example.com", "New1234@");
        Assert.assertEquals(loginPage.getCredErrorText(), "Email or password not correct");
        loginPage.clickOk();



    }


    @Test(priority = 4)
    public void validLoginTest(){
        loginPage.login("ahm.say14@gmail.com", "New2234@");
        Assert.assertFalse(loginPage.isLoginLogoDisplayed());
        Assert.assertFalse(loginPage.isErrorDisplayed());
        loginPage.acceptLocationForOncTime();
    }


}
