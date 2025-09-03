package assignments.day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task01 {

//    Task 1: Browser History Exploration

//    Setup: Use @BeforeEach to launch Chrome and maximize.

//    Test 1:
//    Navigate to https://www.wikipedia.org/.
//    Navigate to https://www.google.com/.
//    Navigate back and forward multiple times, asserting the correct title at each step.

//    Test 2:
//    Use driver.navigate().refresh() on Google and assert the title still contains "Google".

//    Teardown: Use @AfterEach to close the browser.

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    void test1() throws InterruptedException {
        driver.navigate().to("https://www.wikipedia.org/");
        Thread.sleep(1000);

        driver.navigate().to("https://www.google.com/");
        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getTitle().contains("Wikipedia"), "Title does not contain 'Wikipedia'");
        System.out.println("Title after first navigating back: " + driver.getTitle());

        driver.navigate().forward();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getTitle().contains("Google"), "Title does not contain 'Google'");
        System.out.println("Title after first navigating forward: " + driver.getTitle());

        driver.navigate().forward();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getTitle().contains("Google"), "Title does not contain 'Google'");
        System.out.println("Title after second navigating forward: " + driver.getTitle());

        driver.navigate().back();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getTitle().contains("Wikipedia"), "Title does not contain 'Wikipedia'");
        System.out.println("Title after second navigating back: " + driver.getTitle());

    }

    @Test
    void test2() throws InterruptedException {
        driver.navigate().to("https://www.google.com/");
        driver.navigate().refresh();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getTitle().contains("Google"), "Title does not contain 'Google' after refresh");
        System.out.println("Title after refresh: " + driver.getTitle());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
