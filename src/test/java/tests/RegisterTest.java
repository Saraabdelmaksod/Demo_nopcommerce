package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners({Listener.class})
public class RegisterTest extends BaseTest {
    Faker fakerData=new Faker();

   String email= fakerData.internet().emailAddress();

    @Severity(SeverityLevel.BLOCKER)
    @Test()
    public void testRegister()
    {
        SoftAssert asserting=new SoftAssert();
        asserting.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        homePageObject.clickOnRegisterBtn();
        asserting.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/register?returnUrl=%2F");
        registerPageObject.selectGender("");
        registerPageObject.enterFirstname("Sa");
        registerPageObject.enterSecondName("Ra");
        registerPageObject.enterEmail(email);
        registerPageObject.enterPassword("12345678");
        registerPageObject.clickOnRegisterBtn();
        asserting.assertEquals(welcomePageObject.getMessageAfterRegister(),"Your registration completed");
        asserting.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(dependsOnMethods = "testRegister")
    public void testLoginAfterSuccessRegister()
    {
       //welcomePageObject.setClickOnLogout();
       homePageObject.clickOnLoginBtn();
       loginPageObject.loginWithUsernameAndPassword(email,"12345678" );
       Assert.assertTrue(storeWelcomePageObject.getText());

    }



}
