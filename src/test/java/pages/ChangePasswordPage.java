package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {

    private By Newpass ;
    private By oldPass;
   private By profilebtn;
    private By successMessage;

    public ChangePasswordPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            oldPass = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.widget.EditText");
            profilebtn = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]");
            successMessage=By.xpath("//android.widget.TextView[@text=\"Done\"]");

        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            oldPass = AppiumBy.accessibilityId("");
            Newpass = AppiumBy.accessibilityId("");
        }
    }


    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View")
    private WebElement profileSettingbtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Change Password\"]")
    private WebElement changePassBtn;


    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[7]/android.widget.EditText")
    private WebElement newPass;


    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[8]/android.widget.Button")
    private WebElement saveBtn;

  @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Old Password required\"]")
   private WebElement emptyOldMessage;

    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Done\"]")
    private WebElement WrongOldPaasword;

    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Password must be at least 8 characters long.\"]")
    private WebElement WrongCredNew;


    public void clickProfileBtn() {waitNclick(profilebtn);}
    public void clickSettingBtn() {profileSettingbtn.click();}
    public void clickChangePasswordBtn() {changePassBtn.click();}
    public void enterold(String oldpass){waitNtype(oldPass,oldpass);}
    public void enterNew(String Nerpass){newPass.sendKeys(Nerpass);}
    public void clickSaveBtn() {saveBtn.click();}
    public String isChangePasswordSuccessful() {return getText(successMessage);}
    public String iswrongOldMessage() {return WrongOldPaasword.getText();}
    public String isWrongNewCred() {return WrongCredNew.getText();}
    public  String  isEmptyOld(){return emptyOldMessage.getText();}
    public  boolean isOldWrong(){return WrongOldPaasword.isDisplayed(); }
}
