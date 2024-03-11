package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;
import utils.ReusableMethods;

import java.time.Duration;

public class AileButcemPage {
    public AileButcemPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver(), Duration.ofSeconds(30
        )), this);
    }

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public MobileElement emailBox;
    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    public MobileElement passwordBox;
    @FindBy(xpath = "//*[@text='Başarılı']")
    public MobileElement basariliYazisi;
    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public MobileElement isimKutusu;
    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    public MobileElement soyisimKutusu;
    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    public MobileElement sehirKutusu;
    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[4]")
    public MobileElement yasKutusu;
    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[5]")
    public MobileElement meslekKutusu;


    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public MobileElement aciklamaKutusu;




   public void bilgiSilme(){
   isimKutusu.clear();
   soyisimKutusu.clear();
   sehirKutusu.clear();
   yasKutusu.clear();
   meslekKutusu.clear();
   }
   public void textBoxVeriGirme(String isim, String soyisim, String sehir,String yas, String meslek){
       bilgiSilme();
       isimKutusu.sendKeys(isim);
       isimKutusu.sendKeys(soyisim);
       isimKutusu.sendKeys(sehir);
       isimKutusu.sendKeys(yas);
       isimKutusu.sendKeys(meslek);
       ReusableMethods.scrollWithUiScrollable("Kaydet");
   }
   public void textBoxKontrol(String isim, String soyisim, String sehir,String yas, String meslek){
       Assert.assertTrue(isimKutusu.getText().contains(isim));
       Assert.assertTrue(isimKutusu.getText().contains(soyisim));
       Assert.assertTrue(isimKutusu.getText().contains(sehir));
       Assert.assertTrue(isimKutusu.getText().contains(yas));
       Assert.assertTrue(isimKutusu.getText().contains(meslek));
   }


    public void ilkEkranAyarlamalari() throws InterruptedException {
    ReusableMethods.wait(30);
    for (int i = 0; i < 6; i++) {
        ReusableMethods.scrollScreenMethod(946, 1005, 750, 150, 1005, 1000);

    }
    ReusableMethods.scrollWithUiScrollable("Giriş Yap");

}

}
