package assignments.day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task02 {

//    Task 2: Page Source Validation

//    Setup: Use @BeforeEach to open Chrome and maximize.

//    Test 1:
//    Navigate to https://www.selenium.dev/.
//    Verify that the page source contains the word "WebDriver".

//    Test 2:
//    Navigate to https://www.python.org/.
//    Assert the page source contains "Python".

//    Teardown: Close the browser with @AfterEach.

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void test1() {
        driver.navigate().to("https://www.selenium.dev/");
        String pageSource = driver.getPageSource();
        Assertions.assertTrue(pageSource.contains("WebDriver"), "Page source does not contain 'WebDriver'");
    }

    @Test
    void test2() {
        driver.navigate().to("https://www.python.org/");
        String pageSource = driver.getPageSource();
        Assertions.assertTrue(pageSource.contains("Python"), "Page source does not contain 'Python'");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
