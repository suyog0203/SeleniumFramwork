
package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BaseTest {

    @Test
    public void testSearchProduct() throws InterruptedException {
        // Implement the test logic here
        // For example, you can use the HomePage class to perform actions on the home page
         HomePage homePage = new HomePage(driver);
         Thread.sleep(7000);

    }
}
