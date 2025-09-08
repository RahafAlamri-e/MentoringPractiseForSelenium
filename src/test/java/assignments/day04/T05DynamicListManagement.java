package assignments.day04;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class T05DynamicListManagement {
    /*
    Task:  Go to "http://webdriveruniversity.com/To-Do-List/index.html" and create a test that:

            Uses Faker to generate 5 random task names
            Adds all tasks to the todo list
            Marks every other task as completed (strikethrough)
            Deletes all completed tasks
            Verifies only incomplete tasks remain
    */

    WebDriver driver;
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void dynamicListManagementTest() throws InterruptedException {
        Faker faker = new Faker();
        // Generate 5 random task names
        for (int i = 0; i < 5; i++) {
            String taskName = faker.lorem().word();
            System.out.println("Generated Task: " + taskName);
            driver.findElement(By.xpath("//input")).sendKeys(taskName, Keys.ENTER);
            Thread.sleep(1000);
        }
//        Marks every other task as completed (strikethrough)
        List<WebElement> tasks = driver.findElements(By.xpath("//ul//li"));
        for (int i = 0; i < 3; i++) {
            tasks.get(i).click();
            Thread.sleep(1000);
        }

        // Deletes all completed tasks
        List<WebElement> completedTasks = driver.findElements(By.xpath("//li[@class='completed']"));
        for (WebElement task : completedTasks) {
            task.findElement(By.xpath("//*[@class=\"fa fa-trash\"]")).click();
            Thread.sleep(1000);
        }
        // Verifies only incomplete tasks remain
        int remainingTasks = driver.findElements(By.xpath("//li[not(@class='completed')]")).size();
        System.out.println("Remaining Incomplete Tasks: " + remainingTasks);
        Assertions.assertEquals(5, remainingTasks);
    }


}