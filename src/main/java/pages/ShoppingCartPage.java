package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    By productName= By.xpath("//a[@class='product-name']");
    By productPriceForOneUnit= By.xpath("//span[@class='product-unit-price']");


    public String getProductNameFromCart()
    {
        return driver.findElement(productName).getText();
    }

    public String getProductPriceForeOneUnit()
    {
        return driver.findElement(productPriceForOneUnit).getText();
    }
}
