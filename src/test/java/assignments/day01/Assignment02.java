package assignments.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment02 {

    public static void main(String[] args) {

        //Invoke FireFox Driver
        WebDriver driver = new FirefoxDriver();

        //Go to https://www.youtube.com/
        driver.navigate().to("https://www.youtube.com/");

        //Verify the page title contains the word video.
        String title = driver.getTitle();
        if (title.contains("video")) {
            System.out.println("Title contains 'video'");
        } else {
            System.out.println("Title does not contain 'video'");
        }

        //Close the driver.
        driver.quit();
    }

}
