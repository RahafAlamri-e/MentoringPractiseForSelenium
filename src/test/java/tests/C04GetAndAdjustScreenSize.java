package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04GetAndAdjustScreenSize {

    public static void main(String[] args) {

        // TC - 04
        WebDriver driver = new ChromeDriver();

        // Go to the w3school URL : https://www.w3schools.com/
        driver.navigate().to("https://www.w3schools.com/");

        // Print the position and size of the page.
        System.out.println("Position: " + driver.manage().window().getPosition());
        System.out.println("Size: " + driver.manage().window().getSize());

        // Adjust the position and size of the page as desired.
        driver.manage().window().setPosition(new org.openqa.selenium.Point(100, 100));
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1024, 768));

        // Test that the page is in the position and size you want.
        System.out.println("After Adjust Position: " + driver.manage().window().getPosition());
        System.out.println("After Adjust Size: " + driver.manage().window().getSize());

        // Close the page.
        driver.quit();
    }
}
