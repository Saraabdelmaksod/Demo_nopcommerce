package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    By productTitle= By.className("product-title");
    By addCardBtn1=By.xpath("//button[@class='button-2 product-box-add-to-cart-button']");
    By addCardBtn2=By.id("add-to-cart-button-4");
    By productPrice=By.id("price-value-4");
    By successNotify=By.id("bar-notification");

    public String getProductTitle()
    {
        return driver.findElement(productTitle).getText();
    }
    public String getProductPrice()
    {
        implicitWait();
        return driver.findElement(productPrice).getText();
    }
    public void clickOnAddToCard()
    {
        clickButton(addCardBtn1);
        waitUntilElementClickable(addCardBtn2);
        clickButton(addCardBtn2);
    }


    public String getSuccessMessageWhenAddItemToCard()  {
       waitUnitElementVisable(successNotify);
       return driver.findElement(successNotify).getText();
    }
}
