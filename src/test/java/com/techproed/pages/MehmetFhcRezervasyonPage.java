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

    @FindBy(xpath = "//input[@data-val-date='The field DateEnd must be a date.']")
    public WebElement dateErrorMessaj;

    @FindBy(id = "AdultAmount")
    public WebElement adultAmount;

    @FindBy(xpath = "//input[@data-val-number='The field AdultAmount must be a number.']")
    public WebElement adultErrorMesaj;

    @FindBy(id = "ChildrenAmount")
    public WebElement childrenAmount;

    @FindBy(xpath = "//input[@data-val-number='The field ChildrenAmount must be a number.']")
    public WebElement childErrorMesaj;

    @FindBy(id = "ContactNameSurname")
    public WebElement surname;

    @FindBy(id = "ContactNameSurname")
    public WebElement surnameErrorMesaj;

    @FindBy(id = "ContactPhone")
    public WebElement phone;

    @FindBy(id = "ContactEmail")
    public WebElement email;

    @FindBy(xpath = "//Input[@title='Please provide correct email address']")
    public WebElement errorMesaj;

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
}
