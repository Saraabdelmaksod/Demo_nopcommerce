package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    By registerBtn= By.xpath("//a[contains(text(),'Register')]");
    By loginBtn=By.xpath("//a[contains(text(),'Log in')]");
    By shoppingCart= By.id("topcartlink");


    public void clickOnRegisterBtn()
    {
        clickButton(registerBtn);
    }

    public void clickOnLoginBtn()
    {
        clickButton(loginBtn);
    }
    public void clickOnShoppingCart() throws InterruptedException {
        Thread.sleep(3000);
        waitUntilElementClickable(shoppingCart);

        clickButton(shoppingCart);
    }
}
