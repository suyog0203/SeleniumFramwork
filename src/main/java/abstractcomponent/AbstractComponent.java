package abstractcomponent;

import org.openqa.selenium.WebDriver;

public class AbstractComponent {

    private final WebDriver driver;
    public static String URL = "https://www.flipkart.com/";


    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
    }
}
