//package BackUp;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//public class BannkTesting {
//
//
//
//    public class BankTesting {
//
//        public WebDriver driver;
//
//
//        @BeforeClass
//
//        public void setup() {
//
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//
//            driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
//
//        }
//
//
//        @Test()
//        public void customerLoginClick() throws InterruptedException {
//
//            Thread.sleep(2000);
//
//            driver.findElement(By.xpath("//button[normalize-space()='Customer Login']")).click();
//
//            Thread.sleep(4000);
//            WebElement userSelectElement = driver.findElement(By.cssSelector("#userSelect"));
//
//            if (userSelectElement.isDisplayed()) {
//
//                userSelectElement.click();
//            }
//            Thread.sleep(4000);
//            WebElement harryPotterOption = driver.findElement(By.xpath("//option[@class='ng-binding ng-scope' and contains(text(), 'Harry Potter')]"));
//            harryPotterOption.click();
//
//
//            Thread.sleep(4000);
//
//            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
//
//            Thread.sleep(4000);
//
//            driver.findElement(By.xpath("//button[normalize-space()='Transactions']")).click();
//
//            Thread.sleep(4000);
//
//
//            WebElement tbodyElement = null;
//
//            try {
//                tbodyElement = driver.findElement(By.xpath("//tbody"));
//            } catch (NoSuchElementException e) {
//                System.out.println("No transactions yet");
//                WebElement backButton = driver.findElement(By.xpath("//button[normalize-space()='Back']"));
//                backButton.click();
//                driver.quit();
//                return; // Exit the method since there are no transactions
//            }
//
//            String tbodyComment = tbodyElement.getAttribute("<tr id=\"anchor0\" ng-repeat=\"tx in transactions | orderBy:sortType:sortReverse | sDate:startDate:end\" class=\"ng-scope\">");
//
//            if (tbodyComment == null || tbodyComment.isEmpty()) {
//                System.out.println("No transactions yet");
//                WebElement backButton = driver.findElement(By.xpath("//button[normalize-space()='Back']"));
//                backButton.click();
//            } else {
//                System.out.println("Transactions found");
//            }
//
//            Thread.sleep(4000);
//            driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();
//
//            Thread.sleep(4000);
//
//            driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("200");
//
//            Thread.sleep(4000);
//
//            driver.findElement(By.cssSelector("button[type='submit']")).click();
//
//            Thread.sleep(4000);
//            try {
//                // Check if the element with the specified class and text appears
//                WebElement successMessage = driver.findElement(By.xpath("//span[@class='error ng-binding' and text()='Deposit Successful']"));
//
//                if (successMessage.isDisplayed()) {
//                    System.out.println("Test succeeded: Deposit Successful");
//                } else {
//                    System.out.println("Element found but not displayed");
//                }
//            } catch (NoSuchElementException e) {
//                System.out.println("Element not found: Test failed");
//            }
//
//            Thread.sleep(4000);
//            driver.findElement(By.xpath("//button[normalize-space()='Withdrawl']")).click();
//            Thread.sleep(4000);
//            driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("100");
//            Thread.sleep(4000);
//            driver.findElement(By.cssSelector("button[type='submit']")).click();
//            Thread.sleep(4000);
//
//            try {
//                // Check if the element with the specified class and text appears
//                WebElement successMessage = driver.findElement(By.xpath("//span[@class='error ng-binding' and text()='Transaction successful']"));
//
//                if (successMessage.isDisplayed()) {
//                    System.out.println("Test succeeded: Transaction Successful");
//                } else {
//                    System.out.println("Element found but not displayed");
//                }
//            } catch (NoSuchElementException e) {
//                System.out.println("Element not found: Test failed");
//            }
//            Thread.sleep(4000);
//            driver.findElement(By.xpath("//button[normalize-space()='Transactions']")).click();
//
//            Thread.sleep(4000);
//
//            try {
//                tbodyElement = driver.findElement(By.xpath("//tbody"));
//            } catch (NoSuchElementException e) {
//                System.out.println("No transactions yet");
//                WebElement backButton = driver.findElement(By.xpath("//button[normalize-space()='Back']"));
//                backButton.click();
//                driver.quit();
//                return; // Exit the method since there are no transactions
//            }
//
//            List<WebElement> transactionDetails = tbodyElement.findElements(By.xpath("//tr[@id='anchor0']/td"));
//            boolean transactionsFound = !transactionDetails.isEmpty();
//
//            if (transactionsFound && transactionDetails.size() >= 4) {
//                System.out.println("Transactions found");
//
//                // Assuming the transaction details are in a certain order:
//                String amount = transactionDetails.get(0).getText(); // e.g., "200"
//                String type = transactionDetails.get(1).getText(); // e.g., "Credit"
//                String value1 = transactionDetails.get(2).getText(); // e.g., "100"
//                String value2 = transactionDetails.get(3).getText(); // e.g., "100"
//
//                // Perform assertions for each transaction detail
//                Assert.assertEquals("200", amount);
//                Assert.assertEquals("Credit", type);
//                Assert.assertEquals("100", value1);
//                Assert.assertEquals("100", value2);
//
//                // If any of the assertions fail, the test will stop and fail at that point
//                // Continue with further actions/assertions if needed
//                // ...
//
//            } else {
//                if (transactionsFound) {
//                    System.out.println("All transactions details found");
//                } else {
//                    System.out.println("No transactions yet");
//                }
//                WebElement backButton = driver.findElement(By.xpath("//button[normalize-space()='Back']"));
//                backButton.click();
//            }
//        }
//    }
//
//}
