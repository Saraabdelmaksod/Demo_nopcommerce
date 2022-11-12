package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class RegisterTest extends BaseTest {

    @Test
    public void testRegister()
    {
        SoftAssert asserting=new SoftAssert();
        asserting.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        homePageObject.setClickOnRegisterBtn();
        asserting.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/register?returnUrl=%2F");
        registerPageObject.selectGender("");
        registerPageObject.enterValidFirstname("Sa");
        registerPageObject.enterValidSecondname("Ra");
        registerPageObject.enterValidEmail("testtagilie@tee.com");
        registerPageObject.enterValidPassword("12345678");
        registerPageObject.setClickOnRegisterBtn();
        asserting.assertEquals(welcomePageObject.getMessageAfterRegister(),"Your registration completed");
        asserting.assertAll();
    }

    @Test(dependsOnMethods = "testRegister")
    public void testLoginAfterSuccessRegister()
    {
       welcomePageObject.setClickOnLogout();
       homePageObject.setClickOnLoginBtn();
       loginPageObject.loginWithValidUserAndPassword("testtagile@tee.com","12345678" );
       Assert.assertTrue(storeWelcomePageObject.getText());


    }
}
