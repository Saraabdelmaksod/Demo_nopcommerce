package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class StoreWelcomePage extends BasePage{
    public StoreWelcomePage(WebDriver driver)
    {
        super(driver);
    }

    By myACountBtn = By.xpath("//a[@class='ico-account']");
    By searchBox= By.id("small-searchterms");
    By searchBtn=By.xpath("//button[@class='button-1 search-box-button']");
    By suggestedSearchList=By.id("ui-id-1");

    By electronics=By.linkText("Electronics");
 //   By cellPhones=By.linkText("Cell phones ");

    By cellPhones=By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']");

    By currencyDropList=By.id("customerCurrency");
    By prices=By.xpath("//span[@class='price actual-price']");


    By ErrorMessageForVote=By.id("block-poll-vote-error-1");



    public Boolean getText()
    {
        return driver.findElement(myACountBtn).isDisplayed();
    }
    public void search(String productName)
    {
        setTextElementText(searchBox, productName);
        clickButton(searchBtn);
    }

    public void selectAnyCellPhoneFromSubMenu()
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

    public void selectAnyCurrency(String currency)
    {
        Select dropCurrency = new Select(driver.findElement(currencyDropList));
        dropCurrency.selectByVisibleText(currency);
    }
    public List<WebElement> checkCurrency()
    {
      List<WebElement> pricesList=driver.findElements(prices);
     return pricesList;
    }
}
