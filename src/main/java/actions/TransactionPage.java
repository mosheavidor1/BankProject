package actions;

import infra.validations.TransactionValidation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import infra.wait.WaitUntil;
import org.testng.Assert;

public class TransactionPage {
    private final WebDriver driver;
    private final WaitUntil wait;

    public TransactionPage(WebDriver driver, WaitUntil wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickTransactionsButton() {
        WebElement transactionsButton = wait.waitForElementToBeClickable(By.xpath("//button[normalize-space()='Transactions']"));
        transactionsButton.click();
    }

    public void validateTransactions() {

        boolean isTransactionValid = TransactionValidation.validateTransactionDetails(driver);
        Assert.assertFalse(isTransactionValid, "Transaction details validation failed");
    }
}


