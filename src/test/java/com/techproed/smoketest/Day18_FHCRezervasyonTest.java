package com.techproed.smoketest;

import com.techproed.pages.Day18_FHCLoginPage;
import com.techproed.pages.Day18_FHCRezervasyonPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day18_FHCRezervasyonTest extends TestBase {
    @Test
    public void fhcrezervasyonTest() throws InterruptedException {
        driver.get("http://fhctrip-qa.com/admin/RoomReservationAdmin/Create");
        Day18_FHCLoginPage fhcLoginPage = new Day18_FHCLoginPage(driver);
        fhcLoginPage.login2();

        Day18_FHCRezervasyonPage fhcrezervasyonPage = new Day18_FHCRezervasyonPage(driver);

        Select idUserSelect = new Select(fhcrezervasyonPage.idUser);
        idUserSelect.selectByIndex(1);

        Select idHotelRoomSelect = new Select(fhcrezervasyonPage.idHotelRoom);
        idHotelRoomSelect.selectByIndex(5);


        fhcrezervasyonPage.price.sendKeys("500");
        fhcrezervasyonPage.dateStart.sendKeys("12/12/2020");
        fhcrezervasyonPage.dateEnd.sendKeys("12/20/2020");
        fhcrezervasyonPage.adultAmount.sendKeys("2");
        fhcrezervasyonPage.childrenAmount.sendKeys("1");
        fhcrezervasyonPage.surname.sendKeys("AYDIN");
        fhcrezervasyonPage.phone.sendKeys("0123456789");
        fhcrezervasyonPage.email.sendKeys("abc@abc.com");
        fhcrezervasyonPage.notes.sendKeys("Deniz Manzarali");
        fhcrezervasyonPage.approved.click();
        fhcrezervasyonPage.isPaid.click();
        fhcrezervasyonPage.submitButton.click();

        Thread.sleep(5000);
        //Assert.assertTrue(fhcrezervasyonPage.success_mesaj.isDisplayed());//1. yol

        String mesaj = fhcrezervasyonPage.success_mesaj.getText();
        Assert.assertTrue(mesaj.equals("RoomReservation was inserted successfully"));//2.yol

        fhcrezervasyonPage.okButton.click();

    }
   
}
