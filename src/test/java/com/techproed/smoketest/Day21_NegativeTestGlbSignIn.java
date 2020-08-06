package com.techproed.smoketest;

import com.techproed.pages.Day21_GlbSignInPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day21_NegativeTestGlbSignIn {

    @Test
    public void gecersizTest(){
        Driver.getDriver().get(ConfigReader.getProperty("glb_signIn_Url"));
        Day21_GlbSignInPage glbSignInPage = new Day21_GlbSignInPage();
        glbSignInPage.email.sendKeys(ConfigReader.getProperty("gecersiz_email"));
        glbSignInPage.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        glbSignInPage.loginButton.click();

        Assert.assertTrue(glbSignInPage.mesaj.getText().equals("Sorry!"));

        Driver.closeDriver();

    }
}
