package com.techproed.tests;

import com.techproed.pages.Day18_FHCLoginPage;
import com.techproed.pages.MehmetFhcRezervasyonPage;
import com.techproed.smoketest.Day18_FHCLoginPositiveTest;
import com.techproed.utilities.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public  class MehmetFhcRezervasyonTest extends TestBaseFinal {

   MehmetFhcRezervasyonPage mehmetFhcRezervasyonPage;
   SoftAssert softAssert ;

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
        softAssert=  new SoftAssert();
        softAssert.assertTrue(mesaj.equals("manager2"));
        softAssert.assertAll();

        String mesaj2=idHotelRoomSelect.getFirstSelectedOption().getText();
        Assert.assertTrue(mesaj2.equals("fazli"));

    }

    @Test(priority = 2)
    public void fhcPrice() {
        mehmetFhcRezervasyonPage = new MehmetFhcRezervasyonPage(driver);
        mehmetFhcRezervasyonPage.price.sendKeys("uc yuz");
        String priceErrorMesaj = mehmetFhcRezervasyonPage.priceErrorMesaj.getText();

        softAssert=  new SoftAssert();
        softAssert.assertTrue(priceErrorMesaj.equals("The field Price must be a number."));

    }
    @Test(priority = 3)
    public void fhcgecmisDate() {
        mehmetFhcRezervasyonPage = new MehmetFhcRezervasyonPage(driver);
        mehmetFhcRezervasyonPage.dateStart.sendKeys("20/12/2019");
        String girisReservasyonTarihi=mehmetFhcRezervasyonPage.dateStart.getText();
        Assert.assertFalse(girisReservasyonTarihi.equals("20/12/2019"));
        mehmetFhcRezervasyonPage.dateEnd.sendKeys("27/12/2019");
        String cikisReservasyonTarihi=mehmetFhcRezervasyonPage.dateEnd.getText();
        Assert.assertFalse(cikisReservasyonTarihi.equals("27/12/2019"));
    }
    @Test(priority = 4)
    public void fhcgecersizDate() {

        mehmetFhcRezervasyonPage = new MehmetFhcRezervasyonPage(driver);
        mehmetFhcRezervasyonPage.dateStart.sendKeys("20/12/2020");

        mehmetFhcRezervasyonPage.dateEnd.sendKeys("12/12/2020");
        String dateErrorMesaj = mehmetFhcRezervasyonPage.dateStartErrorMesaj.getText();
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
        Assert.assertTrue(surnameErrorMesaj.equals("The field surname must be a text."));
    }
    @Test(priority = 7) //phone sadece numara ile yazilabilmeli..
    public void phone() {
        mehmetFhcRezervasyonPage.phone.sendKeys("zero one two");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String phoneError = mehmetFhcRezervasyonPage.phone.getText();
        Assert.assertFalse(phoneError.equals("zero one two"));
    }
    @Test(priority = 8)
    public void emailButton () {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        mehmetFhcRezervasyonPage.submitButton.click();

        mehmetFhcRezervasyonPage.email.sendKeys("abc.abc.com");
        String errorMesaj = mehmetFhcRezervasyonPage.emailErrorMesaj.getText();
        Assert.assertTrue(errorMesaj.equals("Please provide correct email address"));
        // driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        // String mesaj = mehmetFhcRezervasyonPage.success_mesaj.getText();
        // Assert.assertFalse(mesaj.equals("RoomReservation was inserted successfully"));

    }

    @Test(priority = 9)
    public void submitButton () {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        mehmetFhcRezervasyonPage.submitButton.click();
        String errorMesaj1 = mehmetFhcRezervasyonPage.userErrorMesaj.getText();
        Assert.assertTrue(errorMesaj1.equals("Select User"));

        String errorMesaj2 = mehmetFhcRezervasyonPage.roomErrorMesaj.getText();
        Assert.assertTrue(errorMesaj2.equals("Select HotelRoom"));

        String errorMesaj3 = mehmetFhcRezervasyonPage.priceError2Mesaj.getText();
        Assert.assertTrue(errorMesaj3.equals("Price"));

        String errorMesaj4 = mehmetFhcRezervasyonPage.dateStartErrorMesaj.getText();
        Assert.assertTrue(errorMesaj4.equals("DateStart"));

        String errorMesaj5 = mehmetFhcRezervasyonPage.dateEndErrorMesaj.getText();
        Assert.assertTrue(errorMesaj5.equals("DateEnd"));

        String errorMesaj6 = mehmetFhcRezervasyonPage.adultErrorMesaj.getText();
        Assert.assertTrue(errorMesaj6.equals("AdultAmount"));

        String errorMesaj7 = mehmetFhcRezervasyonPage.childErrorMesaj.getText();
        Assert.assertTrue(errorMesaj7.equals("ChildrenAmount"));

        String errorMesaj8 = mehmetFhcRezervasyonPage.surnameErrorMesaj.getText();
        Assert.assertTrue(errorMesaj8.equals("Contact Full Name"));

        String errorMesaj9 = mehmetFhcRezervasyonPage.phoneErrorMesaj.getText();
        Assert.assertTrue(errorMesaj9.equals("Contact Phone"));

        String errorMesaj10 = mehmetFhcRezervasyonPage.emailErrorMesaj.getText();
        Assert.assertTrue(errorMesaj10.equals("Please provide correct email address"));

        String errorMesaj11 = mehmetFhcRezervasyonPage.notesErrorMesaj.getText();
        Assert.assertTrue(errorMesaj11.equals("Notes"));

        mehmetFhcRezervasyonPage.email.sendKeys("abc.abc.com");
        String errorMesaj = mehmetFhcRezervasyonPage.emailErrorMesaj.getText();
        Assert.assertTrue(errorMesaj.equals("Please provide correct email address"));
       // driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
       // String mesaj = mehmetFhcRezervasyonPage.success_mesaj.getText();
       // Assert.assertFalse(mesaj.equals("RoomReservation was inserted successfully"));
    }
   /* @AfterMethod(alwaysRun = true)//In AfterMethod, we are getting the screenshots and attaching the report when test fails
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {//When test case fails, then take the screenshot and attached the report
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());//getScreenshot is coming from ReusableMethods
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);//adding the screenshot to the report
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.skip("Test Case is skipped: " + result.getName());
        }
        Driver.closeDriver();
    }


    */


}
