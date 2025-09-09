package assignments.day05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class T06OldStyleSelecMenu {
//    Launch browser
//    Open https://demoqa.com/select-menu
//    Select Old Style Select Menu using element id
//    Print all dropdown options
//    Select 'Purple' using index
//    Select 'Magenta' using visible text
//    Select an option using value
//    Close browser

    WebDriver driver;
    String url = "https://demoqa.com/select-menu";
    By selectOldStyleById = By.id("oldSelectMenu");

    @Test
    void test(){
        driver.get(url);
        Select select = new Select(driver.findElement(selectOldStyleById));

        List<WebElement>options = select.getOptions();
        options.forEach(t-> System.out.println(t.getText()));

        select.selectByIndex(4);
        System.out.println("selectByIndex: "+select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Magenta");
        System.out.println("selectByVisibleText: "+select.getFirstSelectedOption().getText());

        select.selectByValue("6");
        System.out.println("selectByValue: "+select.getFirstSelectedOption().getText());

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
