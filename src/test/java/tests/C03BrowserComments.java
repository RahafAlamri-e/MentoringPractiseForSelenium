package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03BrowserComments {

    public static void main(String[] args) throws InterruptedException {

        // TC – 03

        // Expected Title
        String expectedTitle = "LinkedIn: Log In or Sign Up";
        System.out.println("Expected Title:" + expectedTitle);

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open URL of Website
        driver.get("https://www.LinkedIn.com");

        // Maximize Window
        driver.manage().window().maximize();

        // Get Title of current Page
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title:" + actualTitle);

        // Validate/Compare Page Title
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title it as Expected");
        } else {
            System.out.println("Title it Not as Expected");
            System.out.println("Actual Title: " + actualTitle);
            System.out.println("Expected Title: " + expectedTitle);
        }
        // Close Browser
        driver.quit();

    }
}
