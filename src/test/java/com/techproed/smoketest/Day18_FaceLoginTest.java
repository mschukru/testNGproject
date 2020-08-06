package com.techproed.smoketest;

import com.techproed.pages.Day18_FaceLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day18_FaceLoginTest extends TestBase {

    @Test
    public void faceLoginTest(){
        driver.get("https://www.facebook.com/");
        Day18_FaceLoginPage faceLoginPage = new Day18_FaceLoginPage(driver);

        faceLoginPage.email.sendKeys("fakeusername");
        faceLoginPage.password.sendKeys("fakepassword");
        faceLoginPage.loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement errorMesaj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
        Assert.assertTrue(errorMesaj.isDisplayed());

        //Assert.assertTrue(faceLoginPage.error_Message.isDisplayed());
    }
}
