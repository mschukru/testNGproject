package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_EnableTest extends TestBase {
   @Test
           public void isEnabled(){
       driver.get("https://the-internet.herokuapp.com/dynamic_controls");

       WebElement enableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
       enableButton.click();
       WebDriverWait wait = new WebDriverWait(driver, 10);
       WebElement enableMesaj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
       Assert.assertEquals(enableMesaj.getText(),"It's enabled!");

       WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
       boolean isEnable = textBox.isEnabled();
       Assert.assertTrue(isEnable);
   }


}
