package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.LoginPage;

public class ChangePasswordTest extends BaseTest {
    LoginPage loginPage;
    ChangePasswordPage changePasswordPage ;

    @BeforeClass
    public void setup() {
        loginPage = new LoginPage();
        changePasswordPage = new ChangePasswordPage();
    }

    @Test
    public void validoldAndNew() {
        loginPage.login("safimoc246@sfxeur.com", "Test@123");
        changePasswordPage.clickProfileBtn();
         changePasswordPage.clickSettingBtn();
       changePasswordPage.clickChangePasswordBtn();
       changePasswordPage.enterold("Test@123");
       changePasswordPage.enterNew("Test@123");
     changePasswordPage.clickSaveBtn();
      Assert.assertEquals(new ChangePasswordPage().isChangePasswordSuccessful(), "Done");
    }
    @Test
    public void invalidOld()
    {
loginPage.login("safimoc246@sfxeur.com", "Test@123");
        changePasswordPage.clickProfileBtn();
        changePasswordPage.clickSettingBtn();
        changePasswordPage.clickChangePasswordBtn();
        changePasswordPage.enterold("234");
        changePasswordPage.enterNew("Test@123");
        changePasswordPage.clickSaveBtn();
        Assert.assertFalse(new ChangePasswordPage().isOldWrong(),"wrong old password");
    }

    @Test
    public void invalidNewCred()
    {
        loginPage.login("safimoc246@sfxeur.com", "Test@123");
        changePasswordPage.clickProfileBtn();
        changePasswordPage.clickSettingBtn();
        changePasswordPage.clickChangePasswordBtn();
        changePasswordPage.enterold("fgdf@123");
        changePasswordPage.enterNew("Te");
        changePasswordPage.clickSaveBtn();
        Assert.assertEquals(new ChangePasswordPage().isWrongNewCred(),"Password must be at least 8 characters long.");
    }

    @Test
    public void emptyOldPass()
    {
    loginPage.login("safimoc246@sfxeur.com", "Test@123");
        changePasswordPage.clickProfileBtn();
        changePasswordPage.clickSettingBtn();
        changePasswordPage.clickChangePasswordBtn();
        changePasswordPage.enterNew("Test@123");
        changePasswordPage.clickSaveBtn();
        Assert.assertEquals(new ChangePasswordPage().isEmptyOld(),"Old Password required");
}




}