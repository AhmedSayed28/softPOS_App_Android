package pages;

import driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class AuthorizePaymentPage extends BasePage{
    private By authorizePaymentButton;
    private By authorizeAmountInput;
    private By authorizeBtn;
    private By extendAuthorizationBtn;
    private By confirmExtendAuthorizationBtn;
    private By captureAuthorizationBtn;
    private By captureAmountInput;
    private By captureBtn;

    public AuthorizePaymentPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            authorizePaymentButton = By.xpath("//android.widget.TextView[@text=\"Authorize Payment\"]");
            authorizeAmountInput = By.xpath("//android.widget.EditText");
            authorizeBtn = By.xpath("//android.widget.Button");
            extendAuthorizationBtn = By.xpath("//android.widget.ScrollView/android.view.View[2]/android.widget.Button");
            captureAuthorizationBtn = By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.Button");
            captureAmountInput = By.xpath("//android.widget.EditText");
            captureBtn = By.xpath("//android.widget.Button");
            confirmExtendAuthorizationBtn = By.xpath("//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
        }
    }

    public void clickAuthorizePayment(){
        waitNclick(authorizePaymentButton);
    }
    public void makeAuthorizePayment(String amount){
        waitNclearNtype(authorizeAmountInput, amount);
        waitNclick(authorizeBtn);
    }
    public void extendAuthorization(){
        waitNclick(extendAuthorizationBtn);
        waitNclick(confirmExtendAuthorizationBtn);
    }
    public void fullCaptureAuthorization(){
        waitNclick(captureAuthorizationBtn);
        waitNclick(captureBtn);
    }
    public void partialCaptureAuthorization(String amount){
        waitNclick(captureAuthorizationBtn);
        waitNclearNtype(captureAmountInput, amount);
        waitNclick(captureBtn);
    }

}
