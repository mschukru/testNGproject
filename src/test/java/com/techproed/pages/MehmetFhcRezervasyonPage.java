package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MehmetFhcRezervasyonPage {
    WebDriver driver;
    public MehmetFhcRezervasyonPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement createButton;

    @FindBy(id = "IDUser")
    public WebElement idUser;

    @FindBy(id = "IDHotelRoom")
    public WebElement idHotelRoom;

    @FindBy(id = "Price")
    public WebElement price;

    @FindBy(xpath = "//input[@data-val-number='The field Price must be a number.']")
    public WebElement priceErrorMesaj;

    @FindBy(id = "DateStart")
    public WebElement dateStart;

    @FindBy(id = "DateEnd")
    public WebElement dateEnd;


    @FindBy(id = "AdultAmount")
    public WebElement adultAmount;

    @FindBy(id = "ChildrenAmount")
    public WebElement childrenAmount;

    @FindBy(id = "ContactNameSurname")
    public WebElement surname;

    @FindBy(id = "ContactPhone")
    public WebElement phone;

    @FindBy(id = "ContactEmail")
    public WebElement email;

    @FindBy(id = "Notes")
    public WebElement notes;

    @FindBy(id = "Approved")
    public WebElement approved;

    @FindBy(id = "IsPaid")
    public WebElement isPaid;

    @FindBy(id = "btnSubmit")
    public WebElement submitButton;

    @FindBy(className = "bootbox-body")
    public WebElement success_mesaj;

    @FindBy(xpath = "//button[.='OK']")
    public WebElement okButton;

    @FindBy(xpath = "(//label[@class='error'])[1]")
    public WebElement userErrorMesaj;

    @FindBy(xpath = "(//label[@class='error'])[2]")
    public WebElement roomErrorMesaj;

    @FindBy(xpath = "(//label[@class='error'])[3]")
    public WebElement priceError2Mesaj;

    @FindBy(xpath = "(//label[@class='error'])[4]")
    public WebElement dateStartErrorMesaj;

    @FindBy(xpath = "(//label[@class='error'])[5]")
    public WebElement dateEndErrorMesaj;

    @FindBy(xpath = "(//label[@class='error'])[6]")
    public WebElement adultErrorMesaj;

    @FindBy(xpath = "(//label[@class='error'])[7]")
    public WebElement childErrorMesaj;

    @FindBy(xpath = "(//label[@class='error'])[8]")
    public WebElement surnameErrorMesaj;

    @FindBy(xpath = "(//label[@class='error'])[9]")
    public WebElement phoneErrorMesaj;

    @FindBy(xpath = "(//label[@class='error'])[10]")
    public WebElement emailErrorMesaj;

    @FindBy(xpath = "(//label[@class='error'])[11]")
    public WebElement notesErrorMesaj;



}
