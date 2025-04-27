package pages;

import abstractcomponent.AbstractComponent;
import config.ConfigManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFlow extends AbstractComponent {

    WebDriver driver;

    // Constructor
    public CheckoutFlow(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[normalize-space()='Sauce Labs Backpack']")
    WebElement productName;
    @FindBy(xpath = "//button[normalize-space()='ADD TO CART']")
    WebElement addToCartButton;
    @FindBy(xpath = "//*[name()='path' and contains(@fill,'currentCol')]")
    WebElement cartIcon;
    @FindBy(xpath = "//a[normalize-space()='CHECKOUT']")
    WebElement checkoutButton;
    @FindBy(xpath = "//div[@class='subheader']")
    WebElement ConfirmationForm;
    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement postalCodeField;
    @FindBy(xpath = "//input[@value='CONTINUE']")
    WebElement continueButton;
    @FindBy(xpath = "//div[@class='subheader' and contains(text(),'Checkout: Overview')]")
    WebElement orderConfirmationPage;
    @FindBy(xpath = "//a[normalize-space()='FINISH']")
    WebElement finishButton;
    @FindBy(xpath = "//h2[normalize-space()='THANK YOU FOR YOUR ORDER']")
    WebElement orderConfirmationMessage;


    public boolean placeOrder() {
        // Logic to place order
        waitForElementToAppear(productName);
        productName.click();
        // Add product to cart
        waitForElementToAppear(addToCartButton);
        addToCartButton.click();
        cartIcon.click();
        // Proceed to checkout
        waitForElementToAppear(checkoutButton);
        try {
            Alert alert = driver.switchTo().alert();  // try to switch
            System.out.println("Alert is displayed: " + alert.getText());
            alert.dismiss(); // dismiss or accept
        } catch (NoAlertPresentException e) {
            System.out.println("No alert is displayed. Proceeding with checkout.");

            // Proceed with checkout only if no alert
            waitForElementToAppear(checkoutButton);
            checkoutButton.click();
            waitForElementToAppear(ConfirmationForm);

            // Fill in shipping information
            firstNameField.sendKeys(ConfigManager.get("name"));
            lastNameField.sendKeys(ConfigManager.get("lastname"));
            postalCodeField.sendKeys(ConfigManager.get("PostalCode"));
            continueButton.click();

            waitForElementToAppear(orderConfirmationPage);
            finishButton.click();
            waitForElementToAppear(orderConfirmationMessage);

            // Verify order confirmation
            String confirmationMessage = orderConfirmationMessage.getText();
            if (confirmationMessage.equals("THANK YOU FOR YOUR ORDER")) {
                System.out.println("Order placed successfully!");
            } else {
                System.out.println("Order placement failed.");
            }
        }

        return orderConfirmationMessage.isDisplayed();
    }
}
