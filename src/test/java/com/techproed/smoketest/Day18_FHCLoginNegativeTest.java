package com.techproed.smoketest;

import com.techproed.pages.Day18_FHCLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day18_FHCLoginNegativeTest extends TestBase {

    @Test
    public void hataliUsername(){
        driver.get("http://fhctrip-qa.com/Account/Logon");
        Day18_FHCLoginPage fhcLoginPage = new Day18_FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager");
        fhcLoginPage.password.sendKeys("Man1ager!2");
        fhcLoginPage.loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement tryAgain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Try again please']")));
        Assert.assertTrue(tryAgain.isDisplayed());

        //Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains("Try again please"));
       // Assert.assertTrue(fhcLoginPage.error_mesaj.isDisplayed());


    }
    @Test
    public void hataliPassword(){
        driver.get("http://fhctrip-qa.com/Account/Logon");
        Day18_FHCLoginPage fhcLoginPage = new Day18_FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("Man1ager!");
        fhcLoginPage.loginButton.click();

       // WebDriverWait wait = new WebDriverWait(driver, 10);
       // WebElement tryAgain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Try again please']")));
       // Assert.assertTrue(tryAgain.isDisplayed());

        Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains("Try again please"));
    }
    @Test
    public void ikisideHatali(){
        driver.get("http://fhctrip-qa.com/Account/Logon");
        Day18_FHCLoginPage fhcLoginPage = new Day18_FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager");
        fhcLoginPage.password.sendKeys("Man1ager!");
        fhcLoginPage.loginButton.click();

        Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains("Try again please"));

    }


}
