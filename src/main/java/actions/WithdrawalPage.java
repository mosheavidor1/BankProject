
package actions;

import infra.wait.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WithdrawalPage {

    private final WebDriver driver;
    private final WaitUntil wait;

    public WithdrawalPage(WebDriver driver, WaitUntil wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterAmount(String amount) {
        try {
            WebElement amountElement = wait.waitForElementToBeClickable(By.xpath("//input[@placeholder='amount']"));
            if (amountElement.isDisplayed()) {
                amountElement.sendKeys(amount);
                clickOnSubmitWithdrawal();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found");
        }
    }

    public void clickOnSubmitWithdrawal() {
        try {
            WebElement clickOnSubmit = wait.waitForElementToBeClickable(By.xpath("//button[@type='submit']"));
            if (clickOnSubmit.isDisplayed()) {
                clickOnSubmit.click();
                succeedWithdrawal();

            } else {
                System.out.println("Element is not clickable");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found");
        }
    }

    private void succeedWithdrawal() {
        try {
            WebElement successMessage = wait.waitForElementToBeVisible(By.xpath("//span[@class='error ng-binding' and text()='Transaction successful']"));
            if (successMessage.isDisplayed()) {
                System.out.println("Withdrawal Successful");
            } else {
                System.out.println("Element found but not displayed");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: Test failed");
        }
    }
}







