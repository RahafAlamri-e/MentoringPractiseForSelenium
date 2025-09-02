package assignments.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment04 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //Open URL: https://www.google.com/
        driver.navigate().to("https://www.google.com/");

        //Maximize the window.
        driver.manage().window().maximize();
        Thread.sleep(1000);

        //Print the position and size of the page.

        Point position01 = driver.manage().window().getPosition();
        System.out.println("position01.getX() = " + position01.getX());
        System.out.println("position01.getY() = " + position01.getY());
        System.out.println("position01 = " + position01);
        System.out.println();

        Dimension dimensions01 = driver.manage().window().getSize();
        System.out.println("dimension01.getHeight() = " + dimensions01.getHeight());
        System.out.println("dimension01.getWidth() = " + dimensions01.getWidth());
        System.out.println("dimension01 = " + dimensions01);
        System.out.println();

        //Minimize the page.
        driver.manage().window().minimize();


        //Wait 5 seconds in the icon state and maximize the page.
        Thread.sleep(5000);
        driver.manage().window().maximize();

        //Print the position and dimensions of the page in maximized state.

        Dimension dimensions02 = driver.manage().window().getSize();
        System.out.println("After Maximizing dimension02.getHeight() = " + dimensions02.getHeight());
        System.out.println("After Maximizing dimension02.getWidth() = " + dimensions02.getWidth());
        System.out.println("After Maximizing dimension02 = " + dimensions02);
        System.out.println();

        Point position02 = driver.manage().window().getPosition();
        System.out.println("After Maximizing position02.getX() = " + position02.getX());
        System.out.println("After Maximizing position02.getY() = " + position02.getY());
        System.out.println("After Maximizing position02 = " + position02);

        //Make the page fullscreen.
        driver.manage().window().fullscreen();
        Thread.sleep(1000);

        //Close the Browser.
        driver.quit();

    }
}
