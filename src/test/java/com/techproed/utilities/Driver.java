package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    //Driver class, driver instance'i baslatmak icin kullanilir (Singleton Driver)
    // ihtiyacimiz oldugunda driver'i kurmak ve baslatmak icin kullaniyoruz
    // Driver null oldugunda create edip baslatacagiz.(if driver == null)
    // Driver class i farkli browserlar(tarayici) ile de kullanacagimiz sekilde olusturacagiz

    private Driver(){
        //Baska obje olusturulmasini istemedigimiz icin create ediyoruz.
    }
    // driver instance olusturalim
    static WebDriver driver;
    //driver'i baslatmak icin static bir method olusturalim.
    public static WebDriver getDriver(){
        if (driver==null){
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
            }

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    public static void closeDriver(){
        if(driver!=null){  //eger drivere chrome'u isaret ediyorsa,
            driver.quit(); //driver'i kapat
            driver=null;  //driver'in null oldugundan emin olamak icin tekrar null olarak atayalim.
        }                 //Böylelikle driver'i tekrar baslatabilirim.
    }                     // Multi Browser Test

}
