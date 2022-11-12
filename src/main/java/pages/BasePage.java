package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public static WebDriver driver;

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


}
