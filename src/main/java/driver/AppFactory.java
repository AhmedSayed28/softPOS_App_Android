package driver;

import base.AppData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.SkipException;

import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {
    static AppiumDriver driver;

    private static void android_launchApp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android"); // Mobile platform
        options.setAutomationName("UiAutomator2"); // Automation framework
        options.setDeviceName("samsung SM-A225F"); // Device name
        options.setApp("C:\\Users\\user\\IdeaProjects\\softPOS_App_Android\\apps\\app-withoutSSL-release.apk"); // Path to the APK
        options.setAppPackage("net.sbs.softpos.finpay"); // App package
        options.setNoReset(true); // Avoid resetting app state

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        AppDriver.setDriver(driver);
        System.out.println("AndroidDriver is set");
    }

    public static void launchApp() throws MalformedURLException {
        System.out.println("entering into launchApp");
        if(AppData.platform.contains("ios")){
            ios_launchApp();
            System.out.println("iOS launched...");
        }else
        if(AppData.platform.contains("android")){
            android_launchApp();
            System.out.println("Android launched...");
        }else
            throw new SkipException("Enter valid platform value, android/ios");
    }

    private static void ios_launchApp() {
    }
}
