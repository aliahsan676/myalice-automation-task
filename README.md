# Myalice Automation Test (Manga App) - Selenium and Java

This repository contains automated test scripts written in Java using Selenium WebDriver for the automation of a specific flow in Manga (Comics or graphic novels originating from Japan) website.

# Test Flow

The following steps describe the flow that is automated by the test scripts:

# Login Functionality
Scenario: Verify that the login functionality works correctly.
Steps:
1. Open the application.
2. Verify that the login page is displayed.
3. Enter valid login credentials (e.g., testuser and password).
4. Click the "Login" button.
5. Verify that the user is redirected to the manga search page.

# Manga Search and Display
Scenario: Verify that searching for manga returns the correct results.
Steps:
1. Ensure the user is on the manga search page.
2. Enter the search term "Naruto" into the search box.
3. Click the "Search" button.
4. Verify that manga cards with the name "Naruto" are displayed.
5. Enter the search term "One Piece" into the search box.
6. Click the "Search" button.
7. Verify that manga cards with the name "One Piece" are displayed.
8. Enter the search term "Seven Deadly Sins" into the search box.
9. Click the "Search" button.
10. Verify that manga cards with the name "Seven Deadly Sins" are
displayed.
11. Enter a search term that returns no results (e.g., "No manga found").
12. Click the "Search" button.
13. Verify that a "No manga found" message is displayed.

# Manga Details Modal
Scenario: Verify that the modal displays the correct manga details.
Steps:
1. Ensure the user is on the manga search page.
2. Click the "Details" link on a manga card.
3. Verify that the modal appears and displays the correct manga
information (image, name, summary).
4. Click the "Close" button on the modal.
5. Verify that the modal is closed and no longer visible.

# Prerequisites

To run the automated tests locally, ensure that you have the following:

1. Java Development Kit (JDK) installed on your machine.
2. IntelliJ IDEA (IDE) installed on your machine. 
3. Selenium WebDriver dependencies set up in your project.
4. Firefox web browser installed

# How to Run the Tests

To execute the automation test scripts, follow these steps:

1. Clone or download this repository to your local machine.
2. Open the project in IntelliJ IDEA (IDE).
3. Set up the necessary dependencies and configurations for Selenium WebDriver.
4. Locate the test script for the desired test flow and run it in your IDE.


# Contributors
Ali Ahsan
