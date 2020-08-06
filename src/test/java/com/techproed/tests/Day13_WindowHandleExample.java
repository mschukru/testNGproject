package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Day13_WindowHandleExample extends TestBase {
    //WindowHandleExample



    //Bir önceki pencereye geri döndükten sonra sayfa başlığının  “The Internet” olduğunu doğrulayın.
    @Test
    public void newWindowTest (){
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("PARENT WINDOW HANDLE => " +parentWindowHandle);

        //https://the-internet.herokuapp.com/windows adresine gidin.
        //Sayfadaki textin  “Opening a new window” olduğunu doğrulayın.
        WebElement textTest = driver.findElement(By.xpath("//h3"));
        String actualText = textTest.getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(actualText,expectedText);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        //Click Here butonuna basın.
        String actualTitleText = driver.getTitle();
        String expectedTitleText = "The Internet";
        Assert.assertEquals(actualTitleText,expectedTitleText);
        driver.findElement(By.linkText("Click Here")).click();

        //Acilan yeni pencerenin sayfa başlığının (title)  “New Window” oldugunu dogrulayin.
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String childWindowHandle: allWindowHandles) {
            if (!childWindowHandle.equals(parentWindowHandle)){
                driver.switchTo().window(childWindowHandle);
                System.out.println("CHILD WINDOW HANDLE => "+childWindowHandle);
            }
        }
        String newWindowTitle =driver.getTitle();
        Assert.assertEquals(newWindowTitle,"New Window");
        String newWindowText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(newWindowText, "New Window");


        //Sayfadaki textin   “New Window” olduğunu doğrulayın.

        driver.switchTo().window(parentWindowHandle);
        Assert.assertEquals(driver.getTitle(), "The Internet");
        



    }
}
