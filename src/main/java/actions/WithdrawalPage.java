package actions;

import infra.wait.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class WithdrawalPage {

    private final WebDriver driver;
    private final WaitUntil wait;


    public WithdrawalPage(WebDriver driver, WaitUntil wait) {

        this.driver = driver;
        this.wait = wait;
    }

    public void withdrawAmount(String amount) {
        try {
           // clickWithdrawalButton();
           enterWithdrawalAmount(amount);
            submitWithdrawal();
        } catch (Exception e) {
            Assert.fail("Withdrawal failed: " + e.getMessage());
        }
    }

//    private void clickWithdrawalButton() {
//        try {
//            WebElement withdrawalButton = wait.waitForElementToBeClickable(By.xpath("//button[normalize-space()='Withdrawl']"));
//            withdrawalButton.click();
//        } catch (Exception e) {
//            throw new RuntimeException("Clicking Withdrawal button failed: " + e.getMessage());
//        }
//    }


        private void enterWithdrawalAmount(String amount) {
            try {
                WebElement amountField = wait.waitForElementToBePresent(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));
                amountField.sendKeys(amount);
            } catch (Exception e) {
                throw new RuntimeException("Entering Withdrawal amount failed: " + e.getMessage());
            }
        }

        private void submitWithdrawal() {
            try {
                wait.waitForElementToBeClickable(By.cssSelector("button[type='submit']")).click();
            } catch (Exception e) {
                throw new RuntimeException("Submit Withdrawal failed: " + e.getMessage());
            }
        }




    public boolean isWithdrawalSuccessful() {
        return checkSuccessMessage("Transaction successful");
    }

    private boolean checkSuccessMessage(String message) {
        try {
            WebElement successMessage = driver.findElement(By.xpath("//span[@class='error ng-binding' and text()='" + message + "']"));
            return successMessage.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
