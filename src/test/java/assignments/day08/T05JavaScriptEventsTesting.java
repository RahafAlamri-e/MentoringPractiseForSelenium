package assignments.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T05JavaScriptEventsTesting extends TestBase {

    /*
    Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    Click all the buttons and verify they are all clicked
    */

    String url = "https://testpages.herokuapp.com/styled/events/javascript-events.html";

    By onBlurBtn = By.id("onblur");
    By onClickBtn = By.id("onclick");
    By onContextMenuBtn = By.id("oncontextmenu");
    By onDoubleClickBtn = By.id("ondoubleclick");
    By onFocusBtn = By.id("onfocus");
    By onKeyDownBtn = By.id("onkeydown");
    By onKeyUpBtn = By.id("onkeyup");
    By onKeyPressBtn = By.id("onkeypress");
    By onMouseOverBtn = By.id("onmouseover");
    By onMouseLeaveBtn = By.id("onmouseleave");
    By onMouseDownBtn = By.id("onmousedown");


    @Test
    void testJavaScriptEventsWithJSExecutor() {
        driver.get(url);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // onBlur
        WebElement blurBtn = driver.findElement(onBlurBtn);
        js.executeScript("arguments[0].focus(); arguments[0].blur();", blurBtn);
        Assertions.assertEquals("Event Triggered", driver.findElement(By.id("onblurstatus")).getText());

        // onClick
        WebElement clickBtn = driver.findElement(onClickBtn);
        js.executeScript("arguments[0].click();", clickBtn);
        Assertions.assertEquals("Event Triggered", driver.findElement(By.id("onclickstatus")).getText());

        // onContextMenu
        WebElement contextBtn = driver.findElement(onContextMenuBtn);
        js.executeScript("var evt = new MouseEvent('contextmenu', {bubbles:true}); arguments[0].dispatchEvent(evt);", contextBtn);
        Assertions.assertEquals("Event Triggered", driver.findElement(By.id("oncontextmenustatus")).getText());

        // onDoubleClick
        WebElement dblClickBtn = driver.findElement(onDoubleClickBtn);
        js.executeScript("var evt = new MouseEvent('dblclick', {bubbles:true}); arguments[0].dispatchEvent(evt);", dblClickBtn);
        Assertions.assertEquals("Event Triggered", driver.findElement(By.id("ondoubleclickstatus")).getText());

        // onFocus
        WebElement focusBtn = driver.findElement(onFocusBtn);
        js.executeScript("arguments[0].focus();", focusBtn);
        Assertions.assertEquals("Event Triggered", driver.findElement(By.id("onfocusstatus")).getText());

        // onKeyDown
        WebElement keyDownBtn = driver.findElement(onKeyDownBtn);
        js.executeScript("var evt = new KeyboardEvent('keydown', {key:'a'}); arguments[0].dispatchEvent(evt);", keyDownBtn);
        Assertions.assertEquals("Event Triggered", driver.findElement(By.id("onkeydownstatus")).getText());

        // onKeyUp
        WebElement keyUpBtn = driver.findElement(onKeyUpBtn);
        js.executeScript("var evt = new KeyboardEvent('keyup', {key:'a'}); arguments[0].dispatchEvent(evt);", keyUpBtn);
        Assertions.assertEquals("Event Triggered", driver.findElement(By.id("onkeyupstatus")).getText());

        // onKeyPress
        WebElement keyPressBtn = driver.findElement(onKeyPressBtn);
        js.executeScript("var evt = new KeyboardEvent('keypress', {key:'a'}); arguments[0].dispatchEvent(evt);", keyPressBtn);
        Assertions.assertEquals("Event Triggered", driver.findElement(By.id("onkeypressstatus")).getText());

        // onMouseOver
        WebElement mouseOverBtn = driver.findElement(onMouseOverBtn);
        js.executeScript("var evt = new MouseEvent('mouseover', {bubbles:true}); arguments[0].dispatchEvent(evt);", mouseOverBtn);
        Assertions.assertEquals("Event Triggered", driver.findElement(By.id("onmouseoverstatus")).getText());

        // onMouseLeave
        WebElement mouseLeaveBtn = driver.findElement(onMouseLeaveBtn);
        js.executeScript("var evt = new MouseEvent('mouseleave', {bubbles:true}); arguments[0].dispatchEvent(evt);", mouseLeaveBtn);
        Assertions.assertEquals("Event Triggered", driver.findElement(By.id("onmouseleavestatus")).getText());

        // onMouseDown
        WebElement mouseDownBtn = driver.findElement(onMouseDownBtn);
        js.executeScript("var evt = new MouseEvent('mousedown', {bubbles:true}); arguments[0].dispatchEvent(evt);", mouseDownBtn);
        Assertions.assertEquals("Event Triggered", driver.findElement(By.id("onmousedownstatus")).getText());

    }
}

