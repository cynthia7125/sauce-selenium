package com.sauceDemo.app;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void sauceLogin() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();
        WebElement navigator = driver.findElement(By.xpath("//*[@aria-hidden='false']"));
        assertEquals(true, navigator.isDisplayed());
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
        assertEquals(true, logout.isDisplayed());
        driver.findElement(By.id("logout_sidebar_link")).click();

        driver.findElement(By.id("user-name")).sendKeys("standard_user1");
        driver.findElement(By.id("password")).sendKeys("secret_sauce1");
        driver.findElement(By.id("login-button")).click();
        String wrongPassWarning = "Epic sadface: Username and password do not match any user in this service";

        assertTrue(driver.findElement(By.tagName("h3")).getText().contains(wrongPassWarning));
        driver.navigate().refresh();
    
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.tagName("h3")).getText();
        String noLoginWarning = "Epic sadface: Username is required";

        assertTrue(driver.findElement(By.tagName("h3")).getText().contains(noLoginWarning));
        driver.navigate().refresh();

        driver.findElement(By.id("user-name")).sendKeys("standard_user1");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        String noPassWarning = "Epic sadface: Password is required";

        assertTrue(driver.findElement(By.tagName("h3")).getText().contains(noPassWarning));
        driver.navigate().refresh();

        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("standard_user1");
        driver.findElement(By.id("login-button")).click();
        String noUserWarning = "Epic sadface: Username is required";

        assertTrue(driver.findElement(By.tagName("h3")).getText().contains(noUserWarning));
    }
    
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
