package regressionModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchHotel {
    public SearchHotel(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "location")
    public WebElement hotelLocation;

    @FindBy (id = "hotels")
    private WebElement hotelsList;

    @FindBy (id = "room_type")
    private WebElement roomType;

    @FindBy (id = "room_nos")
    private WebElement NumberofRooms;

    @FindBy (id = "datepick_in")
    private WebElement CheckInDate;

    @FindBy (id = "datepick_out") // className = "date_pick" it will give error
    private WebElement CheckOutDate;

    @FindBy (name = "adult_room") // name locator
    private WebElement AdultsperRoom;

    @FindBy (id = "child_room")
    private WebElement ChildperRoom;

    @FindBy (id = "Submit")
    private WebElement submitBtn;

    @FindBy (id = "Reset")
    private WebElement resetBtn;

    public void setLocation(String location){  // Setter
        Select loc = new Select (hotelLocation);
        // loc.selectByValue(location);
        loc.selectByVisibleText(location);// take from test method
    }

    public void setHotel(String hotel){
        Select hotelName = new Select (hotelsList);
        hotelName.selectByValue(hotel);
    }

    public void setroomType(String typeRoom) {
        Select room = new Select (roomType);
        room.selectByVisibleText(typeRoom);
    }

    public void setNumberofRooms(String NoofRooms){
        Select rooms = new Select (NumberofRooms);
        rooms.selectByVisibleText(NoofRooms);
    }

    public void setCheckInDate(String checkIndate){
        CheckInDate.clear();
        CheckInDate.sendKeys(checkIndate);
    }

    public void setCheckOutDate(String checkOutdate){
        CheckOutDate.clear();
        CheckOutDate.sendKeys(checkOutdate);
    }

    public void setAdultsperRoom (String Adults) {
        Select adults = new Select (AdultsperRoom);
        adults.selectByVisibleText(Adults);
    }

    public void setChildperRoom (String children){
        Select child = new Select (ChildperRoom);
        child.selectByVisibleText(children);
    }

    public void SearchClick(){
        submitBtn.click();
    }

    public void getLocation(){  // Getter
        setLocation("Sydney");
    }

    public void SearchHotelMethod(){
        setLocation("Sydney");
        // setHotel("Hotel Creek");
        //  setroomType("Standard");
        setNumberofRooms("1 - One");
        setCheckInDate("16/05/2019");
        setCheckOutDate("17/05/2019");
        setAdultsperRoom("1 - One");
        // setChildperRoom("1 - One");
    }
    public void print (){
        System.out.println("This is a print message from Search Hotel screen");
    }
}
