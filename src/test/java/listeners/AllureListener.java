package listeners;
import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

    public class AllureListener implements ITestListener {

        public void onTestFailure(ITestResult result) {
            attachScreenshot(result, "Failure Screenshot");
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            attachScreenshot(result, "Success Screenshot");
        }

        private void attachScreenshot(ITestResult result, String attachmentName) {
            Object testClass = result.getInstance();
            WebDriver driver = ((BaseTest) testClass).driver;

            if (driver != null) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.getLifecycle().addAttachment(
                        attachmentName,
                        "image/png",
                        "png",
                        screenshot
                );
            }
        }
    }


