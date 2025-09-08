package tests.day01;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Go to YouTube homepage---done
// Do the following tasks by creating 4 different test methods.-----done
// Print "Test is running" before each test() method-----done
// Print "Test finished" after each test() method----done
// Test if the currentURL contains "youtube"---- done
// Test if the title does not contain "Video".---- done
// Test if the URL contains "Video".------ done.. i made some changes here
// Test if the sourcePage contains "youtube". -----done

public class C05JunitTests01 {

    static WebDriver driver;

    @Test
    void titleTest01(){
        System.out.println("title does not contain \"Video\" test is executed ...");
        String title = driver.getTitle();
        Assertions.assertFalse(title.contains("Video"));
    }

    @Test
    void urlTest01(){
        System.out.println("currentURL contains \"youtube\" test is executed ...");
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("youtube"));
    }

    @Test
    void titleTest02(){
        System.out.println("title contain \"youtube\" test is executed ...");
        String title = driver.getTitle();
        Assertions.assertTrue(title.contains("youtube"));
    }

    @Test
    void urlTest02(){
        System.out.println("currentURL does not contains \"Video\" test is executed ...");
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertFalse(currentUrl.contains("youtube"));

    }


    @Test
    void pageSourceTest(){
        System.out.println("sourcePage contains \"youtube\" test is executed ...");
        Assertions.assertTrue(driver.getPageSource().contains("youtube"));

    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Test is running");
    }

    @AfterEach
    void afterEach(){
        System.out.println("Test finished");
    }

    @BeforeAll
    public static void setUp(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");

    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }




}
