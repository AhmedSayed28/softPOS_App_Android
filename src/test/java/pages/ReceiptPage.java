package pages;

import driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ReceiptPage extends BasePage{
    private By showReceiptButton;
    private By cancelButton;
    private By refundButton;
    private By returnToMainPageButton;
    private By operationStatusPage;

    public ReceiptPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            showReceiptButton = By.xpath("//android.widget.Button");
            cancelButton = By.xpath("//android.widget.TextView[contains(@text, 'Cancel')]");
            refundButton = By.xpath("//android.widget.Button");
            returnToMainPageButton = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView");
            operationStatusPage = By.xpath("//android.widget.TextView[@text=\"Operation Status\"]");
        }
    }

    public void waitForOperationStatusPage(){
        waitForEl(operationStatusPage);
    }

    public void returnToMainPage(){
        waitNclick(returnToMainPageButton);
    }

    public void showReceipt(){
        waitNclick(showReceiptButton);
    }
    public void cancelPayment(){
        waitNclick(cancelButton);
    }
    public void refundPayment(){
        waitNclick(refundButton);
    }

}
