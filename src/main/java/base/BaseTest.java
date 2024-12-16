package base;

import driver.AppFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {

    @BeforeClass
    public void launchApp() throws MalformedURLException {
        AppiumServer.start();
        System.out.println("before method");
        AppFactory.launchApp();
    }

    @AfterMethod
    public void closeApp(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE){
            Util.getScreenshot(result.getMethod().getMethodName());
        }
    }

    @BeforeSuite
    public void serverStart(){
        System.out.println("before suite");
    }

    @AfterSuite
    public void serverStop(){
//        AppiumServer.stop();
    }
}
