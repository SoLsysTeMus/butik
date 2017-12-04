package tests.catalog;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;


public class CatalogPositiveTests extends BaseTest{

   @Test
   public void testCatalogItemCountAboveZero(){
      app.getMainMenuHelper().gotoSubcategory(By.xpath("//header/div[2]/div[4]/nav[1]/div[2]"), By.linkText("Верхняя одежда"));

      Assert.assertNotEquals(app.getCatalogHelper().getProductsCountInCategory(),0);
   }
}