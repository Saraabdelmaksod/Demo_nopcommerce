package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ChangeCurrencyTest extends BaseTest{

    @Test

    public void shouldBeAbleToChangeCurrency()
    {
        storeWelcomePageObject.selectAnyCurrency("Euro");
        List<WebElement> CurrencyDropList=storeWelcomePageObject.checkCurrency();
        for(WebElement currencyOption: CurrencyDropList)
        {
            Assert.assertTrue(currencyOption.getText().contains("€"));
        }
    }
}
