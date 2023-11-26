package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import infra.wait.WaitUntil;

public class DepositWithdrawalPage {
    private final WebDriver driver;
    private final WaitUntil wait;

    public DepositWithdrawalPage(WebDriver driver, WaitUntil wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void depositAmount(String amount) {
        wait.waitForElementToBeClickable(By.xpath("//button[normalize-space()='Deposit']")).click();
        WebElement amountField = wait.waitForElementToBeVisible(By.xpath("//input[@placeholder='amount']"));
        amountField.sendKeys(amount);
        wait.waitForElementToBeClickable(By.cssSelector("button[type='submit']")).click();
    }

    public void withdrawAmount(String amount) {
        wait.waitForElementToBeClickable(By.xpath("//button[normalize-space()='Withdrawl']")).click();
        WebElement amountField = wait.waitForElementToBeVisible(By.xpath("//input[@placeholder='amount']"));
        amountField.sendKeys(amount);
        wait.waitForElementToBeClickable(By.cssSelector("button[type='submit']")).click();
    }
    // Other methods related to the Deposit/Withdrawal page as needed...
}
