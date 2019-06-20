package regressionTest;

import baseCommon.TestNGAnnotations;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import regressionModel.Login;

public class LoginTest {
//    public static WebDriver driver;
    //Login log = new Login(driver);
    String userName = "sajidmanzoor";
    String invalidUser = "sajidali";
    String password = "webdir123R";
   TestNGAnnotations chrome = new TestNGAnnotations();

     /*  @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://adactin.com/HotelApp/index.php");
    }*/

    @Test(priority = 1)
    public void validLogin() {

      /*  ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("BasicExtentReport.html");

        //    create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        ExtentTest test = TestNGAnnotations.extent.createTest("Google Search Test", "This will Google and Search a string");
        test.log(Status.INFO, "Starting the valid login test case");*/

        Login log = new Login(chrome.driver);
        log.InputCredentials(userName, password);
     //  test.pass("input valid login credentials");
        log.loginClick();
     //   test.pass("Clicked on Login button");
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Explicit wait
        // Assert.assertEquals (log.loginVerification.getAttribute("value"), "Hello SajidManzoor!");
        Assert.assertTrue(log.loginVerification.isDisplayed());
    //  test.pass("Valid Login Test is passed");
     //  extent.flush();

    }

    @Test(priority = 0)
    public void invalidLogin() {
     //   ExtentTest test = TestNGAnnotations.extent.createTest("Google Search Test", "This will Google and Search a string");
     //   test.log(Status.INFO, "Starting the valid login test case");

        chrome.setup();
        Login log = new Login(chrome.driver);
        log.InputCredentials(invalidUser, password);
     //   test.pass("input invalid login credentials");
        log.loginClick();
     //   test.pass("Clicked on Login button");
        Assert.assertEquals(log.loginError.getText(), "Invalid Login details or Your Password might have expired. Click here to reset your password");
      //  test.pass("Invalid Login Test is passed");
    }

       @Test(priority = 10, dependsOnMethods = "validLogin")
        public void Logout() {
          Login log = new Login(chrome.driver);
          log.Logout();
         //  log.clickChangePassword();
           Assert.assertEquals(log.logoutMessage.getText(),"You have successfully logged out. Click here to login again");
         chrome.tearDown();
    }

/*   @Test(priority = 100)
    public void ForgotPassword() {
       // invalidLogin();
        Login log = new Login(driver);
        log.clickForgotPassword();
        log.setRecoveryEmail();
        log.emailPassword();
        Assert.assertEquals(log.passwordRecoveryMessage.getText(),"An email has been sent to your email address containing Username and Password. Please check your email.\n" +
                "\n" +
                "Click here to login");
    }
*/
  /*  @Test (priority = 2, dependsOnMethods = "validLogin")
    public void HotelSearchTest() {
        validLogin();
        SearchHotelTest obj = new SearchHotelTest(driver);
        obj.setLocation("Sydney");
     *//*   obj.setHotel("Hotel Creek");
        obj.setroomType("Standard");
        obj.setNumberofRooms("1 - One");
        obj.setCheckInDate("16/05/2019");
        obj.setCheckOutDate("17/05/2019");
        obj.setAdultsperRoom("1 - One");
        obj.setChildperRoom("1 - One"); *//*
        obj.SearchClick();
        Assert.assertTrue(driver.getTitle().contains("Select Hotel"));
    }*/

    /*@Test
    public void SelectHotelTest(){
        SelectHotelTest obj = new SelectHotelTest(driver);
        HotelSearchTest();
        obj.columnsCount();
        obj.rowsCount();
        obj.cellClick();
        obj.continueBtnClick();
    }*/

   /* @AfterClass
    public void tearDown() {
        driver.close();
    }*/


}