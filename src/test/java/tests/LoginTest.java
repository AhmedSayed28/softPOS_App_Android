package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTest extends BaseTest {
    LoginPage loginPage;
    @BeforeClass
    public void setup(){
         loginPage = new LoginPage();
    }

    @Test
    public void validLoginTest(){
            loginPage.login("bob@example.com", "10203040");
    }

    @Test
    public void invalidLogin_emptyUserNameTest(){
        loginPage.login("", "10203040");
        Assert.assertEquals(loginPage.getEmailErrorText(), "Email is required");
    }

    @Test
    public void invalidLogin_emptyPasswordTest(){
        loginPage.login("bob@example.com", "");
        Assert.assertEquals(loginPage.getPasswordErrorText(), "Password is required");
    }

//    @DataProvider(name = "invalid-login-dataProvider")
//    public Object[][] dataProviderArr() {
//
//        Object object[][] = { { "bob@example.com", "1234" ,"Provided credentials do not match any user in this service."},
//                              { "bob@example", "10203040", "Provided credentials do not match any user in this service." },
//        };
//        return object;
//    }


}
