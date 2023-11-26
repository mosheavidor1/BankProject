package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import infra.wait.WaitUntil;

public class LoginPage {
    private final WebDriver driver;
    private final WaitUntil wait;

    public LoginPage(WebDriver driver, WaitUntil wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void navigateToLoginPage(String url) {
        driver.get(url);
    }

    public void clickCustomerLoginButton() {
        wait.waitForElementToBeClickable(By.xpath("//button[normalize-space()='Customer Login']")).click();
    }

    public void selectUser(String userName) {
        WebElement userSelectElement = wait.waitForElementToBeVisible(By.cssSelector("#userSelect"));
        userSelectElement.click();
        wait.waitForElementToBeClickable(By.xpath("//option[contains(text(), '" + userName + "')]")).click();
    }

    public void clickLoginButton() {
        WebElement loginButton = wait.waitForElementToBeClickable(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();
    }
}
