package infra.validations;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TransactionValidation {

    public static boolean validateTransactionDetails(WebDriver driver) {
        WebElement tbodyElement;
        try {
            tbodyElement = driver.findElement(By.xpath("//tbody"));
        } catch (NoSuchElementException e) {
            System.out.println("No transactions yet");
            WebElement withDrawlButton = driver.findElement(By.xpath("//button[normalize-space()='Back']"));
            withDrawlButton.click();
            driver.quit();
            return false;
        }

        List<WebElement> transactionDetails = tbodyElement.findElements(By.xpath("//tr[@id='anchor0']/td"));
        boolean transactionsFound = !transactionDetails.isEmpty();

        if (transactionsFound && transactionDetails.size() >= 4) {
            System.out.println("Transactions found");


            String amount = transactionDetails.get(0).getText();
            String type = transactionDetails.get(1).getText();
            String value1 = transactionDetails.get(2).getText();
            String value2 = transactionDetails.get(3).getText();


            assertEquals("200", amount);
            assertEquals("Credit", type);
            assertEquals("100", value1);
            assertEquals("100", value2);


            return true;
        } else {
            if (transactionsFound) {
                System.out.println("Transactions appears as expected");
            } else {
                System.out.println("No transactions yet");
                WebElement backButton = driver.findElement(By.xpath("//button[normalize-space()='Back']"));
                backButton.click();

            }
        }
        return false;
    }
}


