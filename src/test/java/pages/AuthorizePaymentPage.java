package pages;

import driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class AuthorizePaymentPage extends BasePage{
    private By authorizePaymentButton;
    private By authorizeAmountInput;
    private By authorizeBtn;

    public AuthorizePaymentPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            authorizePaymentButton = By.xpath("//android.widget.TextView[@text=\"Authorize Payment\"]");
            authorizeAmountInput = By.xpath("//android.widget.EditText");
            authorizeBtn = By.xpath("//android.widget.Button");
        }
    }

    public void clickAuthorizePayment(){
        waitNclick(authorizePaymentButton);
    }
    public void makeAuthorizePayment(String amount){
        waitNclearNtype(authorizeAmountInput, amount);
        waitNclick(authorizeBtn);
    }


}
