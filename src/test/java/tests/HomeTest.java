
package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;


public class HomeTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage(driver);  // <-- initialize AFTER driver is ready
    }

    @Test
    public void testSearchProduct() {
        loginPage.Login("standard_user", "secret_sauce");
    }
}

