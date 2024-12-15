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

    public LoginPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            emailLocator = AppiumBy.accessibilityId("email input field");
            emailErrorText = By.xpath("//android.view.ViewGroup[@content-desc='email-error-message']/android.widget.TextView");
            passwordErrorText = By.xpath("//android.view.ViewGroup[@content-desc='Password-error-message']/android.widget.TextView");
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            emailLocator = AppiumBy.accessibilityId("email input field");
            emailErrorText = By.xpath("//XCUIElementTypeOther[@name='email-error-message']/XCUIElementTypeStaticText");
            passwordErrorText = By.xpath("//XCUIElementTypeOther[@name='generic-error-message']/XCUIElementTypeStaticText");
        }
    }
    @AndroidFindBy(accessibility = "Password input field")
    @iOSXCUITFindBy(accessibility = "Password input field")
    private WebElement passwordElement;

    @AndroidFindBy(accessibility = "Login button")
    @iOSXCUITFindBy(accessibility = "Login button")
    private WebElement btnLogin;

    public void login(String email, String password) {

        waitNtype(emailLocator, email);
        passwordElement.clear();
        passwordElement.sendKeys(password);
        btnLogin.click();
    }

    public String getEmailErrorText() {
       return getText(emailErrorText);
    }

    public String getPasswordErrorText() {
        return getText(passwordErrorText);
    }

}
