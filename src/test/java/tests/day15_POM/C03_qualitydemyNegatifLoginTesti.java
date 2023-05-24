package tests.day15_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;

public class C03_qualitydemyNegatifLoginTesti {

    @Test
    public void test01(){
        // QUALITYDEMY ANA SAYFAYA GIDIN
        Driver.getDriver().get("https://www.qualitydemy.com");
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        // login linkine tiklayin
        qualitydemyPage.ilkLoginLinki.click();

        // kullanici adi olarak selenium
        qualitydemyPage.emailKutusu.sendKeys("selenium"+ Keys.ENTER);

        // password olarak heyecandir yazin
        qualitydemyPage.passwordKutusu.sendKeys("heyecandir"+Keys.ENTER);

        Driver.getDriver().findElement(By.xpath("//*[@id=\"cookieConsentContainer\"]/div[2]/a")).click();
        // login butonuna basin
        qualitydemyPage.loginButonu.submit();

        // basarili giris yapilmadigini test edin
        Assert.assertTrue(qualitydemyPage.emailKutusu.isEnabled());

        // sayfayi kapatin
        Driver.closeDriver();
    }
}
