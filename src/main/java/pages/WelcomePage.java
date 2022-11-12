package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WelcomePage extends BasePage{
    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    By sucessMessage= By.xpath("//div[contains(text(),'Your registration completed')]");
    By logoutBtn= By.xpath("//a[contains(text(),'Log out')]");
    public String getMessageAfterRegister()
    {
       // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     return  driver.findElement(sucessMessage).getText();
    }
    public void setClickOnLogout()
    {
        clickButton(logoutBtn);
    }

}
