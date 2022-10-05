package tests.day22_crossBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseCross;

public class C02_SoftAssertCross extends TestBaseCross {

    /*
      Softaseertion baslangic ve bitis satirlari arasindaki
      tum assertionlari yapip bitis satirina geldiginde bize buldugu tum hatalari rapor eder.
     */

    //softassert baslangici obje olusturmaktir
    SoftAssert softAssert=new SoftAssert();

    /*
     Bizim su anada kadarki gordugumuz Assert staticti classIsmi.method olarak yaziyorduk
     simdi ise softAssert static olmadigi icin obje olusturup obje uzerinden softAsserti kullanacagim
     */

    @Test
    public void test01() {
        //1- amazon anasayfaya gidin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();


        driver.get("https://amazon.com");

        //2- title'in Amazon icerdigini test edin
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"title amazon icermiyor");

        //3- Arama kutusunun ersilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"arama kutusuna erisilemiyor");

        //4- Arama kutusuna Nutella yazip aratin
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //5- Arama yapildigini test edin
        WebElement aramaSonucelementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(aramaSonucelementi.isDisplayed(),"arama yapilamadi");

        //6- arama sonucucnun Nutella icerdigini test edin
        softAssert.assertTrue(aramaSonucelementi.getText().contains("Nutella"),"Sonuc yazisi Kutella icermiyor");

        //softassert'e bitis satirini soylemek icin assertAll() kullanilir
        //bu satir yazilmazsa assertion gorevi yapilmamis olur
        softAssert.assertAll();


        /*
         softassertin'un hata bulsa bile calismaya devam etme ozelligi
         assertAll()'a kadardir.
         Eger assertAll()'da failed rapor edeilirse calisma durur
         ve calss'in kalan kismi calistirilmaz
         (Yani asserAll() hardAsserddeki her bir asser gibidr, hatayi yakalarsa calisma durur)
         */
        System.out.println("assertion'lardan fail olan olursa burasi calismaz");

        /*Junitte assertTrue icin istersek basa String bir mesaj yazabiliyorduk
        TestNg'de ise once condition sonra istersek String mesaj yazabiliyoruz.

        Bize test edin denirse hard Assert olarak algiliyoruz
        Eger soft assert kullanmamiz istenirse verification kullaniliyor

         */


    }
}
