package tests;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class SplitPaymentTest extends BaseTest {

    private static final String AMOUNT = "1234";
    private static final String GROUPNUMBER = "3";


    private LoginPage loginPage;
    private OnboardingPage onboardingPage;
    private MainPage mainPage;
    private ReceiptPage receiptPage;
    private SplitPaymentPage splitPaymentPage;
    @BeforeClass
    public void setup() {
        loginPage = new LoginPage();
        onboardingPage = new OnboardingPage();
        mainPage = new MainPage();
        receiptPage = new ReceiptPage();
        splitPaymentPage = new SplitPaymentPage();

        handleOnboarding();
//        loginPage.login(EMAIL, PASSWORD);
    }

    @Test
    public void testSplitPayment() {
        mainPage.goToMainPage();
        splitPaymentPage.clickSplitPayment();
        splitPaymentPage.makeSplitPayment(AMOUNT, GROUPNUMBER);
    }


    // Helper Methods
    private void handleOnboarding() {
        if (onboardingPage.isFirstTime()) {
            onboardingPage.skipOnboardingScreen();
        }
    }

    private void performNormalPayment() {
        mainPage.clickNewPayment();
        mainPage.makeNormalPayment(AMOUNT);
        mainPage.waitUntilCardPasswordPageLoading();
        mainPage.enterCardPassword();
        receiptPage.waitForOperationStatusPage();
    }

    private void refundPayment() {
        receiptPage.refundPayment();
        mainPage.waitUntilCardPasswordPageLoading();
        mainPage.enterCardPassword();
        receiptPage.waitForOperationStatusPage();
    }

    private void cancelRefund() {
        receiptPage.cancelPayment();
    }
}
