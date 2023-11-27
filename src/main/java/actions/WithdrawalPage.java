package actions;

import infra.wait.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static infra.page_locators.WithdrawalLocators.*;

// The 'WithdrawalPage' class manages interactions related to withdrawal functionalities in a web application using Selenium WebDriver
// It includes methods to input withdrawal amounts, click on the withdrawal submission button, and verify successful withdrawal messages
// Utilizes 'WaitUntil' for element synchronization and predefined locators from 'WithdrawalLocators' for identifying elements
// Error messages and success validation are handled within the class methods


public class WithdrawalPage {
    private final WebDriver driver;
    private final WaitUntil wait;


    public WithdrawalPage(WebDriver driver, WaitUntil wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterAmount(String amount) {
        try {
            WebElement amountElement = wait.waitForElementToBeClickable(By.xpath(AMOUNT_INPUT_LOCATOR));
            if (amountElement.isDisplayed()) {
                amountElement.sendKeys(amount);
                clickOnSubmitWithdrawal();
            }
        } catch (NoSuchElementException e) {
            System.out.println(ELEMENT_NOT_FOUND);
        }
    }

    public void clickOnSubmitWithdrawal() {
        try {
            WebElement clickOnSubmit = wait.waitForElementToBeClickable(By.xpath(SUBMIT_BUTTON_LOCATOR));
            if (clickOnSubmit.isDisplayed()) {
                clickOnSubmit.click();
                succeedWithdrawalMessage();
            } else {
                System.out.println(ELEMENT_NOT_CLICKABLE);
            }
        } catch (NoSuchElementException e) {
            System.out.println(ELEMENT_NOT_FOUND);
        }
    }

    private void succeedWithdrawalMessage() {
        try {
            WebElement successMessage = wait.waitForElementToBeVisible(By.xpath(SUCCESS_MESSAGE_LOCATOR));
            if (successMessage.isDisplayed()) {
                System.out.println(WITHDRAWAL_SUCCESSFUL);
            } else {
                System.out.println(ELEMENT_NOT_DISPLAYED);
            }
        } catch (NoSuchElementException e) {
            System.out.println(ELEMENT_NOT_FOUND_TEST_FAILED);
        }
    }
}

