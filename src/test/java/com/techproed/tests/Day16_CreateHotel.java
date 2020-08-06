package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_CreateHotel extends TestBase {
    //http://fhctrip-qa.com/admin/HotelAdmin/Create adresine gidin.

    //Login butonuna basin.
    //Acilan sayfadaki butun textboxlara istediginiz verileri girin (en sondaki dropdowna dikkat edin).
    //Save butonuna basin.
    //“Hotel was inserted successfully” textinin goruntulendigini dogrulayin.
    //OK butonuna tiklayin.
   @Test
   public void f() throws InterruptedException {
       driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
       //Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
       //Username : manager2
       //Password : Man1ager2!
       WebElement userNameBox = driver.findElement(By.id("UserName"));
       WebElement passwordBox = driver.findElement(By.id("Password"));
       WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
       userNameBox.sendKeys("manager2");
       passwordBox.sendKeys("Man1ager2!");
       loginButton.click();
       driver.findElement(By.id("Code")).sendKeys("TRÄUME");
       driver.findElement(By.id("Name")).sendKeys("SONNESCHEIN");
       driver.findElement(By.id("Address")).sendKeys("BRUSSEL");
       driver.findElement(By.id("Phone")).sendKeys("01234567890");
       driver.findElement(By.id("Email")).sendKeys("sonneschein@gmail.com");

       WebElement IDGroup = driver.findElement(By.id("IDGroup"));
       Select select = new Select(IDGroup);
       select.selectByIndex(1);

       //Save butonuna basin.
       WebElement saveButton = driver.findElement(By.id("btnSubmit"));
       saveButton.click();
       Thread.sleep(3000);

       WebDriverWait wait = new WebDriverWait(driver, 10);
       boolean isTrue = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),"Hotel was inserted successfully" ));
       Assert.assertTrue(isTrue);

      // WebElement mesaj = driver.findElement(By.xpath("//div[@class='bootbox-body']"));
      // Assert.assertTrue(mesaj.isDisplayed());

       WebElement okButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
       okButton.click();



   }
}
