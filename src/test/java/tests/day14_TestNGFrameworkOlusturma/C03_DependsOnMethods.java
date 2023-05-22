package tests.day14_TestNGFrameworkOlusturma;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
public class C03_DependsOnMethods {

    /*
      --> DependsOnmethods oncelik sirasina karismaz

      --> DependsOnMethods bir test method'un calismasini baska bir method'un calisip
          passed olmasina baglar

      --> Baglanilan method calismaz veya calisir ama
          failed olursa baglanan method hic calismaz
     */

    @Test(dependsOnMethods = "wiseTesti")
    public void youtubeTesti(){
        System.out.println("Youtube");
    }
    @Test(priority = 5)
    public void wiseTesti(){
        System.out.println("Wise Quarter");
    }
    @Test(dependsOnMethods = "youtubeTesti")
    public void amazonTesti(){ // priority yazilmazsa 0 degeri alir
        System.out.println("Amazon");
    }
}

