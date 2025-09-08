package tests.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04GetAndAdjustScreenSize {

    public static void main(String[] args) {

        // TC - 04
        WebDriver driver = new ChromeDriver();

        // Go to the w3school URL : https://www.w3schools.com/
        driver.navigate().to("https://www.w3schools.com/");

        // Print the position and size of the page.
        Point position = driver.manage().window().getPosition();
        System.out.println("position.getX() = " + position.getX());
        System.out.println("position.getY() = " + position.getY());
        System.out.println("position = " + position);

        // Adjust the position and size of the page as desired.
        Dimension dimensions = driver.manage().window().getSize();
        System.out.println("dimension.getHeight() = " + dimensions.getHeight());
        System.out.println("dimension.getWidth() = " + dimensions.getWidth());
        System.out.println("dimension = " + dimensions);


        // Test that the page is in the position and size you want.
        System.out.println("After Adjust Position: " + driver.manage().window().getPosition());
        System.out.println("After Adjust Size: " + driver.manage().window().getSize());

        // Close the page.
        driver.quit();
    }
}
