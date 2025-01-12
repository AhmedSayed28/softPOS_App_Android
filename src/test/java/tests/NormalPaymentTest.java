package tests;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.OnboardingPage;
import pages.ReceiptPage;

public class NormalPaymentTest extends BaseTest {
    private static final String EMAIL = "memof55627@nalwan.com";
    private static final String PASSWORD = "New1234@";
    private static final String AMOUNT = "1234";

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

        handleOnboarding();
        loginPage.login(EMAIL, PASSWORD);
    }

    @Test
    public void testPurchaseAndRefund() {
        performNormalPayment();
        receiptPage.showReceipt();
        refundPayment();
        receiptPage.returnToMainPage();
    }

    @Test
    public void testRefundAndCancelRefund() {
        performNormalPayment();
        receiptPage.showReceipt();
        refundPayment();
        receiptPage.showReceipt();
        cancelRefund();
        receiptPage.returnToMainPage();
    }

    @Test
    public void testPurchaseAndCancel() {
        performNormalPayment();
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
