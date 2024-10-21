package com.selenium1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFramesHandling {
    public static void main(String[] args) {
        // Set up WebDriver (assuming ChromeDriver is used)
       // System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        WebDriver driver = new ChromeDriver();

        // Step 1: Navigate to the URL
        driver.get("http://the-internet.herokuapp.com/nested_frames");

        // Step 2: Verify that the page title is "Frames"
        String pageTitle = driver.getTitle();
        if (pageTitle.equals("Frames")) {
            System.out.println("Verified: Page title is 'Frames'.");
        } else {
            System.out.println("Failed: Page title is not 'Frames'. Actual title: " + pageTitle);
        }

        // Step 3: Switch to the top frame
        driver.switchTo().frame("frame-top");

        // Step 4: Verify that there are three frames (left, middle, right)
        int totalFrames = driver.findElements(By.tagName("frame")).size();
        if (totalFrames == 3) {
            System.out.println("Verified: 3 frames are present.");
        }

        // Step 5: Switch to the left frame
        driver.switchTo().frame("frame-left");
        WebElement leftFrameText = driver.findElement(By.tagName("body"));
        if (leftFrameText.getText().equals("LEFT")) {
            System.out.println("Verified: Left frame text is 'LEFT'.");
        }

        // Step 6: Switch back to the top frame and then to the middle frame
        driver.switchTo().parentFrame(); // Go back to top frame
        driver.switchTo().frame("frame-middle");
        WebElement middleFrameText = driver.findElement(By.tagName("body"));
        if (middleFrameText.getText().equals("MIDDLE")) {
            System.out.println("Verified: Middle frame text is 'MIDDLE'.");
        }

        // Step 7: Switch back to the top frame and then to the right frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightFrameText = driver.findElement(By.tagName("body"));
        if (rightFrameText.getText().equals("RIGHT")) {
            System.out.println("Verified: Right frame text is 'RIGHT'.");
        }

        // Step 8: Switch back to the top frame and then to the bottom frame
        driver.switchTo().defaultContent(); // Exit to main content
        driver.switchTo().frame("frame-bottom");
        WebElement bottomFrameText = driver.findElement(By.tagName("body"));
        if (bottomFrameText.getText().equals("BOTTOM")) {
            System.out.println("Verified: Bottom frame text is 'BOTTOM'.");
        }

        // Step 9: Close the browser
        driver.quit();
    }
}
