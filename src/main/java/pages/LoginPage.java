
package pages;

import abstractcomponent.AbstractComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponent {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        @FindBy(xpath = "//input[@id='user-name']")
         WebElement userNameField;

        @FindBy(xpath = "//input[@id='password']")
         WebElement passwordField;

        @FindBy(xpath = "//input[@id='login-button']")
        WebElement loginButton;

        @FindBy(xpath = "//div[@class='product_label']")
        WebElement productLabel;


    @Step("Searching product: {productName}")
    public void Login(String username, String password)  {

        waitForElementToAppear(userNameField);
        userNameField.sendKeys(username);
        waitForElementToAppear(passwordField);
        passwordField.sendKeys(password);
        loginButton.click();
        waitForElementToAppear(productLabel);
        System.out.println("Login Successful");
    }


}
