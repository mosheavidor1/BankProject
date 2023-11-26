package actions;

import infra.validations.TransactionValidation;
import infra.wait.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DepositPage {

    private final WebDriver driver;
    private final WaitUntil wait;

    public DepositPage(WebDriver driver, WaitUntil wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Action: Deposit amount
    public void depositAmount(String amount) {
        clickDepositButton();
        enterAmount(amount);
        submitDeposit();
        clickWithdrawalButton();

    }

    // Action: Click Deposit button
    private void clickDepositButton() {
        WebElement depositButton = wait.waitForElementToBeClickable(By.xpath("//button[normalize-space()='Deposit']"));
        depositButton.click();
    }

    // Action: Enter amount in the field
    private void enterAmount(String amount) {
        WebElement amountField = wait.waitForElementToBeVisible(By.xpath("//input[@placeholder='amount']"));
        amountField.sendKeys(amount);
    }

    // Action: Submit the deposit
    private void submitDeposit() {
        wait.waitForElementToBeClickable(By.cssSelector("button[type='submit']")).click();
    }


    // Validation: Check if deposit is successful
    public boolean isDepositSuccessful() {
        return  checkSuccessMessage("Deposit Successful");

    }



    private boolean checkSuccessMessage(String message) {
        try {
            WebElement successMessage = driver.findElement(By.xpath("//span[@class='error ng-binding' and text()='" + message + "']"));
            return successMessage.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
        private void clickWithdrawalButton() {
            try {
                WebElement withdrawalButton = wait.waitForElementToBeClickable(By.xpath("//button[normalize-space()='Withdrawl']"));
                withdrawalButton.click();
            } catch (Exception e) {
                throw new RuntimeException("Clicking Withdrawal button failed: " + e.getMessage());
            }
        }

    }

