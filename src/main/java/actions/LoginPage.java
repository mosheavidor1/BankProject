

package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import infra.wait.WaitUntil;

import static infra.page_locators.LoginLocators.*;

// The 'LoginPage' class manages actions and interactions related to the login functionality of a web application using Selenium WebDriver
// It provides methods to navigate to the login page, click the customer login button, select a user from the dropdown, and click the login button
// Utilizes 'WaitUntil' for element synchronization and defines constants for locators to improve code maintainability and readability
// Handles navigation to the login page and various login steps such as user selection and login button click within the application


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
        wait.waitForElementToBeClickable(By.xpath(CUSTOMER_LOGIN_BUTTON_LOCATOR)).click();
    }

    public void selectUser(String userName) {
        WebElement userSelectElement = wait.waitForElementToBeVisible(By.cssSelector(USER_SELECT_LOCATOR));
        userSelectElement.click();
        wait.waitForElementToBeClickable(By.xpath("//option[contains(text(), '" + userName + "')]")).click();
    }

    public void clickLoginButton() {
        WebElement loginButton = wait.waitForElementToBeClickable(By.xpath(LOGIN_BUTTON_LOCATOR));
        loginButton.click();
    }
}
