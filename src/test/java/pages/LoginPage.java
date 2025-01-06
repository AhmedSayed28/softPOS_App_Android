package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import driver.AppDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private By emailLocator;
    private By emailErrorText;
    private By passwordErrorText;
    public By credErrorText;
    private By okBtn;
    private By loginLogo;
    private By errorView;

    public LoginPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            emailLocator = By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText");
            emailErrorText = By.xpath("(//android.widget.TextView[@text=\"Required\"])[1]");
            passwordErrorText = By.xpath("(//android.widget.TextView[@text=\"Required\"])[1]");
            credErrorText = By.xpath("//android.widget.TextView[@text=\"Email or password not correct\"]");
            loginLogo = By.xpath("//android.view.View[@content-desc=\"login_icon\"]");
            errorView = By.xpath("//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View");
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            emailLocator = AppiumBy.accessibilityId("email input field");
            emailErrorText = By.xpath("//XCUIElementTypeOther[@name='email-error-message']/XCUIElementTypeStaticText");
            passwordErrorText = By.xpath("//XCUIElementTypeOther[@name='generic-error-message']/XCUIElementTypeStaticText");
        }
    }
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "Password input field")
    private WebElement passwordElement;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[5]/android.widget.Button")
    @iOSXCUITFindBy(accessibility = "Login button")
    private WebElement btnLogin;

    public void login(String email, String password) {

        waitNtype(emailLocator, email);
        passwordElement.clear();
        passwordElement.sendKeys(password);
        btnLogin.click();
    }

    public void clickOk(){
        okBtn = By.xpath("//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
        waitNclick(okBtn);
    }

    public String getEmailErrorText() {
       return getText(emailErrorText);
    }

    public String getPasswordErrorText() {
        return getText(passwordErrorText);
    }

    public String getCredErrorText() {
        return getText(credErrorText);
    }

    public boolean isLoginLogoDisplayed(){
        return elIsDisplayed(loginLogo);
    }public boolean isErrorDisplayed(){
        return elIsDisplayed(errorView);
    }


}
