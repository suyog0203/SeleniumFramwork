
package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.DriverFactory;

public class BaseTest {
     public WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.initDriver();
        DriverFactory.goTo();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
