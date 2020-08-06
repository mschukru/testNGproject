package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day12_HandlingAlerts extends TestBase {
    //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //Bir metod olusturun: acceptAlert

    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.

    @Test
    public void acceptAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //1. butona tıklayın, uyarıdaki(alert OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
        // locate 1. button
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button1.click();
        // Alert üzerindeki mesaji konsola yazdir.
        System.out.println("Alert mesaji : " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept(); //accept(); => click Ok demektir.
        //result mesajının görüntülendiğini doğrulayın.
        WebElement resultMesaj = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultMesaj.isDisplayed()); //Hard assert


    }
    @Test
    public void dismissAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
        //2.butonu locate edelim
        //WebElement buton2 = driver.findElement()
        WebElement buton2 = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        buton2.click();
        //uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss(); //dismiss() => Cancel butonuna basmak demektir.
        //result mesajının "You clicked: Cancel" oldugunu doğrulayın.
        WebElement resultMesaj = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult = resultMesaj.getText();
        String expectedResult = "You clicked: Cancel";
        Assert.assertEquals(actualResult,expectedResult);  //Hard assert
    }
    @Test
    public void sendKeysAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
        //Locate 3.buton
        WebElement buton3 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        buton3.click();
        //uyarıdaki metin kutusuna isminizi yazin
        driver.switchTo().alert().sendKeys("AYSE");
        //OK butonuna tıklayın
        driver.switchTo().alert().accept();
        //result mesajının görüntülendiğini doğrulayın
        WebElement resultMesaj = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultMesaj.isDisplayed());

    }


}
