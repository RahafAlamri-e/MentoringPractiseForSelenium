package assignments.day06;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task02 extends TestBase {
//    Go to URL: http://demo.guru99.com/test/guru99home/
//    Find the number of iframes on the page
//    Switch to the third iframe (JMeter Made Easy)
//    Click the link (https://www.guru99.com/live-selenium-project.html)
//     Exit the iframe and return to the main page

    String url = "http://demo.guru99.com/test/guru99home/";

    @Test
    void test(){
        driver.get(url);
        int frameCount = driver.findElements(By.xpath("//iframe")).size();
        System.out.println("frameCount = " + frameCount);

        driver.switchTo().frame("a077aa5e");

        WebElement link = driver.findElement(By.tagName("a"));
        link.click();

        driver.switchTo().defaultContent();

    }

}
