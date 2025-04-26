package abstractcomponent;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;
    public static String URL = "https://www.saucedemo.com/v1/index.html";


    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToAppear(WebElement findBy) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(findBy));
        }catch (NoSuchElementException Ne){
            System.out.println("No Element Found");
        }
    }

//    public void waitForVisibilityOfElement(WebElement element) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            wait.until(ExpectedConditions.visibilityOf(element));
//        } catch (TimeoutException e) {
//            System.out.println("Element not visible after waiting: " + element);
//        } catch (Exception e) {  // Catch any other exceptions
//            System.out.println("Unexpected error while waiting for visibility: " + e.getMessage());
//
//        }
    }



