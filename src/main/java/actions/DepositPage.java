
package actions;

import infra.wait.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        WebElement depositButton = wait.waitForElementToBeClickable(By.xpath("//button[normalize-space()='Deposit']"));
        depositButton.click();

    }

    private void enterAmount(String amount) {
        WebElement amountField = wait.waitForElementToBeVisible(By.xpath("//input[@placeholder='amount']"));
        amountField.sendKeys(amount);
    }

    private void clickOnSubmitDeposit() {
        try {
            WebElement clickOnSubmit = wait.waitForElementToBeClickable(By.cssSelector("button[type='submit']"));
            if (clickOnSubmit.isDisplayed()) {
                clickOnSubmit.click();
                checkSuccessMessage();
            } else {
                System.out.println("Element is not clickable");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found");
        }
    }

            public void checkSuccessMessage () {
                try {
                    WebElement successMessage = driver.findElement(By.xpath("//span[@class='error ng-binding' and text()='Deposit Successful']"));

                    if (successMessage.isDisplayed()) {
                        System.out.println("Deposite successfull");
                    } else {
                        System.out.println("Element found but not displayed");
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("Element not found test failed ");
                }
            }


                private void clickWithdrawalButton(){
                    try {
                        WebElement withdrawalButton = wait.waitForElementToBeClickable(By.xpath("//button[normalize-space()='Withdrawl']"));
                        withdrawalButton.click();
                    } catch (Exception e) {
                        throw new RuntimeException("Clicking Withdrawal button failed: " + e.getMessage());
                    }
                }
            }

