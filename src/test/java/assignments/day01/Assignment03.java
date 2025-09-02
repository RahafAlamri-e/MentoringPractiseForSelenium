package assignments.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment03 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //Go to the Amazon URL : https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        //Print the position and size of the page.
        Point position = driver.manage().window().getPosition();
        System.out.println("position.getX() = " + position.getX());
        System.out.println("position.getY() = " + position.getY());
        System.out.println("position = " + position);
        System.out.println();

        Dimension size = driver.manage().window().getSize();
        System.out.println("size.getHeight() = " + size.getHeight());
        System.out.println("size.getWidth() = " + size.getWidth());
        System.out.println("size = " + size);
        System.out.println();

        //Adjust the position and size of the page as desired.
        driver.manage().window().setPosition(new Point(60, 70));
        Thread.sleep(1000);
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(500, 700));
        Thread.sleep(1000);

        //Test that the page is in the position and size you want.
        Point adjustedPosition = driver.manage().window().getPosition();
        System.out.println("adjustedPosition.getX() = " + adjustedPosition.getX());
        System.out.println("adjustedPosition.getY() = " + adjustedPosition.getY());
        System.out.println("adjustedPosition = " + adjustedPosition);
        System.out.println();

        Dimension adjustedSize = driver.manage().window().getSize();
        System.out.println("adjustedSize.getHeight() = " + adjustedSize.getHeight());
        System.out.println("adjustedSize.getWidth() = " + adjustedSize.getWidth());
        System.out.println("adjustedSize = " + adjustedSize);

        //Close the page.
        driver.quit();
    }
}
