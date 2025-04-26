
package pages;

import abstractcomponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractComponent {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        @FindBy(xpath = "//input[@placeholder='Search for Products, Brands and More']")
         WebElement searchInput;

        @FindBy(xpath = "//button[@type='submit']//*[name()='svg']")
         WebElement searchIcon;



    public void searchProduct(String productName) {

        waitForElementToAppear(searchInput);
        searchInput.sendKeys(productName);
        searchIcon.click();
        System.out.println("Searched for: " + productName);
    }


}
