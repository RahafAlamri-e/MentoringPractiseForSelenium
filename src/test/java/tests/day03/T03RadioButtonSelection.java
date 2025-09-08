package tests.day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T03RadioButtonSelection {
    /*
    Task: Navigate to "https://demoqa.com/radio-button"
        . Create a test that:

        Attempts to select each radio button (Yes, Impressive, No)---done
        Prints whether each option is enabled/disabled----done
        For enabled options, select them and verify selection
        Print confirmation message for each successful selection
    */

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    void radioButtonTest() {
        // Locate labels instead of inputs
        WebElement yesLabel = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        WebElement impressiveLabel = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        WebElement noRadio = driver.findElement(By.xpath("//input[@id='noRadio']"));

        // Test Yes
        testRadioButton(yesLabel, driver.findElement(By.id("yesRadio")), "Yes");

        // Test Impressive
        testRadioButton(impressiveLabel, driver.findElement(By.id("impressiveRadio")), "Impressive");

        // Test No
        testRadioButton(null, noRadio, "No");
    }

    private void testRadioButton(WebElement label, WebElement radioButton, String name) {
        if (radioButton.isEnabled()) {
            System.out.println(name + " option is enabled ");

            // Click label (to avoid intercept exception)
            if (label != null) label.click();

            Assertions.assertTrue(radioButton.isSelected(), name + " should be selected!");
            System.out.println(name + " has been successfully selected ");
        } else {
            System.out.println(name + " option is disabled ");
        }
    }

}