package assignments.day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task03 {

//    Task 3: Browser Size and Position

//    Setup: Open Chrome in @BeforeEach.

//    Test 1:
//    Navigate to https://www.bbc.com/.
//    Set browser size to 800x600 and assert the window size.

//    Test 2:
//    Move the window to position (100, 100) and assert its position.

//    Teardown: Close the browser.

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void test1() {
        driver.navigate().to("https://www.bbc.com/");
        driver.manage().window().setSize(new Dimension(800, 600));
        Dimension size = driver.manage().window().getSize();
        Assertions.assertEquals(800, size.getWidth(), "Width is not 800");
        Assertions.assertEquals(600, size.getHeight(), "Height is not 600");
        System.out.println("Window size: " + size);
    }

    @Test
    void test2() {
        driver.navigate().to("https://www.bbc.com/");
        driver.manage().window().setPosition(new Point(100, 100));
        Point position = driver.manage().window().getPosition();
        Assertions.assertEquals(100, position.getX(), "X position is not 100");
        Assertions.assertEquals(100, position.getY(), "Y position is not 100");
        System.out.println("Window position: " + position);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
