package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class MainPage extends BasePage{
    private By newPaymentBtn;
    private By payAmountInput;
    private By splitPaymentBtn;
    private By splitPayAmountInput;
    private By splitPayGroupNumberInput;
    private By cashBackBtn;
    private By authorizeBtn;
    private By reconcileBtn;
    private By payBtn;
    private By continueBtn;


    public MainPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            newPaymentBtn = By.xpath("//android.widget.TextView[@text=\"New Payment\"]");
            payAmountInput = By.xpath("//android.widget.EditText");
            splitPaymentBtn = By.xpath("//android.widget.TextView[@text=\"New Split Payment\"]");
            splitPayAmountInput = By.xpath("//android.widget.ScrollView/android.view.View[1]/android.widget.EditText");
            splitPayGroupNumberInput = By.xpath("//android.widget.ScrollView/android.view.View[2]/android.widget.EditText");
            cashBackBtn = By.xpath("//android.widget.TextView[@text=\"Cash Back\"]");
            authorizeBtn = By.xpath("//android.widget.TextView[@text=\"Authorize Payment\"]");
            reconcileBtn = By.xpath("//android.widget.TextView[@text=\"Reconcile now\"]");
            payBtn = By.xpath("//android.widget.Button");
            continueBtn = By.xpath("//android.widget.Button[@resource-id=\"net.sbs.softpos.finpay:id/btn_confirmButton\"]");
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            newPaymentBtn = AppiumBy.accessibilityId("New Payment");
            splitPaymentBtn = AppiumBy.accessibilityId("Split Payment");
            cashBackBtn = AppiumBy.accessibilityId("Cash Back");
            authorizeBtn = AppiumBy.accessibilityId("Authorize");
            reconcileBtn = AppiumBy.accessibilityId("Reconcile");
        }
    }

    public void clickNewPayment(){
        waitNclick(newPaymentBtn);
    }
    public void makeNormalPayment(String amount){
        waitNclearNtype(payAmountInput, amount);
        waitNclick(payBtn);
    }
    public void enterCardPassword(){
        for (int i = 0; i < 4; i++) {
            waitNclick(By.xpath("//android.widget.TextView[@text=\""+i+"\"]"));
        }
        waitNclick(continueBtn);
    }

}
