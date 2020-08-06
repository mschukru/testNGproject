package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day11_Soft_Hard_Assertion {
    //http://a.testaddressbook.com/sign_in adresine gidin.
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");
    }
    @Test
    public void login(){
        //email textbox,password textbox, ve signin button elementlerini locate edin.
        //Aşağıdaki username ve password girin ve signin buttonuna tıklayın.
        //Username :  testtechproed@gmail.com
        //Password :   Test1234!
        WebElement emailBox = driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");
        WebElement passwordBox = driver.findElement(By.id("session_password"));
        passwordBox.sendKeys("Test1234!");
        WebElement signInButton =driver.findElement(By.name("commit"));
        signInButton.click();
    }
    @Test(dependsOnMethods = "login")
    public void homePage(){
      WebElement welcomeMessage = driver.findElement(By.xpath("//h1[.='Welcome to Address Book']"));
        System.out.println(welcomeMessage.getText());
        Assert.assertTrue(welcomeMessage.isDisplayed());//HARD ASSERT
        System.out.println("Hard assert fail olursa bu satir calismayacak");
        //1. Adim: create object
        SoftAssert softAssert = new SoftAssert();

        // 2. Adim: asstion icin olusturdugumuz object'i kullanin
        //softAssert.assertTrue(!welcomeMessage.isDisplayed());
        softAssert.assertTrue(welcomeMessage.isDisplayed());
        //softAssert.assertEquals(3,5);
        //3. Adim: AssertAll ();
        softAssert.assertAll();// BU SATIR COK ÖNEMLI!!! assertAll(); gercek assertion'u yapar
        // assertAll(); yazilmazsa test FAIL olmasi gerekirken PASS görünür.

        WebElement userID = driver.findElement(By.className("navbar-text"));
        String actualID = userID.getText();
        String expectedId = "testtechproed@gmail.com";
        Assert.assertEquals(actualID,expectedId);

        //SOFT ASSERT
        //2.Adim:
        softAssert.assertEquals(actualID,expectedId);

        //3.Adim:
        softAssert.assertAll();

    }
    @AfterClass
    public void tearDown() {
       driver.quit();
    }

    //Daha sonra farklı iddialar(assertions) kullanarak sayfaya doğru giriş yaptığınızı doğrulayın.
    //Daha sonra farklı iddialar(assertions) kullanarak testtechproed@gmail.com beklenen kullanıcı  kimliğinin(userID) doğrulayın

}
