package assignments.day01;


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
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());
        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());


//
//        Dimension dimensions01 = driver.manage().window().getSize();
//        System.out.println("dimension.getHeight() = " + dimensions01.getHeight());
//        System.out.println("dimension.getWidth() = " + dimensions01.getWidth());
//        System.out.println("dimension = " + dimensions01);
//        System.out.println();
//
//        Point position01 = driver.manage().window().getPosition();
//        System.out.println("position.getX() = " + position01.getX());
//        System.out.println("position.getY() = " + position01.getY());
//        System.out.println("position = " + position01);
//        System.out.println();

        //Minimize the page.
        driver.manage().window().minimize();

        //Wait 5 seconds in the icon state and maximize the page.
        Thread.sleep(5000);
        driver.manage().window().maximize();

        //Print the position and dimensions of the page in maximized state.
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());
        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());
//
//        Dimension dimensions02 = driver.manage().window().getSize();
//        System.out.println("After Maximizing dimension.getHeight() = " + dimensions02.getHeight());
//        System.out.println("After Maximizing dimension.getWidth() = " + dimensions02.getWidth());
//        System.out.println("After Maximizing dimension = " + dimensions02);
//        System.out.println();
//
//
//        Point position02 = driver.manage().window().getPosition();
//        System.out.println("After Maximizing position.getX() = " + position02.getX());
//        System.out.println("After Maximizing position.getY() = " + position02.getY());
//        System.out.println("After Maximizing position = " + position02);

        //Make the page fullscreen.
        driver.manage().window().fullscreen();
        Thread.sleep(1000);

        //Close the Browser.
        driver.quit();

    }
}
