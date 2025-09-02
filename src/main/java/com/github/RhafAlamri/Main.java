package com.github.RhafAlamri;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.navigate().to("http://www.github.com");
        driver.navigate().back();

//        WebDriver driver1 = new SafariDriver();
//        driver1.get("https://www.google.com");


        }
    }
