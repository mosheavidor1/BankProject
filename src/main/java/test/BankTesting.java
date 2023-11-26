package test;

import actions.DepositPage;
import actions.LoginPage;
import actions.TransactionPage;
import actions.WithdrawalPage;
import infra.wait.WaitUntil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BankTesting {

    private WebDriver driver;
    private LoginPage loginPage;
    private TransactionPage transactionPage;
    private WithdrawalPage withdrawalPage;
    private DepositPage depositePage;
    private WaitUntil wait;


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WaitUntil(driver, 10); // Set the timeout as needed

        loginPage = new LoginPage(driver, wait);
        transactionPage = new TransactionPage(driver, wait);
        depositePage = new DepositPage(driver, wait);

        withdrawalPage = new WithdrawalPage(driver, wait);

        loginPage.navigateToLoginPage("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().fullscreen();
    }

    @Test(priority = 1)
    public void customerLoginClick() throws InterruptedException {
        loginPage.clickCustomerLoginButton();
        loginPage.selectUser("Harry Potter");
        loginPage.clickLoginButton();


    }


    @Test(priority = 2)

    public void validateNoTransactions() throws InterruptedException {
        transactionPage.clickTransactionsButton();

        try {
            transactionPage.validateTransactions();


        } catch (NoSuchElementException e) {
            System.out.println("No transactions yet");

        }


    }


    @Test(priority = 3)
    public void newDeposit() throws InterruptedException {
        depositePage.depositAmount("200");

        // Assertion for Deposit actions
        boolean isDepositSuccessful = depositePage.isDepositSuccessful();
        Assert.assertTrue(isDepositSuccessful, "Deposite successfull");
        System.out.println("Deposite successfull");

    }

    @Test(priority = 4)


    public void newWithdrawal() {
        String withdrawalAmount = "100";
        System.out.println("Attempting to withdraw amount: " + withdrawalAmount);
        withdrawalPage.withdrawAmount(withdrawalAmount);


        WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
        wait.pollingEvery(500, TimeUnit.MILLISECONDS); // Polling interval if needed

        boolean isWithdrawalSuccessful = wait.until(ExpectedConditions.visibilityOfElementLocated(yourSuccessElementLocator)).isDisplayed();

        Assert.assertTrue(isWithdrawalSuccessful, "Withdrawal successful");
        System.out.println("Withdrawal successful");
    }
}




//    }
//
//
//
//
//    public class YourTestClass {
//
//        @Test(priority = 5)
//        public void validateTransactionsAppears() {
//            transactionPage.clickTransactionsButton();
//
//            // Validate transactions after deposit and withdrawal actions
//            boolean transactionsValidated = transactionPage.validateTransactions();
//
//            // Assert if transactions were validated successfully
//            Assert.assertTrue(transactionsValidated, "Transactions were not validated successfully");
//        }
//    }
//}





//    @AfterClass
//    public void teardown() {
//        // Close the driver or perform necessary cleanup
//        driver.quit();


