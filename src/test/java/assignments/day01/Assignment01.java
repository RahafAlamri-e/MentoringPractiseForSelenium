package assignments.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment01 {

    //Create main method
    public static void main(String[] args) {

        //Create chrome driver
        WebDriver driver = new ChromeDriver();

        //Open google home page: https://www.google.com
        driver.navigate().to("https://www.google.com");

        //Get Title on page
        String title = driver.getTitle();
        System.out.println("Page Title is: " + title);

        //Get Current URL on page
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentUrl);

        //Close/Quit the browser
        driver.quit();





    }
}
