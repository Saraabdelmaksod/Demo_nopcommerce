package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    String gender;
    By genderBtn= By.xpath("//label[contains(text(),"+gender+")]");
    By firstName=By.id("FirstName");
    By lastName=By.id("LastName");
    By email=By.id("Email");
    By password=By.id("Password");
    By confirmPassword=By.id("ConfirmPassword");
    By registerBtn2=By.id("register-button");

    public void selectGender(String gender)
    {
        this.gender=gender;
        if(gender== "Male")
       {
           driver.findElement(By.xpath("//label[contains(text(),\"Male\")]")).click();
       }
      else
        {
            driver.findElement(By.xpath("//label[contains(text(),\"Female\")]")).click();
        }

    }
    public void enterValidFirstname(String userName1)
    {
        setTextElementText(firstName, userName1);
    }
    public void enterValidSecondname(String subUserName)
    {
        setTextElementText(lastName,subUserName);
    }
    public void enterValidEmail(String userMail)
    {
        setTextElementText(email,userMail);

    }
    public void enterValidPassword( String userPassword)
    {
        setTextElementText(password,userPassword);
        setTextElementText(confirmPassword,userPassword);
    }
    public void setClickOnRegisterBtn()
    {
        clickButton(registerBtn2);
    }

}
