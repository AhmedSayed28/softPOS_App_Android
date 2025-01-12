package tests;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class AuthorizePaymentTest extends BaseTest {
    private static final String AMOUNT = "1234";
    private static final String CAPTUREAMOUNT = "1000";


    private LoginPage loginPage;
    private OnboardingPage onboardingPage;
    private MainPage mainPage;
    private ReceiptPage receiptPage;
    private AuthorizePaymentPage authorizePaymentPage;

    @BeforeClass
    public void setup() {
        loginPage = new LoginPage();
        onboardingPage = new OnboardingPage();
        mainPage = new MainPage();
        receiptPage = new ReceiptPage();
        authorizePaymentPage = new AuthorizePaymentPage();

        handleOnboarding();
//        loginPage.login(EMAIL, PASSWORD);
    }
    @Test
    public void testAuthorizePayment() {
        performAuthorizePayment();
    }

    @Test
    public void testAuthorizePaymentAndCancel() {
        performAuthorizePayment();
        receiptPage.waitForOperationStatusPage();
        receiptPage.showReceipt();
        cancelAuth();
        receiptPage.returnToMainPage();
    }

    @Test
    public void testAuthorizePaymentAndExtend() {
        performAuthorizePayment();
        receiptPage.waitForOperationStatusPage();
        receiptPage.showReceipt();
        authorizePaymentPage.extendAuthorization();
        mainPage.waitUntilCardPasswordPageLoading();
        mainPage.enterCardPassword();
    }

    @Test
    public void testAuthorizePaymentAndFullCapture() {
        performAuthorizePayment();
        receiptPage.waitForOperationStatusPage();
        receiptPage.showReceipt();
        authorizePaymentPage.fullCaptureAuthorization();
        mainPage.waitUntilCardPasswordPageLoading();
        mainPage.enterCardPassword();
    }

    @Test
    public void testAuthorizePaymentAndPartialCapture() {
        performAuthorizePayment();
        receiptPage.waitForOperationStatusPage();
        receiptPage.showReceipt();
        authorizePaymentPage.partialCaptureAuthorization(CAPTUREAMOUNT);
        mainPage.waitUntilCardPasswordPageLoading();
        mainPage.enterCardPassword();
    }



    // Helper Methods
    private void handleOnboarding() {
        if (onboardingPage.isFirstTime()) {
            onboardingPage.skipOnboardingScreen();
        }
    }

    private void performAuthorizePayment() {
        mainPage.goToMainPage();
        authorizePaymentPage.clickAuthorizePayment();
        authorizePaymentPage.makeAuthorizePayment(AMOUNT);
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

    private void cancelAuth() {
        receiptPage.cancelPayment();
    }
}
