package infra.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;




    public class WaitUntil {

        private WebDriver driver;
        private WebDriverWait wait;

        public WaitUntil(WebDriver driver, int timeInSeconds) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        }

        public WebElement waitForElementToBeVisible(By locator) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        public WebElement waitForElementToBeClickable(By locator) {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        }

        public void waitForTextToBePresentInElement(By locator, String text) {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        }

        public WebElement waitForElementToBePresent(By locator){
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
    }



