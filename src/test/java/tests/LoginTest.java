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
            loginPage.login("himilof721@eoilup.com", "New1234@");
    }

    @Test
    public void invalidLogin_emptyUserNameTest(){
        loginPage.login("", "10203040");
        Assert.assertEquals(loginPage.getEmailErrorText(), "Required");
    }

    @Test
    public void invalidLogin_emptyPasswordTest(){
        loginPage.login("bob@example.com", "");
        Assert.assertEquals(loginPage.getPasswordErrorText(), "Required");
    }

    @Test(dataProvider = "invalid-login-dataProvider")
    public void invalidLogin_Test(String uName, String password, String errorText){
        loginPage.login(uName, password);
        Assert.assertEquals(loginPage.getCredErrorText(), errorText);
        loginPage.clickOk();
    }

    @DataProvider(name = "invalid-login-dataProvider")
    public Object[][] dataProviderArr() {

        Object object[][] = { { "bob@example.com", "10203040" ,"Email or password not correct"},
                              { "bob@example.com", "10203040", "Email or password not correct" },
        };
        return object;
    }


}
