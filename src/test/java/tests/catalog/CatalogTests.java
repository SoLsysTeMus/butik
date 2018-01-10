package tests.catalog;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

@Features("Каталог")
public class CatalogTests extends BaseTest {

   @BeforeMethod
   public void cleanUpSession() {
      clearBrowserCookies();
      clearBrowserCache();
      app.navigation().openUrl(Configuration.baseUrl);
   }

   @Severity(SeverityLevel.BLOCKER)
   @Features("Количество товаров в категории > 0")
   @Test
   public void testCatalogItemCountAboveZero() {
      app.navigation().openUrl(baseUrl);
      app.mainMenu().gotoSubcategory(By.xpath("//a[contains( text(),'Одежда')]"), By.linkText("Верхняя одежда"));
      Assert.assertNotEquals(app.catalog().getProductsCountInCategory(), 0);
   }
}
