package tests.catalog;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;


public class CatalogTests extends BaseTest {

   @Test
   public void testCatalogItemCountAboveZero() {
      app.navigation().openUrl(baseUrl);
      app.mainMenu().gotoSubcategory(By.xpath("//a[contains( text(),'Одежда')]"), By.linkText("Верхняя одежда"));
      System.out.println("test");
      Assert.assertNotEquals(app.catalog().getProductsCountInCategory(), 0);
   }
}
