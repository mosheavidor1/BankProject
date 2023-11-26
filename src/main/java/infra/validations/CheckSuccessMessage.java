package infra.validations;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckSuccessMessage {

    public static boolean isOperationSucceed(WebDriver driver, String message) {
        try {
            // Check if the element with the specified class and text appears
            WebElement successMessage = driver.findElement(By.xpath("//span[@class='error ng-binding' and text()='" + message + "']"));

            if (successMessage.isDisplayed()) {
                System.out.println("Test succeeded: " + message + " Successful");
                return true;
            } else {
                System.out.println("Element found but not displayed");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: Test failed");
        }
        return false;
    }
}
