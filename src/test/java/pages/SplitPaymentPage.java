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

    MainPage mainPage = new MainPage();

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
        waitNclick(continueBtn);

        System.out.println(Integer.parseInt(groupNumber));
        for (int i = 1; i <= Integer.parseInt(groupNumber); i++) {
            waitNclick(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View["+i+"]/android.view.View/android.widget.Button"));
            mainPage.waitUntilCardPasswordPageLoading();
            mainPage.enterCardPassword();
        }
    }


}
