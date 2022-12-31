package tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

  private static String getTestMethodName(ITestResult result)
    {
        return result.getMethod().getConstructorOrMethod().getName();
    }
    @Attachment
    public byte[] saveFailureScreenShoot(WebDriver driver)
    {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
    @Attachment(value = "{0}" , type = "text/plain")
    public static String saveTextLog(String message)
    {
    return message;
    }
    @Override
    public void onTestStart(ITestResult result)
    {
       //
    }
    @Override
    public void onTestSuccess(ITestResult result)
    {
      //
    }
    @Override
    public void onTestFailure(ITestResult result)
    {
        System.out.println("I am in Fail Method" + getTestMethodName(result) + "Failure");
        WebDriver driver=BaseTest.driver;
       //  driver
        if(driver instanceof WebDriver)
        {
          System.out.println("ScreenShoot Captured" + getTestMethodName(result));
          saveFailureScreenShoot(driver);
        }
          saveTextLog(getTestMethodName(result) + "failed and screenShoot taken");

        }
}
