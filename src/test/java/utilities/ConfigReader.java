package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //her seyi okuyacak sekilde bir method olusturmam gerekiyor bunu nasil yapacagim?
    //ConfigReader bizim getir goturcumuz olacak bu da properties'i kullanacak.

    public static Properties properties; // static block icersiinde properties'e bir atama yapmak istiyorsak properties'in static olmasi laizm
                                            // ve her yerden kullanabilmek icin de public yapiyorum

    static { //getProperty method'u calismadan once static block devreye girer ve properties objesine atamayi yapar.

        String dosyaYOlu="configuration.properties";
        try {
            FileInputStream fis=new FileInputStream(dosyaYOlu);
            //fis dosyaYolunu tanumladigimiz configuration.properties dosyasini okudu
                         properties=new Properties();
                         properties.load(fis); //fis'in okudugu bilgileri propertis'e yukledi           // itiraz etti ya yoksa diyor.Bunu cozmek icin ya class isminin yanina throws deriz ya da try cath atariz.
                                                                                                     //Throws dersek nereden kullanirsak kullanirsak kullanalim orada da Throws yapmamzi gerekiyr
                                                                                                     //Her seferinde Throws Throws yapmak yerine try cath kullanacagiz
                                                                                                    //dosya yolunu okuduk simdi propertis objemize yukleyelim
        } catch (IOException e) {                                                                   //ya yukleyemezsem dedi ben de bir cath daha attim
            e.printStackTrace();
        }

    }

    public static String getProperty(String key){
 /*
    test methodundan yolladigmiz String key degegerini alip
    Properties class'indan getProperty() method'unu kullanarak
    bu key'e ait valueyu bize getirdi

  */                                                         // ben configuration.peroperties dosyasinda key olarak gonderdigim datanin degeri
                                                            // yani value'su String oldugu icin return type'mi String yaptim.
                                                           // bu method'a da her yerdenher yerden ulasabilmek  icin de static yapiyorum
                                                          //boylece obje olusturmama gerek kalmadan bu method'u kullanabilirim


        return properties.getProperty(key);  // bunun icerisine bir key yazmam lazim o da kullanacagim yerdenden gelecek.
                                             // Yani amazon url'i yazisi bu method'a geleccek,
                                             // bu da amazonUrl karsisinda yazan https://www.amazon.com'u geri getirecek
    }

    //Yani @Test methodu'ndan buraya  key gelecek, bu key de configuration.peroperties dosyasina gelecek key'deki yazan bilginin valesunu alacak
    //ve getProperty method'unda return oldugu icin @Test methoduna bilgiyi dondurecegiz.
    //Zaten resmi var

   // Artik benim configReader class'i ile isim kalmadi

}
