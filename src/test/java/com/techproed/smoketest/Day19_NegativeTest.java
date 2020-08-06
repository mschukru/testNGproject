package com.techproed.smoketest;


import com.techproed.utilities.ConfigReader;
import com.techproed.pages.Day18_FHCLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day19_NegativeTest extends TestBase {
    @Test(groups = "grouptest1")
    public  void gecersizUsername(){   //http://www.fhctrip.com/Account/Logon
        driver.get(ConfigReader.getProperty("fhc_login_url"));
        Day18_FHCLoginPage fhcLoginPage=new Day18_FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecersiz_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gecerli_password"));
        fhcLoginPage.loginButton.click();
        //wait problemi varsa bunu kullanmaliyiz.
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        WebElement tryAgain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Try again please']")));
//        Assert.assertTrue(tryAgain.isDisplayed());
        Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains(ConfigReader.getProperty("login_error_mesaj")));
        //Assert.assertTrue(fhcLoginPage.error_mesaj.isDisplayed());
    }
    @Test(groups = "grouptest1")
    public void gecersizPassword(){
        driver.get("http://fhctrip-qa.com/Account/Logon");
        Day18_FHCLoginPage fhcLoginPage = new Day18_FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("manager12!");
        fhcLoginPage.loginButton.click();
        Assert.assertTrue(fhcLoginPage.error_mesaj.isDisplayed());
    }
    @Test(groups = "grouptest1")
    public  void gecersizUsernamePass(){
        driver.get("http://fhctrip-qa.com/Account/Logon");
        Day18_FHCLoginPage fhcLoginPage = new Day18_FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manage");
        fhcLoginPage.password.sendKeys("manager12!");
        fhcLoginPage.loginButton.click();
        Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains("Try again please"));
    }
}

