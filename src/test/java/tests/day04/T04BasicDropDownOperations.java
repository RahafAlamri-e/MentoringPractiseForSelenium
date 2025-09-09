package tests.day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T04BasicDropDownOperations {
//    Go to https://the-internet.herokuapp.com/dropdown
//    Create selectByIndexTest method - Select Option 1 using index
//    Create selectByValueTest method - Select Option 2 by value
//    Create selectByVisibleTextTest method - Select Option 1 by visible text
//    Create printAllTest method - Print all dropdown values
//    Verify dropdown has Option 2 text
//    Create printFirstSelectedOptionTest - Print first selected option
//    Verify dropdown size equals 3 elements
    WebDriver driver;
    String url = "https://the-internet.herokuapp.com/dropdown";


    @Test
    void BasicDropDownOperationsTest(){
        driver.get(url);

    }





    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
