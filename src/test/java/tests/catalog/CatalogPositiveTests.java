package tests.catalog;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.testng.Assert.assertTrue;

public class CatalogPositiveTests extends BaseTest{

   @Test
   public void testCatalogCounter(){
      app.getMainMenuHelper().gotoSubcategory(By.xpath("//header/div[2]/div[4]/nav[1]/div[2]"), By.linkText("Верхняя одежда"));


      try {
         Thread.sleep(4000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
