package assignments.day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task02 {

    // Navigate to: https://opensource-demo.orangehrmlive.com/
    String url = "https://opensource-demo.orangehrmlive.com/";
    String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    WebDriver driver;

    String testUsername = "Admin";
    String testPassword = "admin123";


    // TODO: Locate username using absolute XPath
    By absoluteUsernameXPath = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
//    String absoluteUsernameXPath = ""; // Fill absolute path

    // TODO: Locate username using relative XPath
    By relativeUsernameXPath = By.xpath("//input[@name='username']");
//    String relativeUsernameXPath = ""; // Fill relative path

    // TODO: Locate password using both methods
    By absolutePasswordXPath = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");
    By relativePasswordXPath = By.xpath("//input[@name='password']");

    // TODO: Locate login button using both methods
    By absoluteLoginButtonXPath = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    By relativeLoginButtonXPath = By.xpath("//button[@type='submit']");


    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    // TODO: Test both approaches work
    @Test
    void relativeXpathTest() throws InterruptedException {
        driver.findElement(relativeUsernameXPath).sendKeys(testUsername);
        driver.findElement(relativePasswordXPath).sendKeys(testPassword);
        driver.findElement(relativeLoginButtonXPath).click();
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
        Thread.sleep(1000);


    }

    @Test
    void absoluteXpathTest() throws InterruptedException {
        driver.findElement(absoluteUsernameXPath).sendKeys(testUsername);
        driver.findElement(absolutePasswordXPath).sendKeys(testPassword);
        driver.findElement(absoluteLoginButtonXPath).click();
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
        Thread.sleep(1000);

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
