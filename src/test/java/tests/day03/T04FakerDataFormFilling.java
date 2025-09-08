package tests.day03;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T04FakerDataFormFilling {
    /*
    Task: Go to "https://demoqa.com/text-box"
        . Use Java Faker to:

        Generate and enter a fake full name
        Generate and enter a fake email address
        Generate and enter a fake current address
        Generate and enter a fake permanent address
        Submit the form and verify the output contains the entered data
    */
    WebDriver driver;
    String url = "https://demoqa.com/text-box";

    @Test
    void fakerTest() {
        driver.get(url);
        Faker faker = new Faker();
        //        Generate and enter a fake full name
        String fullName = faker.name().fullName();
        System.out.println("fullName = " + fullName);
        driver.findElement(By.id("userName")).sendKeys(fullName);

        //        Generate and enter a fake email address
        String email = faker.internet().emailAddress();
        driver.findElement(By.id("userEmail")).sendKeys(email);
        System.out.println("email = " + email);

        //        Generate and enter a fake current address
        String currentAddress = faker.address().fullAddress();
        System.out.println("currentAddress = " + currentAddress);
        driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);

        //        Generate and enter a fake permanent address
        String permanentAddress = faker.address().fullAddress();
        System.out.println("permanentAddress = " + permanentAddress);
        driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddress);
        driver.findElement(By.id("permanentAddress")).submit();

        //        Submit the form and verify the output contains the entered data
//        driver.findElement(By.id("submit")).click();

        WebElement output = driver.findElement(By.id("output"));
        System.out.println("output.getText() = " + output.getText());
//        Assertions.assertTrue(driver.findElement(By.xpath()));
        assert output.getText().contains(fullName);
        assert output.getText().contains(email);
        assert output.getText().contains(currentAddress);
        assert output.getText().contains(permanentAddress);

    }

    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}