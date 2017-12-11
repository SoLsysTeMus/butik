package tests.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;


public class CatalogPositiveTests extends BaseTest {

   @Test
   public void testCatalogItemCountAboveZero() {
      app.getMainMenuHelper().gotoSubcategory(By.xpath("//a[contains( text(),'Одежда')]"), By.linkText("Верхняя одежда"));
      System.out.println("test");
      Assert.assertNotEquals(app.getCatalogHelper().getProductsCountInCategory(), 0);
   }
}
