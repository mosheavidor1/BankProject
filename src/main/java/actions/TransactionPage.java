package actions;

import infra.validations.TransactionValidation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import infra.wait.WaitUntil;

public class TransactionPage {
    private final WebDriver driver;
    private final WaitUntil wait;

    public TransactionPage(WebDriver driver, WaitUntil wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickTransactionsButton() {
        wait.waitForElementToBeClickable(By.xpath("//button[normalize-space()='Transactions']")).click();
    }


    public boolean validateTransactions() {

        return TransactionValidation.validateTransactionDetails(driver);

    }
}
