package regressionTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicExtentReport {
    public static void main(String[] args){

        WebDriver driver;
        // start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("BasicExtentReport.html");

        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // creates a toggle for the given test, adds all log events under it
        ExtentTest test = extent.createTest("Google Search Test", "This will Google and Search a string");

        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        test.log(Status.INFO, "Starting the test case");

        driver.get("https://google.com");
        test.pass("Navigated to Google Search Page");

        driver.findElement(By.name("q")).sendKeys("Automation");
        test.pass("Enter text in Search Box");

     /*   driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
        test.fail( "Hit serach button"); */

        driver.close();
        test.pass("Close the browser");
        test.info("Test is passed");

        extent.flush();


    }
}
