package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageAfterRegister extends BasePage{
    public WelcomePageAfterRegister(WebDriver driver) {
        super(driver);
    }

    By successMessage = By.xpath("//div[contains(text(),'Your registration completed')]");
    By logoutBtn= By.xpath("//a[contains(text(),'Log out')]");
    public String getMessageAfterRegister()
    {
       // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     return  driver.findElement(successMessage).getText();
    }
    public void setClickOnLogout()
    {
        clickButton(logoutBtn);
    }

}
