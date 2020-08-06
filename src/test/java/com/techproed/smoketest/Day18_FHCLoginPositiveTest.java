package com.techproed.smoketest;

import com.techproed.pages.Day18_FHCLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class Day18_FHCLoginPositiveTest extends TestBase {

    @Test
    public void positiveTestLogin(){
        driver.get("http://fhctrip-qa.com/Account/Logon");
        Day18_FHCLoginPage fhcLoginPage = new Day18_FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("Man1ager2!");
        fhcLoginPage.loginButton.click();


    }

}
