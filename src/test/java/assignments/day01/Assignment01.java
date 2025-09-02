package assignments.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment01 {

    public static void main(String[] args) throws InterruptedException {

        //Open URL: https://www.google.com/
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");

        //Maximize the window.
        driver.manage().window().maximize();
        Thread.sleep(1000);

        //Print the position and size of the page.
        Point position01 = driver.manage().window().getPosition();
        System.out.println("position.getX() = " + position01.getX());
        System.out.println("position.getY() = " + position01.getY());
        System.out.println("position = " + position01);

        //Minimize the page.
        driver.manage().window().minimize();

        //Wait 5 seconds in the icon state and maximize the page.
        Thread.sleep(5000);
        driver.manage().window().maximize();

        //Print the position and dimensions of the page in maximized state.
        Dimension dimensions = driver.manage().window().getSize();
        System.out.println("After Maximizing dimension.getHeight() = " + dimensions.getHeight());
        System.out.println("After Maximizing dimension.getWidth() = " + dimensions.getWidth());
        System.out.println("After Maximizing dimension = " + dimensions);


        Point position02 = driver.manage().window().getPosition();
        System.out.println("After Maximizing position.getX() = " + position01.getX());
        System.out.println("After Maximizing position.getY() = " + position01.getY());
        System.out.println("After Maximizing position = " + position01);

        //Make the page fullscreen.
        driver.manage().window().fullscreen();
        Thread.sleep(1000);

        //Close the Browser.
        driver.quit();

    }
}
