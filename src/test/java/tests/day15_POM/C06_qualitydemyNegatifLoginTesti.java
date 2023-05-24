package tests.day15_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_qualitydemyNegatifLoginTesti {

    @Test
    public void gecersizIsimSifreTesti(){
        // QUALITYDEMY ANA SAYFAYA GIDIN
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        // gecersiz username yi ilgili kutulara yazin
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));

        // gecersiz sifre yi ilgili kutulara yazin
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        // cikan uyariyi kabul et
        Driver.getDriver().findElement(By.xpath("//*[@id=\"cookieConsentContainer\"]/div[2]/a")).click();

        // login butonuna basin
        qualitydemyPage.loginButonu.submit();

        // basarili giris yapilmadigini test edin
        Assert.assertTrue(qualitydemyPage.emailKutusu.isEnabled());

        // sayfayi kapatin
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void gecersizIsimTesti(){
        // QUALITYDEMY ANA SAYFAYA GIDIN
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        // login linkine tiklayin

        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        // gecersiz username ve gecerli sifre yi ilgili kutulara yazin
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        // cikan uyariyi kabul et
        Driver.getDriver().findElement(By.xpath("//*[@id=\"cookieConsentContainer\"]/div[2]/a")).click();

        // login butonuna basin
        qualitydemyPage.loginButonu.click();

        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailKutusu.isEnabled());
        // sayfayi kapatin

        Driver.closeDriver();
    }

    @Test
    public void gecersizSifreTesti(){
        // QUALITYDEMY ANA SAYFAYA GIDIN
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        // login linkine tiklayin

        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        // gecerli username ve gecersiz sifre yi ilgili kutulara yazin
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        // cikan uyariyi kabul et
        Driver.getDriver().findElement(By.xpath("//*[@id=\"cookieConsentContainer\"]/div[2]/a")).click();

        // login butonuna basin
        qualitydemyPage.loginButonu.click();

        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailKutusu.isEnabled());
        // sayfayi kapatin

        Driver.closeDriver();
    }
}
