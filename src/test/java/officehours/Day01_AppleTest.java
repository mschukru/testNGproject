package officehours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class Day01_AppleTest {
    private WebDriver driver;
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup(); // driver oluşturmadan önce setup işlemi gerçekleştirelim
        driver = new ChromeDriver(); // driver objesi oluşturalım
       // driver.manage().window().maximize();  // tüm ekranı kaplasın
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // driver'a bekleme süresi ekledik.
        driver.get("https://www.apple.com/"); // apple.com'a git
    }
    @Test (priority = 1)
    public void ilkUrunTest() throws InterruptedException {
        ///      (//h2[@class='headline'])[1] -- 3 tane
        WebElement ilkUrunBaslik = driver.findElement(By.xpath("(//h2[@class='headline'])[1]"));
        System.out.println(ilkUrunBaslik.getText());
        Assert.assertTrue(ilkUrunBaslik.isDisplayed());
    }
    // class='headline' olan tüm webelementleri bulalım. ve içerisindeki yazıları ekrana yazdıralım.
    // ipucu : *[@class='headline']
    @Test (priority = 2)
    public void headlineTumElementlerTest(){
        List<WebElement> list = driver.findElements(By.xpath("//*[@class='headline']")); // class='headline' a sahip tüm elementler demek
        // List<WebElement>
        for(WebElement element : list){
            System.out.println("İsim : " + element.getText());
        }
    }
    //https://www.apple.com/shop/product/MXNK2LL/A/smart-keyboard-folio-for-ipad-pro-11%E2%80%91inch-2nd-generation-us-english
    @Test (priority = 3)
    public void urunBaslikTest(){
        driver.navigate().to("https://www.apple.com/shop/product/MXNK2LL/A/smart-keyboard-folio-for-ipad-pro-11%E2%80%91inch-2nd-generation-us-english");
        //  //h1[@class='materializer']
        WebElement baslik = driver.findElement(By.xpath("//h1[@data-autom='productTitle']"));
        System.out.println(baslik.getText());
        Assert.assertTrue(baslik.isDisplayed());
    }
    @Test (priority = 4)
    public void sizeTest(){
        WebElement sizeDropdown = driver.findElement(By.id("dimensionMerchModel"));
        Select select = new Select(sizeDropdown);
        List<WebElement> list = select.getOptions();
        for(WebElement w : list){
            System.out.println("Size : " +w.getText());
        }
        Assert.assertTrue(sizeDropdown.isDisplayed());
    }
    @Test (priority = 5)
    public void dilSecenekleriTest(){
        driver.navigate().to("https://www.apple.com/shop/product/MXNK2LL/A/smart-keyboard-folio-for-ipad-pro-11%E2%80%91inch-2nd-generation-us-english");
        WebElement dilDropdown = driver.findElement(By.id("dimensionLanguage"));
        Select select = new Select(dilDropdown);
        List<WebElement> list = select.getOptions();
        for (WebElement w : list){
            System.out.println(w.getText());
        }
        System.out.println(list.size() + " tane dil seçeneği var.");
        Assert.assertTrue(dilDropdown.isDisplayed());
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
        System.out.println("Test bitti.");
    }
}