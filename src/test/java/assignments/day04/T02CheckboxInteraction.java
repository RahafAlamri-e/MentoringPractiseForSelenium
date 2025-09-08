package assignments.day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T02CheckboxInteraction {
    /*
    Task: Go to "https://the-internet.herokuapp.com/checkboxes"
.   Write a method that:

    Checks the current state of both checkboxes
    Ensures both checkboxes are selected (click only if not already selected)
    Verify both checkboxes are checked after the operations
    Print the status of each checkbox to console */
    WebDriver driver;
    By checkbox1ByXpath = By.xpath("(//input[@type='checkbox'])[1]");
    By checkbox2ByXpath = By.xpath("(//input[@type='checkbox'])[2]");

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

    @Test
    void checkboxInteractionTest(){
        // Checks the current state of both checkboxes
        System.out.println("Checkbox1 Before operations selected: " + driver.findElement(checkbox1ByXpath).isSelected());
        System.out.println("Checkbox2 Before operations selected: " + driver.findElement(checkbox2ByXpath).isSelected());

        // Ensures both checkboxes are selected (click only if not already selected)
        if (!driver.findElement(checkbox1ByXpath).isSelected()) {
            driver.findElement(checkbox1ByXpath).click();
        }
        if (!driver.findElement(checkbox2ByXpath).isSelected()) {
            driver.findElement(checkbox2ByXpath).click();
        }

        // Verify both checkboxes are checked after the operations
        Assertions.assertTrue(driver.findElement(checkbox1ByXpath).isSelected());
        Assertions.assertTrue(driver.findElement(checkbox2ByXpath).isSelected());

        System.out.println("Checkbox1 after the operations selected: " + driver.findElement(checkbox1ByXpath).isSelected());
        System.out.println("Checkbox2 after the operations selected: " + driver.findElement(checkbox2ByXpath).isSelected());

    }

}