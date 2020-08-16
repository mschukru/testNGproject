package com.techproed.tests;

import com.techproed.pages.Day18_FHCLoginPage;
import com.techproed.pages.MehmetFhcRezervasyonPage;
import com.techproed.smoketest.Day18_FHCLoginPositiveTest;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public  class MehmetFhcRezervasyonTest extends TestBase {

   MehmetFhcRezervasyonPage mehmetFhcRezervasyonPage;

   @BeforeMethod
   public void login(){
       driver.get(ConfigReader.getProperty("mehmet_fhc_reservasyon_url"));
       Day18_FHCLoginPage fhcLoginPage = new Day18_FHCLoginPage(driver);
       fhcLoginPage.login2();

       mehmetFhcRezervasyonPage = new MehmetFhcRezervasyonPage(driver);
       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       mehmetFhcRezervasyonPage.createButton.click();
   }
    @Test(priority = 1)
    public void fhcSelectUserAndRoom() throws InterruptedException {
       mehmetFhcRezervasyonPage = new MehmetFhcRezervasyonPage(driver);

        Select idUserSelect = new Select(mehmetFhcRezervasyonPage.idUser);
        idUserSelect.selectByIndex(1);

        Select idHotelRoomSelect = new Select(mehmetFhcRezervasyonPage.idHotelRoom);
        idHotelRoomSelect.selectByIndex(1);

        String mesaj = idUserSelect.getFirstSelectedOption().getText();
        Assert.assertTrue(mesaj.equals("manager2"));

        String mesaj2=idHotelRoomSelect.getFirstSelectedOption().getText();
        Assert.assertTrue(mesaj2.equals("fazli"));

    }

    @Test(priority = 2)
    public void fhcPrice() {
        mehmetFhcRezervasyonPage = new MehmetFhcRezervasyonPage(driver);
        mehmetFhcRezervasyonPage.price.sendKeys("uc yuz");
        String priceErrorMesaj = mehmetFhcRezervasyonPage.priceErrorMesaj.getText();
        Assert.assertTrue(priceErrorMesaj.equals("The field Price must be a number."));
    }
    @Test(priority = 3)
    public void fhcgecmisDate() {
        mehmetFhcRezervasyonPage = new MehmetFhcRezervasyonPage(driver);
        mehmetFhcRezervasyonPage.dateStart.sendKeys("20/12/2019");

        mehmetFhcRezervasyonPage.dateEnd.sendKeys("27/12/2019");
    }
    @Test(priority = 4)
    public void fhcgecersizDate() {
        mehmetFhcRezervasyonPage = new MehmetFhcRezervasyonPage(driver);
        mehmetFhcRezervasyonPage.dateStart.sendKeys("20/12/2020");

        mehmetFhcRezervasyonPage.dateEnd.sendKeys("12/12/2020");
        String dateErrorMesaj = mehmetFhcRezervasyonPage.dateErrorMessaj.getText();
        Assert.assertTrue(dateErrorMesaj.equals("Check-out date cannot be earlier than the check-in date."));
    }
    @Test(priority = 5)
    public void adultChildAmount() {
        mehmetFhcRezervasyonPage = new MehmetFhcRezervasyonPage(driver);
        mehmetFhcRezervasyonPage.adultAmount.sendKeys("two");

        mehmetFhcRezervasyonPage.childrenAmount.sendKeys("one");
        String adultErrorMesaj = mehmetFhcRezervasyonPage.adultErrorMesaj.getText();
        Assert.assertTrue(adultErrorMesaj.equals("The field AdultAmount must be a number."));

        String childErrorMesaj = mehmetFhcRezervasyonPage.childErrorMesaj.getText();
        Assert.assertTrue(childErrorMesaj.equals("The field ChildrenAmount must be a number."));

    }
    @Test(priority = 6)
    public void surname() {
        mehmetFhcRezervasyonPage = new MehmetFhcRezervasyonPage(driver);
        mehmetFhcRezervasyonPage.surname.sendKeys("345 23");

        String surnameErrorMesaj = mehmetFhcRezervasyonPage.surnameErrorMesaj.getText();
        Assert.assertTrue(surnameErrorMesaj.equals("The field ChildrenAmount must be a text."));
    }
    @Test(priority = 7)
    public void phone() {
        mehmetFhcRezervasyonPage.phone.sendKeys("zero one two");
        boolean phoneError = mehmetFhcRezervasyonPage.phone.isDisplayed();
        Assert.assertTrue(phoneError);
    }
    @Test(priority = 8)
    public void email() {
        mehmetFhcRezervasyonPage.email.sendKeys("abc.abc.com");
        String errorMesaj = mehmetFhcRezervasyonPage.errorMesaj.getText();
        Assert.assertTrue(errorMesaj.equals("Please provide correct email address"));
    }

    @Test(priority = 9)
    public void submitButton () {
        mehmetFhcRezervasyonPage.submitButton.click();
        String mesaj = mehmetFhcRezervasyonPage.success_mesaj.getText();
        Assert.assertFalse(mesaj.equals("RoomReservation was inserted successfully"));
    }


}
