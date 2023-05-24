package tests.day16_POM_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DriverClassSonHali {

    // 3 tane test methodu olusturalim
    @Test
    public void amazonTest(){
        // 1. method'da amazon'a gidip, url'in amazon icerdigini test edin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        String expectedicerik= "amazon";
        String actualicerik = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualicerik.contains(expectedicerik));
        Driver.closeDriver();
    }

    // 2. method'da Wisequarter anasayfaya gidip, title'in Wise Quarter icerdigini test edin

    @Test
    public void wiseTest(){
        Driver.getDriver().get(ConfigReader.getProperty("wiseUrl"));
        String expectedIcerik= "Wise Quarter";
        String actualTitle= Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));
        Driver.closeDriver();
    }

    // 3. method'da facebook anasayfaya gidip, title'in Facebook icerdigini test edin
    @Test
    public void facebookTest(){
        Driver.getDriver().get(ConfigReader.getProperty("faceUrl"));
        String expectedIcerik = "Facebook";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));
        Driver.closeDriver();
    }
    // her method'da yeni driver olusturup, method sonunda driver'i kapatin

}
