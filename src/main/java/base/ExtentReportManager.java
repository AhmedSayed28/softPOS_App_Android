package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import driver.AppDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ExtentReportManager implements ITestListener {
    public ExtentReports extent;
    public ExtentSparkReporter spark;
    public ExtentTest test;
    public WebDriver driver; // Add WebDriver instance
    String base64Screenshot;


    @Override
    public void onStart(ITestContext context) {
        spark = new ExtentSparkReporter( System.getProperty("user.dir")+"/reports/report.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Functional Testing");

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        try {
            base64Screenshot = ((TakesScreenshot) AppDriver.getCurrentDriver()).getScreenshotAs(OutputType.BASE64);
        } catch (Exception e) {
            e.printStackTrace();
        }
        test.log(Status.PASS, "Test case PASSED is: " + result.getName(), MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        try {
            base64Screenshot = ((TakesScreenshot) AppDriver.getCurrentDriver()).getScreenshotAs(OutputType.BASE64);
        } catch (Exception e) {
            e.printStackTrace();
        }
        test.log(Status.FAIL, "Test case FAILED is: " + result.getName(), result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        // Add screenshot to report

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case SKIPPED is: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}