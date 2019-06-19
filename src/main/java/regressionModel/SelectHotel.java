package regressionModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//import stepDef.Hooks;

import java.util.List;

public class SelectHotel {
    public SelectHotel(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void tableData() {
       // Hooks hook = new Hooks();
         WebDriver driver = new ChromeDriver();


       /* List<WebElement> col = driver.findElements(By.xpath("//table[@class='login']/tbody/tr[2]/td/table/tbody/tr[1]/td"));
        System.out.println("No of columns are: " + col.size());

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='login']/tbody/tr[2]/td/table/tbody/tr/td[2]"));
        System.out.println("No of rows are :" +rows.size()); */


      /*  try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        WebElement baseTable = driver.findElement(By.className("login"));
        WebElement tableRow = baseTable.findElement(By.xpath("//table[@class='login']/tbody/tr[2]/td/table/tbody/tr[2]"));
        WebElement CellNeeded = tableRow.findElement(By.xpath("//table[@class='login']/tbody/tr[2]/td/table/tbody/tr[3]/td[1]/input[1]"));

        System.out.println(CellNeeded.isEnabled());
        System.out.println(CellNeeded.isDisplayed());

//        WebElement CellNeeded = hook.driver.findElement(By.xpath(" /html[1]/body[1]/table[2]/tbody[1]/tr[2]/td[1]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/input[1]"));

        CellNeeded.click();

    }
    @FindBys(@FindBy(xpath="//table[@class='login']/tbody/tr[2]/td/table/tbody/tr[1]/td"))
    List<WebElement> col;

    @FindBys(@FindBy(xpath = "//table[@class='login']/tbody/tr[2]/td/table/tbody/tr/td[2]"))
    public List<WebElement> rows;

    @FindBy(className = "login")
    public WebElement baseTable;

    @FindBy(xpath = "//table[@class='login']/tbody/tr[2]/td/table/tbody/tr[2]")
    public WebElement tableRow;

    @FindBy(xpath = "//table[@class='login']/tbody/tr[2]/td/table/tbody/tr[2]/td[1]/input[1]")
    public WebElement cellNeeded;

    @FindBy (id = "continue")
    public WebElement continueBtn;

    @FindBy (id = "cancel")
    public WebElement cancelBtn;

    public void continueBtnClick(){
        continueBtn.click();
    }
    public void cancelBtnClick(){
        cancelBtn.click();
    }

    public void columnsCount(){
        System.out.println(col.size());

    }

    public void rowsCount(){
        System.out.println(rows.size()-1);

    }

    public void cellClick(){
        cellNeeded.click();
    }

}