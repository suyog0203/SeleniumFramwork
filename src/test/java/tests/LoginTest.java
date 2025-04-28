
package tests;

import base.BaseTest;
import io.qameta.allure.*;
import listeners.AllureListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Listeners(listeners.AllureListener.class)

public class LoginTest extends BaseTest {

     LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage(driver);  // <-- initialize AFTER driver is ready
    }

    @Test(description = "Verify user login functionality")
    @Description("Test Description: Verify user login functionality")
    @Feature("Login Feature")
    @Story("User Login")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogin() {
        BaseTest baseTest = new BaseTest();
        baseTest.setUp();
    }
}

