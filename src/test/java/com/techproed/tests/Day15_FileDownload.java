package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day15_FileDownload extends TestBase {
    //Iki  method olusturun : isExist (), downloadTest ()
    @Test
    public void isExist(){
        String mevcutKlasor = System.getProperty("user.dir");
        System.out.println("MEVCUT KLASOR => "+ mevcutKlasor);

        String userKlasor = System.getProperty("user.home");
        System.out.println("USER KLASOR => " +userKlasor);

        String filePath = userKlasor + "/Downloads/IMG_65D4D5D602EA-1.jpeg";

        boolean isFileExist = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isFileExist);
        //Eger dosya varsa(file exist) true ve Pass,yoksa false ve test Fail olur..



    }
    @Test
    public void downloadTest (){

        //downloadTest () metodunun icinde aşağıdaki testi yapın:
        //https://the-internet.herokuapp.com/download adresine gidin.
        driver.get("https://the-internet.herokuapp.com/download");
        //image1.jpg dosyasını indir
        WebElement image1 = driver.findElement(By.linkText("image1.jpg"));
        image1.click();
        //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın.
        //Kullanici klasoru
        String userKlasor = System.getProperty("user.home");
        // indirilen dosyanin konumunu(path) buluyoruz.
        String filePath = userKlasor + "/Downloads/image1.jpg";
        //dosya var mi yok mu kontrol ediyoruz.
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);  // dosya yuklendi ise PASS, Degilse FAIL

    }
}
