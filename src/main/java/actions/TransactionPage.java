package actions;

import infra.validations.TransactionValidation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import infra.wait.WaitUntil;
import org.testng.Assert;
import static infra.page_locators.TransactionsLocators.CLICK_TRANSACTION_BUTTON;
import static infra.page_locators.TransactionsLocators.VALIDATE_TRANSACTION_MESSAGE;

// This class Defines a class 'TransactionPage' for handling transaction-related
// actions and validations in a web application using Selenium WebDriver
// It contains methods to click on a transaction button and validate transaction details by
// using WaitUntil, TransactionValidation, and Assert functionalities.





public class TransactionPage {
    private final WebDriver driver;
    private final WaitUntil wait;


    public TransactionPage(WebDriver driver, WaitUntil wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void clickTransactionsButton() {

        WebElement transactionsButton = wait.waitForElementToBeClickable(By.xpath(CLICK_TRANSACTION_BUTTON));
        transactionsButton.click();
    }


    public void validateTransactions() {

        boolean isTransactionValid = TransactionValidation.validateTransactionDetails(driver);

        Assert.assertFalse(isTransactionValid, VALIDATE_TRANSACTION_MESSAGE);
    }
}
