package com.selenium1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class WindowHandling {
    public static void main(String[] args) {
        // Set up WebDriver (assuming ChromeDriver is used)
        //System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        WebDriver driver = new ChromeDriver();

        // Step 1: Navigate to the URL
        driver.get("https://the-internet.herokuapp.com/windows");

        // Step 2: Click the "Click Here" button
        WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
        clickHereButton.click();

        // Step 3: Switch to the newly opened window
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Step 4: Verify that the text "New Window" is present
        WebElement newText = driver.findElement(By.tagName("h3"));
        if (newText.getText().equals("New Window")) {
            System.out.println("Verified: New Window text is present.");
        }

        // Step 5: Close the new window
        driver.close();

        // Step 6: Switch back to the original window
        driver.switchTo().window(originalWindow);

        // Step 7: Verify that the original window is active
        if (driver.getTitle().equals("The Internet")) {
            System.out.println("Original window is active.");
        }

        // Step 8: Close the browser
        driver.quit();
    }
}
