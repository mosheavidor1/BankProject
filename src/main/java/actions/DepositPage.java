

package actions;

import infra.wait.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static infra.page_locators.DepositLocators.*;

// The 'DepositPage' class handles operations related to deposit functionality in a web application using Selenium WebDriver
// It includes methods to deposit an amount, click on the deposit button, input the amount, submit the deposit, and validate success messages
// Utilizes 'WaitUntil' for element synchronization and defines constants for locators and messages to enhance maintainability and readability
// Error handling for missing elements, clickability issues, and success validation are in this class methods




public class DepositPage {
    private final WebDriver driver;
    private final WaitUntil wait;



    public DepositPage(WebDriver driver, WaitUntil wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void depositAmount(String amount) {
        clickDepositButton();
        enterAmount(amount);
        clickOnSubmitDeposit();
        clickWithdrawalButton();
    }

    private void clickDepositButton() {
        WebElement depositButton = wait.waitForElementToBeClickable(By.xpath(DEPOSIT_BUTTON_LOCATOR));
        depositButton.click();
    }

    private void enterAmount(String amount) {
        WebElement amountField = wait.waitForElementToBeVisible(By.xpath(AMOUNT_INPUT_LOCATOR));
        amountField.sendKeys(amount);
    }

    private void clickOnSubmitDeposit() {
        try {
            WebElement clickOnSubmit = wait.waitForElementToBeClickable(By.cssSelector(SUBMIT_BUTTON_LOCATOR));
            if (clickOnSubmit.isDisplayed()) {
                clickOnSubmit.click();
                checkSuccessMessage();
            } else {
                System.out.println(ELEMENT_NOT_CLICKABLE);
            }
        } catch (NoSuchElementException e) {
            System.out.println(ELEMENT_NOT_FOUND);
        }
    }

    public void checkSuccessMessage() {
        try {
            WebElement successMessage = driver.findElement(By.xpath(SUCCESS_MESSAGE_LOCATOR));

            if (successMessage.isDisplayed()) {
                System.out.println(DEPOSIT_SUCCESSFUL);
            } else {
                System.out.println(ELEMENT_NOT_DISPLAYED);
            }
        } catch (NoSuchElementException e) {
            System.out.println(ELEMENT_NOT_FOUND_TEST_FAILED);
        }
    }

    private void clickWithdrawalButton() {
        try {
            WebElement withdrawalButton = wait.waitForElementToBeClickable(By.xpath(WITHDRAWAL_BUTTON_LOCATOR));
            withdrawalButton.click();
        } catch (Exception e) {
            throw new RuntimeException("Clicking Withdrawal button failed: " + e.getMessage());
        }
    }
}


