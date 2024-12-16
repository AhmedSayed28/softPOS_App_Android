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
        // Set desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android"); // Mobile platform
        capabilities.setCapability("appium:automationName", "UiAutomator2"); // Automation framework
        capabilities.setCapability("appium:deviceName", "samsung SM-A225F"); // Device name from adb devices
        capabilities.setCapability("appium:app", "C:\\Users\\user\\IdeaProjects\\softPOS_App_Android\\apps\\Finpay-V3.0.5.apk"); // Path to the app's APK
        capabilities.setCapability("appium:noReset", true); // Avoids resetting the app state between sessions
//        capabilities.setCapability("appium:newCommandTimeout", 300); // Optional: Sets command timeout

        UiAutomator2Options options = new UiAutomator2Options();
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
