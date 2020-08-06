package com.techproed.tests;

import com.techproed.pages.Day18_FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.apache.poi.ss.formula.functions.T;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day23_ExtentReports02 extends TestBaseFinal {
    @Test
    public void ngativeTest() throws InterruptedException {
        Day18_FHCLoginPage fhcLoginPage = new Day18_FHCLoginPage(Driver.getDriver());

        extentTest = extentReports.createTest("FHC Login Test", "FHC Login fonksiyonunun testi");
        extentTest.info("url'e git");
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        driver.manage().window().maximize();
        extentTest.info("gecersiz username gönder");
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecersiz_username"));
        extentTest.info("gecersiz password gönder");
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        extentTest.info("login butonuna tikla");
        fhcLoginPage.loginButton.click();
        extentTest.info("dogrulama yap");
        Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains("Try again please"));
        extentTest.pass("PASSED: Try again please");
        Thread.sleep(10000);
       // Driver.closeDriver();
        extentTest.pass("Driver kapatildi");

    }
}
