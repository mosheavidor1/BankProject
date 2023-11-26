package test;

import actions.DepositWithdrawalPage;
import actions.LoginPage;
import actions.TransactionPage;
import infra.wait.WaitUntil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class BankTesting {

    private WebDriver driver;
    private LoginPage loginPage;
    private TransactionPage transactionPage;
    private DepositWithdrawalPage depositWithdrawalPage;
    private WaitUntil wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WaitUntil(driver, 10); // Set the timeout as needed

        loginPage = new LoginPage(driver, wait);
        transactionPage = new TransactionPage(driver, wait);
        depositWithdrawalPage = new DepositWithdrawalPage(driver, wait);

        loginPage.navigateToLoginPage("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Test()
    public void customerLoginClick() throws InterruptedException {
        loginPage.clickCustomerLoginButton();
        loginPage.selectUser("Harry Potter");
        loginPage.clickLoginButton();

        transactionPage.clickTransactionsButton();

        try {
            transactionPage.getTbodyElement();
            // Assert: Verify presence of transaction table
            // Assert.assertTrue(transactionPage.isTransactionTableDisplayed(), "Transaction table is displayed");
            // Implement further actions/assertions using Page Object methods
            // ...
        } catch (NoSuchElementException e) {
            System.out.println("No transactions yet");
            // Handle accordingly...
        }

        depositWithdrawalPage.depositAmount("200");
        // Assertion for Deposit actions
        // Assert.assertTrue(depositWithdrawalPage.isDepositSuccessful(), "Deposit of $200 is successful");

        depositWithdrawalPage.withdrawAmount("100");
        // Assertion for Withdrawal actions
        // Assert.assertTrue(depositWithdrawalPage.isWithdrawalSuccessful(), "Withdrawal of $100 is successful");

        transactionPage.clickTransactionsButton();

        // Validate transactions after deposit and withdrawal actions
        boolean transactionsValidated = transactionPage.validateTransactions();

        if (transactionsValidated) {
            // Assertion: Handle successful validation of transactions
            // SomeAssertions.verifySomething();
            // AnotherAssertions.verifyAnotherThing();
        } else {
            // Assertion: Handle scenario where transactions were not validated
            // HandleError.handleErrorScenario();
        }
    }

    @AfterClass
    public void teardown() {
        // Close the driver or perform necessary cleanup
        driver.quit();
    }
}
