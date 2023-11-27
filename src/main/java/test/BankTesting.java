package test;

import actions.DepositPage;
import actions.LoginPage;
import actions.TransactionPage;
import actions.WithdrawalPage;
import infra.wait.WaitUntil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static infra.page_locators.Urls.webSiteURL;

public class BankTesting {

    private WebDriver driver;
    private LoginPage loginPage;

    private WithdrawalPage withdrawalPage;
    private DepositPage depositePage;
    private WaitUntil wait;

    private TransactionPage transactionPage;


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WaitUntil(driver, 10);

        loginPage = new LoginPage(driver, wait);
        depositePage = new DepositPage(driver, wait);
        withdrawalPage = new WithdrawalPage(driver, wait);
        transactionPage = new TransactionPage(driver, wait);

        loginPage.navigateToLoginPage(webSiteURL);
        driver.manage().window().fullscreen();
    }

    @Test(priority = 1)
    public void customerLoginClick() {
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
            e.getMessage();

        }


    }


    @Test(priority = 3)
    public void setDeposit() {
        depositePage.depositAmount("200");

    }

    @Test(priority = 4)

    public void setWithdrawalPage() throws InterruptedException {

        Thread.sleep(500);
        withdrawalPage.enterAmount("100");
    }



    @Test(priority = 5)
    public void validateTransactionsAppears() throws InterruptedException {
        Thread.sleep(1000);
        transactionPage.clickTransactionsButton();
        transactionPage.validateTransactions();



    }


 }
