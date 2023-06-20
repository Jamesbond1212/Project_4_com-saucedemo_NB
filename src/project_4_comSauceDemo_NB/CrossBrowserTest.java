package project_4_comSauceDemo_NB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
/**
 * 1. Setup Chrome browser
 * 2. Open URL "https://www.saucedemo.com/"
 * 3. Print the title of the page
 * 4. Print the current url
 * 5. Print the page source
 * 6. Enter the email to email field
 * 7. Enter the password to password field
 * 8. Close the browser
 */
public class CrossBrowserTest {
    static String browser = "Firefox";
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;
        // set up Cross browser
    public static void main(String[] args) throws InterruptedException {
        if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }
        //2. Open URL
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // 3. Print the title of the page
        String title =  driver.getTitle();
        System.out.println("Title of the page " + title);
        //  4. Print the current url
        System.out.println("Current Url : " + driver.getCurrentUrl());
        //  5. Print the page source
        System.out.println("Page source : " + driver.getPageSource());
        // 6. Enter the email to email field
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("jamesbond1212@gmail.com");
        // 7. Enter the password to password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Bond007%");
        Thread.sleep(10000);
        // close the browser
        driver.close();
    }
}
