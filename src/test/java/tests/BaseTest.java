package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.*;
import utiles.ReadExcelFile;

public class BaseTest

{
public static WebDriver driver;
public static HomePage homePageObject;
public static RegisterPage registerPageObject;
public static WelcomePage welcomePageObject;
public static LoginPage loginPageObject;
public static StoreWelcomePage storeWelcomePageObject;

public static ReadExcelFile readExcelFileObject;


@BeforeClass
public void setUpDriver()
{
   WebDriverManager.chromedriver().setup();
   driver = new ChromeDriver();
   driver.navigate().to("https://demo.nopcommerce.com/");
   driver.manage().window().maximize();

   homePageObject=new HomePage(driver);
   registerPageObject=new RegisterPage(driver);
   welcomePageObject=new WelcomePage(driver);
   loginPageObject=new LoginPage(driver);
   storeWelcomePageObject=new StoreWelcomePage(driver);
   readExcelFileObject=new ReadExcelFile();

}
@AfterClass
    public void closeDriver()
{
    driver.quit();
}

}
