package com.techproed.smoketest;

import com.techproed.pages.Day20_GlbSignUpPage;
import com.techproed.pages.Day21_GlbHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20_GlbSignUpTest {
    Day20_GlbSignUpPage glbSignUpPage = new Day20_GlbSignUpPage();
    Day21_GlbHomePage glbHomePage = new Day21_GlbHomePage();
    @Test
    public void signUpTest() throws InterruptedException {
        //Driver.getDriver().get(ConfigReader.getProperty("glb_signUp_url"));
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        glbHomePage.joinNowLink.click();

        Day20_GlbSignUpPage glbSignUpPage = new Day20_GlbSignUpPage();
        glbSignUpPage.email.sendKeys(ConfigReader.getProperty("test_email"));
        glbSignUpPage.name.sendKeys(ConfigReader.getProperty("test_username"));
        glbSignUpPage.phone.sendKeys(ConfigReader.getProperty("test_phone"));
        glbSignUpPage.password.sendKeys(ConfigReader.getProperty("test_password"));
        glbSignUpPage.repassword.sendKeys(ConfigReader.getProperty("test_password"));
        glbSignUpPage.signUpButton.click();
        Thread.sleep(9000);
        System.out.println("SUCCESS MESAJ: "+ glbSignUpPage.successMesaj.getText());
        Assert.assertTrue(glbSignUpPage.successMesaj.getText().equals("Success!"));

        //Test fail olacak cünkü actual Success! ! fakat expected Success!

        Driver.closeDriver();
    }
}
