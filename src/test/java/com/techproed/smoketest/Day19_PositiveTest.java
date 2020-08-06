package com.techproed.smoketest;

import com.techproed.pages.Day18_FHCLoginPage;
import com.techproed.utilities.TestBase;
import com.techproed.utilities.ConfigReader;
import org.testng.annotations.Test;

public class Day19_PositiveTest extends TestBase {
    @Test
    public  void positiveTestLogin(){   //http://www.fhctrip.com/Account/Logon
        driver.get(ConfigReader.getProperty("fhc_login_url"));
        Day18_FHCLoginPage fhcLoginPage=new Day18_FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecerli_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gecerli_password"));
        fhcLoginPage.loginButton.click();

    }

}
