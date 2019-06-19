package regressionTest;

import baseCommon.TestNGAnnotations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import regressionModel.SearchHotel;

public class SearchHotelTest {

    //   public static WebDriver driver;
    //LoginTest login = new LoginTest();
    TestNGAnnotations chrome = new TestNGAnnotations();

   /* @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium Drivers\\chromedriver.exe");
        chrome.driver = new ChromeDriver();
        chrome.driver.manage().window().maximize();
        login.driver.get("http://adactin.com/HotelApp/index.php");
    }*/

    @Test
    public void HotelSearchTest() {
        chrome.setup();
        LoginTest login = new LoginTest();
        login.validLogin();
        // regressionModel.SearchHotel obj = new regressionModel.SearchHotel(login.driver);
        SearchHotel obj = new SearchHotel(chrome.driver);
        obj.setLocation("Sydney");
     /*   obj.setHotel("Hotel Creek");
        obj.setroomType("Standard");
        obj.setNumberofRooms("1 - One");
        obj.setCheckInDate("16/05/2019");
        obj.setCheckOutDate("17/05/2019");
        obj.setAdultsperRoom("1 - One");
        obj.setChildperRoom("1 - One"); */
        obj.SearchClick();
//        Assert.assertTrue(driver.getTitle().contains("Select Hotel"));
     //   chrome.tearDown();
    }

    @AfterMethod
    public void tearDown() {
        chrome.driver.close();
    }

}