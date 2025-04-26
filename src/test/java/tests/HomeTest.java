
package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.AssertJUnit.assertTrue;

public class HomeTest extends BaseTest {

    HomePage homePage;  // <-- only declare here

    @BeforeMethod
    public void setUpTest() {
        homePage = new HomePage(driver);  // <-- initialize AFTER driver is ready
    }

    @Test
    public void testSearchProduct() {
        homePage.searchProduct("laptop");
    }
}

