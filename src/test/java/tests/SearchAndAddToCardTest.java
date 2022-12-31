package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
@Listeners({Listener.class})
public class SearchAndAddToCardTest extends BaseTest{

    SoftAssert asserting=new SoftAssert();

    @Test
    public void ValidateSearchFunctionalityWithoutLogin() throws InterruptedException {
        storeWelcomePageObject.search("Apple MacBook Pro 13-inch");
        productPageObject.getProductTitle();
        asserting.assertEquals(productPageObject.getProductTitle(), "Apple MacBook Pro 13-inch");
        productPageObject.clickOnAddToCard();
        String productPrice= productPageObject.getProductPrice();
        String successMessage= productPageObject.getSuccessMessageWhenAddItemToCard();
        asserting.assertEquals(successMessage, "The product has been added to your shopping cart");

        asserting.assertAll();
    }

    @Test
    public void ValidateAddProductToCardFunctionalityWithoutLogin() throws InterruptedException {
        storeWelcomePageObject.search("Apple MacBook Pro 13-inch");
        productPageObject.clickOnAddToCard();
        String productPrice= productPageObject.getProductPrice();
        String successMessage= productPageObject.getSuccessMessageWhenAddItemToCard();
        asserting.assertEquals(successMessage, "The product has been added to your shopping cart");
        homePageObject.clickOnShoppingCart();
        shoppingCartPageObject.getProductNameFromCart();
        asserting.assertEquals(shoppingCartPageObject.getProductNameFromCart(),"Apple MacBook Pro 13-inch" );
        asserting.assertEquals(productPrice,shoppingCartPageObject.getProductPriceForeOneUnit() );
        asserting.assertAll();
    }




}
