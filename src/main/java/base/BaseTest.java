package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import driver.AppFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;

@Listeners(ExtentReportManager.class)
public class BaseTest {

    private ExtentSparkReporter spark;
    private ExtentReports extent;
    @BeforeClass
    public void launchApp() throws MalformedURLException {
        System.out.println("Before Class");
    }

    @AfterMethod
    public void closeApp(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE){
            Util.getScreenshot(result.getMethod().getMethodName());
        }
    }

    @BeforeSuite
    public void serverStartAndReportSetup() throws MalformedURLException {
        AppiumServer.start();
        AppFactory.launchApp();

    }

    @AfterSuite
    public void serverStop(){
//        AppiumServer.stop();
        extent.flush();
    }
}
