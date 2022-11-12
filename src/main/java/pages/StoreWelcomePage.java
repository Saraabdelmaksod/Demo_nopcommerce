package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StoreWelcomePage extends BasePage{
    public StoreWelcomePage(WebDriver driver) {
        super(driver);
    }
    By myCountBtn= By.xpath("//a[@class='ico-account']");

    public Boolean getText()
    {
        return driver.findElement(myCountBtn).isDisplayed();
    }
}
