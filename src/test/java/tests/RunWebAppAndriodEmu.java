package tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RunWebAppAndriodEmu {

    AndroidDriver driver;
    @Test
    public void openApp() throws MalformedURLException {
        // Set desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android"); // Mobile platform
        capabilities.setCapability("appium:automationName", "UiAutomator2"); // Automation framework
        capabilities.setCapability("appium:deviceName", "Ghaly_Device"); // Device name from adb devices
        capabilities.setCapability("appium:app", "C:\\Users\\user\\IdeaProjects\\first_appium_app\\apps\\mobile-testing.apk"); // Path to the app's APK
        capabilities.setCapability("appium:noReset", true); // Avoids resetting the app state between sessions
//        capabilities.setCapability("appium:newCommandTimeout", 300); // Optional: Sets command timeout

        try {
            // Connect to Appium server URL
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

            // Add your test code here (example: open an app, interact with UI)
            System.out.println("Session started successfully!");

            driver.rotate(ScreenOrientation.LANDSCAPE);
            driver.findElement(AppiumBy.androidUIAutomator("text(\"APPS\")")).click();
//            driver.findElement(AppiumBy.accessibilityId("Search")).click();
//            driver.findElement(AppiumBy.id("cm.aptoide.pt:id/search_src_text")).sendKeys("Pubg");
//            driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@resource-id=\"cm.aptoide.pt:id/icon\"][3]")).click();
//            driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"cm.aptoide.pt:id/search_src_text\"]")).sendKeys("Pubg", Keys.ENTER);
            // Quit the driver after tests
            driver.quit();

        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Invalid Appium server URL.");
        }
    }
}