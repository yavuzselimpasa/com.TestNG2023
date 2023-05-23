package tests.day15_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C01_PageIlkTest {

    @Test
    public void amazonTest(){

        // amazon anasayfaya gidelim
        Driver.getdriver().get("https://www.amazon.com");

        // Arama kutusunun locate'i pages sayfasinda
        // POM'de pages sayfasindaki locate'lere erismek icin
        // pages sayfalarindan bir obje olusturulur.
        AmazonPage amazonPage = new AmazonPage();
        // Nutella icin arama yapalim
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // sonuclarin Nutella icerdigini test edelim
        String expectedIcerik = "Nutella";
        String actualSonucYazisi = amazonPage.aramaSonucuElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        // sayfayi kapatalim
        Driver.closeDriver();

    }
}
