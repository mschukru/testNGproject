package com.techproed.smoketest;

import com.techproed.pages.Day18_FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20_FirstDriverTest {

    @Test
    public void negativeTestPassword() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));

        Day18_FHCLoginPage fhcLoginPage = new Day18_FHCLoginPage(Driver.getDriver());
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecerli_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        Thread.sleep(3000);
        fhcLoginPage.loginButton.click();

        Assert.assertTrue(fhcLoginPage.error_mesaj.isDisplayed());
    }

}
