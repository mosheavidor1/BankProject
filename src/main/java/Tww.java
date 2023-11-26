import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Tww {

    public WebDriver driver;


    @BeforeClass

    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

    }


    @Test()
    public void customerLoginClick() throws InterruptedException {

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[normalize-space()='Customer Login']")).click();

        Thread.sleep(4000);
        WebElement userSelectElement = driver.findElement(By.cssSelector("#userSelect"));

        if (userSelectElement.isDisplayed()) {

            userSelectElement.click();
        }
        Thread.sleep(4000);
        WebElement harryPotterOption = driver.findElement(By.xpath("//option[@class='ng-binding ng-scope' and contains(text(), 'Harry Potter')]"));
        harryPotterOption.click();


        Thread.sleep(4000);

        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        Thread.sleep(4000);

    }
}
