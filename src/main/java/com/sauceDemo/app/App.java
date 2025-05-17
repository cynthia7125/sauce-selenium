package com.sauceDemo.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class App {
    public static void main(String[] args) {
        WebDriver driver = new SafariDriver();
        driver.get("https://www.saucedemo.com/");
    }
}
