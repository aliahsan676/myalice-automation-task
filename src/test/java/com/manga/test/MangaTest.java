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

            // 2. Manga Search and Display

           //Ensure the user is on the manga search page.

            WebElement userOnMangaSearchPage = driver.findElement(By.xpath("/html/body/div/div/div[1]/button"));
            if (userOnMangaSearchPage.isDisplayed()) {
                System.out.println("User is on the manga search page.");
            } else {
                System.out.println("User is NOT on the manga search page.");
            }

            //Enter the search term "Naruto" into the search box.
            WebElement webElement3 = driver.findElement(By.cssSelector("#manga-search"));
            webElement3.clear();
            webElement3.sendKeys("Naruto");

            //Click the "Search" button
            driver.findElement(By.xpath("/html/body/div/div/div[1]/button")).click();

            //Verify that manga cards with the name "Naruto" are displayed
            WebElement narutoDisplayed = driver.findElement(By.xpath("//*[@id=\"manga-name\"]"));
            if (narutoDisplayed.isDisplayed()) {
                System.out.println("Naruto is displayed.");
            } else {
                System.out.println("Naruto is NOT displayed.");
            }

            // Enter the search term "One Piece" into the search box
            WebElement webElement4 = driver.findElement(By.cssSelector("#manga-search"));
            webElement4.clear();
            webElement4.sendKeys("One Piece");

            //Click the "Search" button
            driver.findElement(By.xpath("/html/body/div/div/div[1]/button")).click();

            //Verify that manga cards with the name "One Piece" are displayed
            WebElement onePieceDisplayed = driver.findElement(By.xpath("//*[@id=\"manga-name\"]"));
            if (onePieceDisplayed.isDisplayed()) {
                System.out.println("One Piece is displayed.");
            } else {
                System.out.println("One Piece is NOT displayed.");
            }

            //Enter the search term "Seven Deadly Sins" into the search box
            WebElement webElement5 = driver.findElement(By.cssSelector("#manga-search"));
            webElement5.clear();
            webElement5.sendKeys("Seven Deadly Sins");

            //Click the "Search" button
            driver.findElement(By.xpath("/html/body/div/div/div[1]/button")).click();

            //Verify that a "No manga found" message is displayed.
            WebElement noManga = driver.findElement(By.cssSelector(".text-red-500"));
            if (noManga.isDisplayed()) {
                System.out.println("No manga found is displayed.");
            } else {
                System.out.println("No manga found is displayed.");
            }

            // 3. Manga Details Modal

            // Ensure the user is on the manga search page.

            WebElement userAgainOnMangaSearchPage = driver.findElement(By.xpath("/html/body/div/div/div[1]/button"));
            if (userAgainOnMangaSearchPage.isDisplayed()) {
                System.out.println("User is on the manga search page.");
            } else {
                System.out.println("User is NOT on the manga search page.");
            }

            // Click the "Details" link on a manga card

            driver.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/p[1]/span")).click();

            // Verify that the modal appears and displays the correct manga information (image, name, summary)

            WebElement correctImage = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/img"));
            if (correctImage.isDisplayed()) {
                System.out.println("Image is correct.");
            } else {
                System.out.println("Image is NOT correct.");
            }

            WebElement correctName = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/h3"));
            if (correctName.isDisplayed()) {
                System.out.println("Name is correct.");
            } else {
                System.out.println("Name is NOT correct.");
            }

            WebElement correctSummary = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/p"));
            if (correctSummary.isDisplayed()) {
                System.out.println("Summary is correct.");
            } else {
                System.out.println("Summary is NOT correct.");
            }

            // Click the "Close" button on the modal
            driver.findElement(By.xpath("/html/body/div/div/div[3]/div/button")).click();

            // Verify that the modal is closed and no longer visible

            WebElement lookForCloseButton = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/button"));
            if (lookForCloseButton.isDisplayed()) {
                System.out.println("Modal is NOT closed and STILL visible.");
            } else {
                System.out.println("Modal is closed and not visible.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            driver.quit();
        }


    }
}
