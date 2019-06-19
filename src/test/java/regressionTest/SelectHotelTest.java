package regressionTest;

import baseCommon.TestNGAnnotations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import regressionModel.SelectHotel;

public class SelectHotelTest {
    LoginTest log = new LoginTest();
    TestNGAnnotations chrome = new TestNGAnnotations();

    // public static WebDriver driver;
   /*@BeforeMethod
   public void setup() {
       System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium Drivers\\chromedriver.exe");
       log.driver = new ChromeDriver();
       log.driver.manage().window().maximize();
       log.driver.get("http://adactin.com/HotelApp/index.php");
   }*/

    @Test
    public void SelectHotelTest() {
      //  chrome.setup();
        SearchHotelTest obj1 = new SearchHotelTest();
        obj1.HotelSearchTest();

        SelectHotel obj = new SelectHotel(chrome.driver);
        obj.columnsCount();
        obj.rowsCount();
        obj.cellClick();
        obj.continueBtnClick();
        chrome.tearDown();
    }

 /*   @AfterMethod
    public void tearDown() {
        log.driver.close();
    }
*/
}