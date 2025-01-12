package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class SplitPaymentPage extends BasePage{
    private By splitPaymentBtn;
    private By splitPayAmountInput;
    private By splitPayGroupNumberInput;
    private By continueBtn;
    private By payBtn;

    public SplitPaymentPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            splitPaymentBtn = By.xpath("//android.widget.TextView[@text=\"New Split Payment\"]");
            splitPayAmountInput = By.xpath("//android.widget.ScrollView/android.view.View[1]/android.widget.EditText");
            splitPayGroupNumberInput = By.xpath("//android.widget.ScrollView/android.view.View[2]/android.widget.EditText");
            continueBtn = By.xpath("//android.widget.Button");
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            splitPaymentBtn = AppiumBy.accessibilityId("Split Payment");
        }
    }

    public void clickSplitPayment(){
        waitNclick(splitPaymentBtn);
    }
    public void makeSplitPayment(String amount, String groupNumber){
        waitNclearNtype(splitPayAmountInput, amount);
        waitNclearNtype(splitPayGroupNumberInput, groupNumber);
        waitNclick(payBtn);
    }

}
