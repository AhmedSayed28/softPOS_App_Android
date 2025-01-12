package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class CashBackPage extends BasePage{
    MainPage mainPage = new MainPage();
    private By cashBackBtn;
    private By amountInput;
    private By cashBackAmountInput;
    private By continueBtn;

    public CashBackPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            cashBackBtn = By.xpath("//android.widget.TextView[@text=\"Cash Back\"]");
            amountInput = By.xpath("//android.widget.ScrollView/android.view.View[1]/android.widget.EditText");
            cashBackAmountInput = By.xpath("//android.widget.ScrollView/android.view.View[2]/android.widget.EditText");
            continueBtn = By.xpath("//android.widget.Button");
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            cashBackBtn = AppiumBy.accessibilityId("Cash Back");
        }
    }

    public void clickCashBack(){
        waitNclick(cashBackBtn);
    }
    public void makeCashBack(String amount , String CashBackAmount){
        waitNclearNtype(amountInput, amount);
        waitNclearNtype(cashBackAmountInput, CashBackAmount);
        waitNclick(continueBtn);
    }

}
