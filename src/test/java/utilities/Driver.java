package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {


    /*
      POM'de Driver icin TestBase classina extends etmek yerine
      Driver classíndan static methodlar kullanarak
      driver olusturup, ilgili ayarlarin yapilmasi
      ve en sonda driverín kapatilmasi tercih edilmistir.

      POM'de Driver class'indaki getDriver() methodunun obje olusturularak kullanilmasini
      engellemek icin Singleton pattern kullanimi benimsenmistir

      Singleton Pattern : tekli kullanim demek, bir class'in farkli classlardan obje olusturularak kullanimi
      engellemek icin kullanilir.Yani biz diyoruz ki kimse Driver class'indan obje olusturamasin
      herkes static kullanim method'unu kullansin.

      Bunu saglamak icin yapmamiz gereken sey oldukca basit
      obje olusturmak icin kullanilan constructor'i private yaptigimizda
      baska classlarda Driver class'indan obje olusturulmasi mumkun olamaz
     */
    private Driver(){

    }


    /*
    bu getDriver methodu static oldugu icin
    Driver class'indan getDriver(); methodunu cagirdigimda  bana bir driver getirecek,
    tek vazifesi budur.Peki return type void olan bir method bana bir sey getirebilir mi?Hayir,
    o yuzden bana bir sey dondurmesi icin, biz getDriver methodunun return type'ini WebDriver yapacagiz

     */
    //driver'i her iki method'da da kullanacagim icin class level'da driver olusturuyorum   ve static  yapiyorum.
    static WebDriver driver;

    public static WebDriver getDriver(){ // Biz getDriver methodunu her cagirdigimizda getDriver methodundaki driver'a new Chrome degerini atiyor
        //dolayisiyla yeni bir driver olusuyor ama ben istiyorum ki bir kere olusturdugumda yenisine gerek yok zaten.
        //Nasil yapacagiz?If ile

        if (driver==null) { // eger driver'a daha onceden deger atanmamissa o zaman ata.
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "headless-chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true)); // bu  yazdigim chromu gostermeden arka planda calisip testlerini yapar.
                    break;

            }


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;// eger driver'a daha onceden deger atanmissa o zaman yenisini atama var olani geri dondur.
    }

    public static void closeDriver(){ // kapatmak istedigimde de bu methodu kullanacagim ve yine tek yaptigi driver'i kapatmaktir.
        //olur da driver olusturmadan birisi driver.close; yazabilir,
        //biz de bu durumda exception vermemesi icin if kullanacagiz yine

        if (driver!=null) {
            driver.close();
            driver=null; // getDriver methodunda null mi diye kontrol ediyor idi, biz de driveri null yaptik
            //eger driver null'a esit degilse driver'i kapat ve driver'i null yap.
        }
    }

    public static void quitDriver(){

        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }


    /*
     Bunlari yapmanin bana ne faydasi var?
     Soyle diyelim bazi method'larda class'tan once driver'in calisip en sonda da kapanmasi mantiklidir
     Bazi methodlarda ise driver'in her seferinde acilip kapanmasi daha mantiklidir.
     Test base beni bu kaliba sokmaya calisiyor,
     ama ben istiyorum ki istedigim zaman acayim istedigim zaman kapatim driver'i.
     */

    //Bundan sonraki adim driver'i tum browserlarda calisir hale getirecegiz.
}
