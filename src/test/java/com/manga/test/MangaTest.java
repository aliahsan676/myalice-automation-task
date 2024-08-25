package com.manga.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class MangaTest {
    public static void main(String[] args) {

        // Load properties file from resources directory
        Properties props = new Properties();
        try (
                InputStream input = MangaTest.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            // Load the properties from the file
            props.load(input);
        } catch (
                IOException ex) {
            ex.printStackTrace();
        }

        // Retrieve the values
        String url = props.getProperty("WEBSITE_URL");
        String username = props.getProperty("USERNAME");
        String password = props.getProperty("PASSWORD");

        // Set up the FirefoxDriver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        try {

            //1. Login Functionality

            // Open the application
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

            // Verify that the login page is displayed
            WebElement loginForm = driver.findElement(By.xpath("/html/body/div/div/div/h2"));
            if (loginForm.isDisplayed()) {
                System.out.println("Login form is displayed.");
            } else {
                System.out.println("Login form is NOT displayed.");
            }

            // Enter valid login credentials
            WebElement webElement1 = driver.findElement(By.cssSelector("#username"));
            webElement1.clear();
            webElement1.sendKeys(username);

            WebElement webElement2 = driver.findElement(By.cssSelector("#password"));
            webElement2.clear();
            webElement2.sendKeys(password);

            //Click the "Login" button
            driver.findElement(By.cssSelector("#login-btn")).click();

            // Verify that the user is redirected to the manga search page
            WebElement mangaSearchPage = driver.findElement(By.xpath("/html/body/div/div/div[1]/button"));
            if (mangaSearchPage.isDisplayed()) {
                System.out.println("User is redirected to the manga search page.");
            } else {
                System.out.println("User is NOT redirected to the manga search page.");
            }




        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            driver.quit();
        }


    }
}
