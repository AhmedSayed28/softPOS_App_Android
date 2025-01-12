package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class ChangeDefaultPasswordPage extends BasePage{
    private By createPasswordInput;
    private By confirmPasswordInput;
    private By submitBtn;

    public ChangeDefaultPasswordPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            createPasswordInput = By.xpath("//android.view.View[6]/android.widget.EditText");
            confirmPasswordInput = By.xpath("//android.view.View[7]/android.widget.EditText");
            submitBtn = By.xpath("//android.view.View[8]/android.widget.Button");
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            createPasswordInput = AppiumBy.xpath("//XCUIElementTypeSecureTextField[1]");
            confirmPasswordInput = AppiumBy.xpath("//XCUIElementTypeSecureTextField[3]");
            submitBtn = AppiumBy.xpath("//XCUIElementTypeButton");
        }
    }

    public void changePassword(String newPassword){
        waitNclearNtype(createPasswordInput, newPassword);
        waitNclearNtype(confirmPasswordInput, newPassword);
        waitNclick(submitBtn);
    }
}
