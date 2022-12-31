package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners({Listener.class})
public class TopMenuTest extends BaseTest{


    @Test
    public void test() {

       storeWelcomePageObject.select();
        Assert.assertTrue(driver.getCurrentUrl().contains("cell-phones"));
    }
}
