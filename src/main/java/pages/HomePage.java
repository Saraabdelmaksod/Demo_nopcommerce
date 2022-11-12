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


    public void setClickOnRegisterBtn()
    {
        clickButton(registerBtn);
    }

    public void setClickOnLoginBtn()
    {
        clickButton(loginBtn);
    }
}
