
package infra.validations;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static infra.page_locators.TransactionsLocators.*;
import static org.testng.Assert.assertEquals;

// 'TransactionValidation' class provides methods to validate transaction details within a web page using Selenium WebDriver
// It contains logic to verify transaction elements and their values, handles messages for various scenarios like transactions found, expected transactions, and no transactions found.
// Utilizes various locators from 'TransactionsLocators' and 'Assert.assertEquals' for validation.


public class TransactionValidation {



    public static boolean validateTransactionDetails(WebDriver driver) {
        WebElement tbodyElement;
        try {
            tbodyElement = driver.findElement(By.xpath(TEXTFIELD_LOCATOR));
        } catch (NoSuchElementException e) {
            System.out.println(NO_TRANSACTIONS_MESSAGE);
            WebElement withDrawlButton = driver.findElement(By.xpath(BACK_BUTTON_LOCATOR));
            withDrawlButton.click();
            driver.quit();
            return false;
        }

        List<WebElement> transactionDetails = tbodyElement.findElements(By.xpath(ANCHOR_TRANSACTION_LOCATOR));
        boolean transactionsFound = !transactionDetails.isEmpty();

        if (transactionsFound && transactionDetails.size() >= 4) {
            System.out.println(TRANSACTIONS_FOUND_MESSAGE);

            String amount = transactionDetails.get(0).getText();
            String type = transactionDetails.get(1).getText();
            String value = transactionDetails.get(2).getText();
            String type2 = transactionDetails.get(3).getText();

            assertEquals("200", amount);
            assertEquals("Credit", type);
            assertEquals("Debit", type2);
            assertEquals("100", value);

            return true;
        } else {
            if (transactionsFound) {
                System.out.println(EXPECTED_TRANSACTIONS_MESSAGE);
            } else {
                System.out.println(NO_TRANSACTIONS_MESSAGE);
                WebElement backButton = driver.findElement(By.xpath(BACK_BUTTON_LOCATOR));
                backButton.click();
            }
        }
        return false;
    }
}

