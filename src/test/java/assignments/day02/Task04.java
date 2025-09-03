package assignments.day02;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task04 {

//    Task 4: Multiple Navigation and Verification

//    Setup: Launch Chrome and maximize in @BeforeAll.

//    Test 1:
//    Navigate Google → YouTube → LinkedIn.
//    Assert titles contain "Google", "YouTube", "LinkedIn" respectively.

//    Test 2:
//    Navigate back twice and assert the URL of Google.
//    Navigate forward twice and assert URL of LinkedIn.

//    Teardown: Use @AfterAll  to quit the browser.

    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void test1() {
//    Navigate Google → YouTube → LinkedIn.
//    Assert titles contain "Google", "YouTube", "LinkedIn" respectively.
        driver.navigate().to("https://www.google.com/");
        String title = driver.getTitle();
        Assertions.assertTrue(title.contains("Google"), "Title does not contain 'Google'");
        System.out.println("Google Title: " + title);

        driver.navigate().to("https://www.youtube.com/");
        title = driver.getTitle();
        Assertions.assertTrue(title.contains("YouTube"), "Title does not contain 'YouTube'");
        System.out.println("YouTube Title: " + title);

        driver.navigate().to("https://www.linkedin.com/");
        title = driver.getTitle();
        Assertions.assertTrue(title.contains("LinkedIn"), "Title does not contain 'LinkedIn'");
        System.out.println("LinkedIn Title: " + title);
    }

    @Test
    void test2() throws InterruptedException {

        driver.navigate().back();
        Thread.sleep(1000);


        driver.navigate().back();
        Thread.sleep(1000);

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("google"), "URL does not contain 'google'");
        System.out.println("Current URL after navigating back twice: " + currentUrl);

        driver.navigate().forward();
        Thread.sleep(1000);

        driver.navigate().forward();
        Thread.sleep(1000);

        currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("linkedin"), "URL does not contain 'linkedin'");
        System.out.println("Current URL after navigating forward twice: " + currentUrl);
    }

    @AfterAll
    static void trearDown() {
        driver.quit();
    }

}
