package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.AileButcemPage;
import utils.ConfigReader;
import utils.Driver;
import utils.ReusableMethods;

public class aileButcem {
    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();

    AileButcemPage aileButcemPage = new AileButcemPage();

    @Given("ilk ekran ayarlarini yapin {int} {int} {int} {int} {int} {int} {int} {int} ve ardindan login {string} sayfasina ulasin")
    public void ilk_ekran_ayarlarini_yapin_ve_ardindan_login_sayfasina_ulasin(int for1,int forSart,int x1,int y1,int wait,int x2,int y2,int bekleme,String girisText) throws InterruptedException {
       ReusableMethods.wait(40);
        for (int i=for1; i<forSart; i++){
            ReusableMethods.scrollScreenMethod(x1,y1,wait,x2,y2,bekleme);

        }
           ReusableMethods.scrollWithUiScrollable(girisText);
    }

    @Given("{string} ve {string} bilgilerini girerek kullanici bilgileriyle {string} giris yapin")
    public void mail_ve_password_bilgilerini_girerek_kullanici_bilgileriyle_giris_yapin(String mail,String password, String girisYap) {
        aileButcemPage.emailBox.sendKeys(ConfigReader.getProperty(mail));
        aileButcemPage.passwordBox.sendKeys(ConfigReader.getProperty(password));
        ReusableMethods.scrollWithUiScrollable(girisYap);
    }

    @Given("uygulamaya kullanici bilgileriyle giris yapildigini dogrulayin")
    public void uygulamaya_kullanici_bilgileriyle_giris_yapildigini_dogrulayin() {
        Assert.assertTrue(aileButcemPage.basariliYazisi.isDisplayed());
    }

    @Given("sol kisimdaki menuden {string} bolumune gidin")
    public void sol_kisimdaki_menuden_hesabim_bolumune_gidin(String hesap) throws InterruptedException {
        ReusableMethods.koordinatTiklamaMethodu(100,132,10);
        ReusableMethods.scrollWithUiScrollable(hesap);

    }

    @Given("hesabim sayfasindaki bilgileri {string} {string} {string} {string} {string} degistirerek degisikleri kaydedin")
    public void hesabim_sayfasindaki_bilgileri_degistirerek_degisikleri_kaydedin(String isim, String soyisim, String sehir,String yas, String meslek) {

        aileButcemPage.textBoxVeriGirme(ConfigReader.getProperty(isim),ConfigReader.getProperty(soyisim),ConfigReader.getProperty(sehir),ConfigReader.getProperty(yas),ConfigReader.getProperty(meslek));
        aileButcemPage.textBoxKontrol(ConfigReader.getProperty(isim),ConfigReader.getProperty(soyisim),ConfigReader.getProperty(sehir),ConfigReader.getProperty(yas),ConfigReader.getProperty(meslek));
    }

    @Given("ardindan degisiklerin yapildigini dogrulayin")
    public void ardindan_degisiklerin_yapildigini_dogrulayin(String isim, String soyisim, String sehir,String yas, String meslek) {
       aileButcemPage.textBoxKontrol(isim,soyisim, sehir, yas, meslek);

    }
    @Given("kullanici uygulamayi kapatir")
    public void kullanici_uygulamayi_kapatir() {
        Driver.quitAppiumDriver();
    }
    @Given("anasayfadaki arti {int} {int} {int} butonuna tiklayin")
    public void anasayfadaki_arti_butonuna_tiklayin(Integer int1, Integer int2, Integer int3) throws InterruptedException {
        ReusableMethods.koordinatTiklamaMethodu(int1,int2,int3);
    }
    @Given("{string} bolumune tiklayin")
    public void bolumune_tiklayin(String Ekle) {
      ReusableMethods.scrollWithUiScrollable(Ekle);
    }
    @Given("Gelir Ekle bolumunde {string} ekleyin,")
    public void gelir_ekle_bolumunde_ekleyin(String aciklama) {
      aileButcemPage.aciklamaKutusu.sendKeys(aciklama);
    }
    @Given("{string} tiklayin,")
    public void tiklayin(String Duzensiz) {
     ReusableMethods.scrollWithUiScrollable(Duzensiz);
    }
    @Given("{string} tiklayin,")
    public void serbest_gelir_tiklayin(String serbestGelir) {
     ReusableMethods.scrollWithUiScrollable(serbestGelir);
    }
    @Given("{int} {int} koordinatlarini ekleyin")
    public void koordinatlarini_ekleyin(Integer int1, Integer int2) {

    }
    @Given("tarih ekleyin,")
    public void tarih_ekleyin() {

    }
    @Given("tutari belirleyin ve kaydedin")
    public void tutari_belirleyin_ve_kaydedin() {


     ReusableMethods.scrollWithUiScrollable("Kaydet");
    }
    @Given("basariyla eklendigini dogrulayin")
    public void basariyla_eklendigini_dogrulayin() {
     Assert.assertTrue(aileButcemPage.basariliYazisi.getText().contains("Başarılı"));
    }



}