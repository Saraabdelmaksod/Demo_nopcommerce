package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class RegisterWithBDDTest extends BaseTest
{
    @DataProvider(name = "testData")
    public Object[] registerData() throws IOException
    {
     return readExcelFileObject.readExcelData();

    }
    @Test(dataProvider = "testData")
    public void testRegister(String fname, String sname,String email, String password)
    {
        homePageObject.setClickOnRegisterBtn();
        registerPageObject.selectGender("Male");
        registerPageObject.enterValidFirstname(fname);
        registerPageObject.enterValidSecondname(sname);
        registerPageObject.enterValidEmail(email);
        registerPageObject.enterValidPassword(password);
        registerPageObject.setClickOnRegisterBtn();
        Assert.assertEquals(welcomePageObject.getMessageAfterRegister(),"Your registration completed");
        welcomePageObject.setClickOnLogout();
        homePageObject.setClickOnLoginBtn();
        loginPageObject.loginWithValidUserAndPassword(email,password);
        welcomePageObject.setClickOnLogout();
        Assert.assertTrue(storeWelcomePageObject.getText());

    }
    


}
