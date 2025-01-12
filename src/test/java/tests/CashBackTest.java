package tests;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class CashBackTest extends BaseTest {
    private static final String AMOUNT = "1234";
    private static final String CASHBACKAMOUNT = "100";

    private CashBackPage cashBackPage;
    private LoginPage loginPage;
    private OnboardingPage onboardingPage;
    private MainPage mainPage;
    private ReceiptPage receiptPage;

    @BeforeClass
    public void setup() {
        loginPage = new LoginPage();
        onboardingPage = new OnboardingPage();
        mainPage = new MainPage();
        receiptPage = new ReceiptPage();
        cashBackPage = new CashBackPage();

        handleOnboarding();
//        loginPage.login(EMAIL, PASSWORD);
    }
    @Test
    public void testCashBack() {
        performCashBack();
    }

    @Test
    public void testCashBackAndRefund() {
        performCashBack();
        receiptPage.showReceipt();
        refundPayment();
        receiptPage.returnToMainPage();
    }

    @Test
    public void testCashBackAndCancelRefund() {
        performCashBack();
        receiptPage.showReceipt();
        refundPayment();
        receiptPage.showReceipt();
        cancelRefund();
        receiptPage.returnToMainPage();
    }

    @Test
    public void testCashBackAndCancel() {
        performCashBack();
        receiptPage.showReceipt();
        cancelRefund();
        receiptPage.returnToMainPage();
    }

    // Helper Methods
    private void handleOnboarding() {
        if (onboardingPage.isFirstTime()) {
            onboardingPage.skipOnboardingScreen();
        }
    }

    private void performCashBack() {
        mainPage.goToMainPage();
        cashBackPage.clickCashBack();
        cashBackPage.makeCashBack(AMOUNT, CASHBACKAMOUNT);
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
