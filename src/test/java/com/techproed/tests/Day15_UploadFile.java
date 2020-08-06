package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day15_UploadFile extends TestBase {
   @Test
   public void uploadFileMethod(){
       //https://the-internet.herokuapp.com/upload gidin
       driver.get("https://the-internet.herokuapp.com/upload");
       // chooseFile butonunu bulalim
       WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
       //Yuklemek istediginiz dosyayi secin.
       String filePath = "/Users/susasu/Downloads/IMG_65D4D5D602EA-1.jpeg";
       // sendKeys() kullanabilmek icin choose file elementinin tag = input ve type="file" olmali
       chooseFileButton.sendKeys(filePath);
       //Upload butonuna basin.
       WebElement uploadButton = driver.findElement(By.id("file-submit"));
       uploadButton.click();
       //“File Uploaded!” textinin goruntulendigini dogrulayin.
       Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),"File Uploaded!");
   }

}
