package tests.day18_TestNGReports_ParalelCalistirma;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluAmazonSearch extends TestBaseRapor {

    @Test
    public void test01(){
        extentTest=extentReports.createTest("Amazon Arama Testi",
                                           "kullanici istedigi kelimeyi aratabilmeli");

        // amazon'a gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("kullanici amazon anasayfaya gider");

        // Nutella icin arama yapin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);
        extentTest.info("arama kutusunu istenilen kelimeyi yazar ve aratir");

        // arama sonuclarinin Nutella icerdigini test edin
        String expectedIcerik= ConfigReader.getProperty("amazonExpectedIcerik");
        String actualSonuzYazisi = amazonPage.aramaSonucuElementi.getText();
        Assert.assertTrue(actualSonuzYazisi.contains(expectedIcerik));
        extentTest.pass("belirnen kelime expected icerik oldugu test edildi");

        // sayfayi kapatin
        Driver.closeDriver();
    }
}
