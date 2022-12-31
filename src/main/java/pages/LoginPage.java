package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By loginMail= By.id("Email");
    By loginPassword=By.id("Password");
    By loginBtn= By.xpath("//button[contains(text(),'Log in')]");


    public void loginWithUsernameAndPassword(String userMail , String userPassword)
    {
        setTextElementText(loginMail, userMail);
        setTextElementText(loginPassword, userPassword);
        clickButton(loginBtn);
    }
}
