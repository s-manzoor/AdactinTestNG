package baseCommon;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestNGAnnotations {

    public static WebDriver driver;
    ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;

 /*   @BeforeSuite
    public void beforeSuite(){
      htmlReporter = new ExtentHtmlReporter("BasicExtentReport.html");

    //    create ExtentReports and attach reporter(s)
       extent = new ExtentReports();
       extent.attachReporter(htmlReporter);
    }*/

    @BeforeClass
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://adactin.com/HotelApp/index.php");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
       // extent.flush();
    }

   /* @AfterSuite
    public void afterSuite(){
        extent.flush();
    }*/


}
