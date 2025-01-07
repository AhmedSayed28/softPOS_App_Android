package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class OnboardingPage extends BasePage {
    private By skipBtn;

    public OnboardingPage(){
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            skipBtn = By.xpath("//android.widget.TextView[@text=\"Skip\"]");
            } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            skipBtn = AppiumBy.accessibilityId("skipBtn");
        }
    }

    public boolean isFirstTime(){
        return elIsDisplayed(skipBtn);
    }

    public void skipOnboardingScreen(){
        waitNclick(skipBtn);
    }
}
