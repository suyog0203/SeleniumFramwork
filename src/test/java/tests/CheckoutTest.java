package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutFlow;

public class CheckoutTest extends BaseTest {

    private CheckoutFlow checkoutFlow;


    @BeforeMethod
    public void setUpTest() {
        setUp();  // Call the setup method from BaseTest to initialize the driver
        checkoutFlow = new CheckoutFlow(driver);    // <-- initialize AFTER driver is ready
        System.out.println("CheckoutFlow initialized.");

    }

    @Test(description = "Verify checkout functionality")
    @Description("Test Description: Verify checkout functionality")
    @Feature("Checkout Feature")
    @Story("User Checkout")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckout() {
//        checkoutFlow.placeOrder();
//        System.out.println("Checkout test executed successfully.");
        // Add assertions or verifications as needed
        // For example, you can check if the order confirmation page is displayed
         Assert.assertTrue(checkoutFlow.placeOrder(), "Order confirmation not displayed.");
    }
}
