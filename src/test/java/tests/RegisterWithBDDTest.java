package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
        homePageObject.clickOnRegisterBtn();
        registerPageObject.selectGender("Male");
        registerPageObject.enterFirstname(fname);
        registerPageObject.enterSecondName(sname);
       // registerPageObject.enterEmail(email);
        registerPageObject.enterPassword(password);
        registerPageObject.clickOnRegisterBtn();
        Assert.assertEquals(welcomePageObject.getMessageAfterRegister(),"Your registration completed");
        welcomePageObject.setClickOnLogout();
        homePageObject.clickOnLoginBtn();
        loginPageObject.loginWithUsernameAndPassword(email,password);
        welcomePageObject.setClickOnLogout();
        Assert.assertTrue(storeWelcomePageObject.getText());

    }
    


}
