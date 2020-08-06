package com.techproed.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.techproed.pages.Day20_GlbSignUpPage;
import com.techproed.pages.Day21_GlbHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day23_ExtentReports01 {
    //ExtentReports ==> Raporlamaya baslamak icin buna ihtiyacimiz var.
    //Raporu kapatmak icin flussh () methodu kullanilir.
    //ExtentHtmlReporter==> raporlari yapilandirmaya (configuration) yardimci olur. Html raporlarini create eder.
    //ExtentTest ==> Aciklama(logs) eklemek icin, test adimlarini belirlemek icin kullanilir.
    public ExtentReports extentReports;
    public ExtentHtmlReporter extentHtmlReporter;
    public ExtentTest extentTest;

    @BeforeTest
    public void setup(){
        //reporter'i baslatalim ve konumunu ayarlayalim.
        //                                     klasor: reports, dosya adi: extentreport.html
        extentHtmlReporter = new ExtentHtmlReporter("./reports/extentreport.html");
        // extentHtmlReporter'a bazi yapilandirmalar yapalim.
        extentHtmlReporter.config().setReportName("GLB trader Report");
        extentHtmlReporter.config().setTheme(Theme.STANDARD);
        extentHtmlReporter.config().setDocumentTitle("GLB sign up report");
        extentHtmlReporter.config().setEncoding("UTF-8");

        //ExtentReports create edelim.
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        //daha fazla aciklama ekleyebiliriz.
        extentReports.setSystemInfo("Automation engineer", "Mehmet");
        extentReports.setSystemInfo("Browser", "Report");
    }

    @Test
    public void signUpTest() throws InterruptedException {
        Day20_GlbSignUpPage glbSignUpPage = new Day20_GlbSignUpPage();
        Day21_GlbHomePage glbHomePage = new Day21_GlbHomePage();

        extentTest = extentReports.createTest("GLB Sign Up Test");
        extentTest.info("Url'e git");
        //Driver.getDriver().get(ConfigReader.getProperty("glb_signUp_url"));
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        extentTest.info("join now linikne tikla");
        glbHomePage.joinNowLink.click();
        extentTest.info("email gönder");
        glbSignUpPage.email.sendKeys(ConfigReader.getProperty("test_email"));
        extentTest.info("username gönder");
        glbSignUpPage.name.sendKeys(ConfigReader.getProperty("test_username"));
        extentTest.info("telefon numarasi gönder");
        glbSignUpPage.phone.sendKeys(ConfigReader.getProperty("test_phone"));
        extentTest.info("password yaz");
        glbSignUpPage.password.sendKeys(ConfigReader.getProperty("test_password"));
        extentTest.info("passwordu tekrar yaz");
        glbSignUpPage.repassword.sendKeys(ConfigReader.getProperty("test_password"));
        extentTest.info("sign up'a tikla");
        glbSignUpPage.signUpButton.click();
        Thread.sleep(9000);
        System.out.println("SUCCESS MESAJ: "+ glbSignUpPage.successMesaj.getText());
        Assert.assertFalse(glbSignUpPage.successMesaj.getText().equals("Success!"));

        //Test fail olacak cünkü actual Success! ! fakat expected Success!
        extentTest.pass("PASSED: Test basariyla tamamlandi.");

        Driver.closeDriver();
        extentTest.pass("Driver basariyla kapatildi.");
    }
    @AfterTest
    public void endReport(){
        extentReports.flush();
    }
}
