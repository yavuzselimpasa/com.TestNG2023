package tests.day14_TestNGFrameworkOlusturma;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_DriverIlkTest {

    @Test
    public void test01(){

        // amazon sayfasına gidin
        Driver.getdriver().get("https://www.amazon.com");

        // Nutella icin arama yapin
        WebElement aramaKutusu = Driver.getdriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // arama sonuclarinin Nutella kelimesi icerdigini test edin
        WebElement sonucElemnti=Driver.getdriver().findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        String expectedIcerik = "Nutella";
        String actualIcerik = sonucElemnti.getText();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

        ReusableMethods.bekle(5);
        Driver.closeDriver();

    }
}
