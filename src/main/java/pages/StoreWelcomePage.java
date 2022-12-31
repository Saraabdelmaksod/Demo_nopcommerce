package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class StoreWelcomePage extends BasePage{
    public StoreWelcomePage(WebDriver driver) {
        super(driver);
       actions= new Actions(driver);
    }

    By myACountBtn = By.xpath("//a[@class='ico-account']");
    By searchBox= By.id("small-searchterms");
    By searchBtn=By.xpath("//button[@class='button-1 search-box-button']");
    By suggestedSearchList=By.id("ui-id-1");

    By electronics=By.linkText("Electronics");
 //   By cellPhones=By.linkText("Cell phones ");

    By cellPhones=By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']");





    public Boolean getText()
    {
        return driver.findElement(myACountBtn).isDisplayed();
    }
    public void search(String productName)
    {
        setTextElementText(searchBox, productName);
        clickButton(searchBtn);
    }

    public void select()
    {
        waitUnitElementVisable(electronics);
        WebElement mainMenu=  driver.findElement(electronics);
        WebElement subMenu=  driver.findElement(cellPhones);

        actions.moveToElement(mainMenu)
                .moveToElement(subMenu)
                .click()
                .build()
                .perform();



    }


}
