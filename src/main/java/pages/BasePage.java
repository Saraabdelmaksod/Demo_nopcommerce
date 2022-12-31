package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;
    public static Actions actions;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
    }
    protected static void clickButton(By button)
    {
        driver.findElement(button).click();
    }
    protected static void setTextElementText(By textElement, String value)
    {
        driver.findElement(textElement).sendKeys(value);

    }
    protected void clearText(By textBox)
    {
        driver.findElement(textBox).clear();
    }

    protected void waitUntilElementClickable(By locator)
    {
        WebDriverWait wait= new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitUnitElementVisable(By locator)
    {
        WebDriverWait wait= new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected  void implicitWait()
    {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


}
