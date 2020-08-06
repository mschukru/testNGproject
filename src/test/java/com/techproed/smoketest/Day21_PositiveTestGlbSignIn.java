package com.techproed.smoketest;

import com.techproed.pages.Day21_GlbSignInPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class Day21_PositiveTestGlbSignIn {

    @Test
    public void postiveTest(){
        Driver.getDriver().get(ConfigReader.getProperty("glb_signIn_Url"));
        Day21_GlbSignInPage glbSignInPage = new Day21_GlbSignInPage();
        glbSignInPage.email.sendKeys(ConfigReader.getProperty("test_email"));
        glbSignInPage.password.sendKeys(ConfigReader.getProperty("test_password"));
        glbSignInPage.loginButton.click();

    }
}
