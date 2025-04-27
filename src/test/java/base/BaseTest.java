
package base;

import config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utilities.DriverFactory;

public class BaseTest {
    public WebDriver driver;
    protected LoginPage loginPage;


    public void setUp() {
        driver = DriverFactory.initDriver();
        DriverFactory.goTo();
        loginPage = new LoginPage(driver);
        // login step
        loginPage.login((ConfigManager.get("username")),
                ConfigManager.get("password"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
