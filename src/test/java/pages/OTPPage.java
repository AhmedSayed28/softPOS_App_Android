package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class OTPPage extends BasePage{
    private By otpInput;
    private By submitBtn;

    public OTPPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            otpInput = By.xpath("//android.widget.EditText");
            submitBtn = By.xpath("//android.widget.Button");
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            otpInput = AppiumBy.xpath("//XCUIElementTypeTextField");
            submitBtn = AppiumBy.xpath("//XCUIElementTypeButton");
        }
    }

    public void enterOTP(String otp){
        waitNclearNtype(otpInput, otp);
    }

    public void submitOTP(){
        waitNclick(submitBtn);
    }
}
