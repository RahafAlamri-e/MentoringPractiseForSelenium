package tests.day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T02CalculatorOperationsTest {

    WebDriver driver;
    String url = "https://testpages.eviltester.com/styled/calculator";
    int num1 = 20;
    int num2 = 5;
    String[] operations = {"plus", "minus", "times", "divide"};

    By firstInputById = By.id("number1");
    By secondInputById = By.id("number2");
    By calculateButtonById = By.id("calculate");
    By operationsDropdownById = By.id("function");
    By resultById = By.id("answer");

    @Test
    void calculatorOperationsTest() {
        driver.get(url);

        for (String operation : operations) {

            driver.findElement(firstInputById).clear();
            driver.findElement(firstInputById).sendKeys(String.valueOf(num1));

            driver.findElement(secondInputById).clear();
            driver.findElement(secondInputById).sendKeys(String.valueOf(num2));


            Select select = new Select(driver.findElement(operationsDropdownById));
            select.selectByValue(operation);


            driver.findElement(calculateButtonById).click();

            double actualResult = Double.parseDouble(driver.findElement(resultById).getText());


            int expectedResult = switch (operation) {
                case "plus" -> num1 + num2;
                case "minus" -> num1 - num2;
                case "times" -> num1 * num2;
                case "divide" -> num1 / num2;
                default -> throw new IllegalStateException("Unexpected value: " + operation);
            };

            Assertions.assertEquals(expectedResult, actualResult);
            System.out.println(operation + " Result: " + actualResult);
        }
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}


