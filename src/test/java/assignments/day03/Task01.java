package assignments.day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task01 {

    WebDriver driver;
    String url = "https://testpages.herokuapp.com/styled/index.html";
    By locatorsLinkXpath = By.xpath("//a[@id='findbytest']");
    By webDriverExampleLinkXpath = By.xpath("//a[@id='webdriverexamplepage']");
    By numberInputBox = By.xpath("//input[@id='numentry']");
    By message = By.xpath("//p[@id='message']");

    // TODO: Navigate to test pages
    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }



    @Test
    void test01() throws InterruptedException {
        // TODO: Click on "Locators - Find By Playground Test Page"
        WebElement locatorsLinkClick = driver.findElement(locatorsLinkXpath);
        locatorsLinkClick.click();
        Thread.sleep(1000);

        // TODO: Print current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // TODO: Navigate back
        driver.navigate().back();
        Thread.sleep(1000);

        // TODO: Print URL after going back
        System.out.println("URL after going back: " + driver.getCurrentUrl());

        // TODO: Click on "WebDriver Example Page"
        WebElement webDriverExampleLinkClick = driver.findElement(webDriverExampleLinkXpath);
        webDriverExampleLinkClick.click();
        Thread.sleep(1000);

        // TODO: Print current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // TODO: Enter value 20 in number input
        int num = 20;
        WebElement numberInput = driver.findElement(numberInputBox);
        numberInput.sendKeys(String.valueOf(num), Keys.ENTER);
        Thread.sleep(1000);

        // TODO: Verify 'two, zero' message appears
        WebElement messageElement = driver.findElement(message);
        String expectedMessage = "two, zero";
        String actualMessage = messageElement.getText();
        Assertions.assertEquals(expectedMessage, actualMessage);
        System.out.println("Message: " + actualMessage);
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

}
