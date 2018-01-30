package tests.search;

import model.ProductData;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;
import static ru.yandex.qatools.allure.model.SeverityLevel.*;

@Features("Поиск")
public class SearchTests extends BaseTest {

   @Title("Поиск товара по названию")
   @Severity(CRITICAL)
   @Test
   public void searchByName() {
      app.navigation().openUrl(baseUrl);
      app.header().openSearchForm();
      app.header().fillSearchField("Джинсы");
      app.header().pressSearchButton();

      Assert.assertNotEquals(app.search().getItemsCount(), 0);
   }

   @Title("Поиск товара по неполному SKU")
   @Severity(CRITICAL)
   @Test
   public void searchByPartOfSKU() {
      app.navigation().openUrl(baseUrl);
      app.header().openSearchForm();
      app.header().fillSearchField("0051");
      app.header().pressSearchButton();

      Assert.assertNotEquals(app.search().getItemsCount(), 0);
   }

   @Title("Поиск товара по SKU")
   @Severity(CRITICAL)
   @Test
   public void searchBySku() {
      app.navigation().openUrl(baseUrl);
      app.header().openSearchForm();
      app.header().fillSearchField("Mobil black");
      app.header().pressSearchButton();
      ProductData product = app.productCard().getProductData();

      Assert.assertEquals(product.getSku(), "Mobil black");
   }

   @Title("Поиск товара по SKU включающего спецсимвол")
   @Severity(CRITICAL)
   @Test
   public void searchBySkuWithSpecialChar() {
      app.navigation().openUrl(baseUrl);
      app.header().openSearchForm();
      app.header().fillSearchField("0VO5032S W44/1154");
      app.header().pressSearchButton();
      ProductData product = app.productCard().getProductData();

      Assert.assertEquals(product.getSku(), "0VO5032S W44/1154");
   }

   @Title("Поиск товара по Brand name включающего спецсимвол")
   @Severity(CRITICAL)
   @Test
   public void searchByBrandNameWithSpecialChar() {
      app.navigation().openUrl(baseUrl);
      app.header().openSearchForm();
      app.header().fillSearchField("LEVI’S®");
      app.header().pressSearchButton();

      Assert.assertNotEquals(app.search().getItemsCount(), 0);
   }

}


