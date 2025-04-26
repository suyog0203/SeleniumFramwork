
package utilities;

import abstractcomponent.AbstractComponent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static WebDriver driver;
    private AbstractComponent abstractComponent;

    public DriverFactory(AbstractComponent abstractComponent) {
        this.abstractComponent = abstractComponent;
    }

    public static WebDriver initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void goTo() {
        driver.get(AbstractComponent.URL);
    }


}
