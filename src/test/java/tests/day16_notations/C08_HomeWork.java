package tests.day16_notations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.time.Duration;

public class C08_HomeWork  {
    //● Bir class oluşturun: DependsOnTest
    //● https://www.amazon.com/ adresine gidin.
    //1. Test : Amazon ana sayfaya gittiginizi test edin
    //2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    //arama yapin ve aramanizin gerceklestigini Test edin
    //3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
    //$16.83 oldugunu test edin

    WebDriver driver;
    SoftAssert softAssert=new SoftAssert();

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown(){
       // driver.close();
    }

    @Test
    public void test01() {
        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://amazon.com");
        // Amazon ana sayfaya gittiginizi test edin
      WebElement logo= driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));

        softAssert.assertTrue(logo.isEnabled());
        softAssert.assertAll();

    }

    //2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    //arama yapin ve aramanizin gerceklestigini Test edin
    @Test(dependsOnMethods = "test01")
    public void test02() {
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        WebElement resultText=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(resultText.isDisplayed());
        softAssert.assertAll();

    }

    //3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
    //$16.83 oldugunu test edin
    @Test (dependsOnMethods = "test02")
    public void test03() {
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        String expectedPrice="$16.83";
        String actualPrice=driver.findElement(By.xpath("(//span[@class='a-offscreen'])[1]")).getText();
        softAssert.assertEquals(actualPrice,expectedPrice,"urun fiyati baska");

        softAssert.assertAll();
    }


}
