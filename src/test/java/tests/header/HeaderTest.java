package tests.header;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static ru.yandex.qatools.allure.model.SeverityLevel.*;

@Features("Хедер")
public class HeaderTest extends BaseTest {

   @BeforeMethod
   public void cleanUpSession() {
      app.navigation().openUrl(baseUrl);
   }


   @Title("Выбран женский пол на разводящей")
   @Severity(NORMAL)
   @Test
   public void testWomenSexSelectedOnGenderBanner() {
      app.banner().selectSexOnGenderBanner("ЖЕНЩИНАМ");

      Assert.assertEquals(app.header().getActiveGender(), "Женщинам");
   }

   @Title("Выбран мужской пол на разводящей")
   @Severity(NORMAL)
   @Test
   public void testMenSexSelectedOnGenderBanner() {
      app.banner().selectSexOnGenderBanner("МУЖЧИНАМ");

      Assert.assertEquals(app.header().getActiveGender(), "Мужчинам");
   }


   @Title("Отображение logo в хедере")
   @Severity(CRITICAL)
   @Test
   public void testLogoIsVisible() {
      app.navigation().openUrl(baseUrl);

      assertTrue($x("//header//a//img").isImage());
   }

   @Title("Отображение картинок для баннера на разводящей")
   @Severity(CRITICAL)
   @Test
   public void testImagesIsVisibleOnGenderBanner() {
      app.navigation().openUrl(baseUrl);

      assertTrue($$x("//a[@class='b-frame']//img[@class='b-pic hidden-xs']").get(0).isImage());
      assertTrue($$x("//a[@class='b-frame']//img[@class='b-pic hidden-xs']").get(1).isImage());
   }

   @Title("Индикация ссылки \"О универмаге\" на странице /about")
   @Severity(NORMAL)
   @Test
   public void testLinkToAboutPage() {
      app.header().gotoAboutPage();

      app.page().pageContainsText(By.cssSelector(".static-about-title"), "универмаг и интернет-магазин");
      assertTrue(app.header().isAboutLinkActive());
   }

   @Title("Открытие формы поиска и отображение элементов")
   @Severity(NORMAL)
   @Test
   public void testOpenSearchForm() {
      app.header().openSearchForm();

      assertTrue(app.header().isSearchFieldVisible());
      assertTrue(app.header().isSearchButtonVisible());
      assertNotEquals(app.header().getHintsCount(), 0);
   }

   @Title("Pop-up для пустой корзины")
   @Severity(NORMAL)
   @Test
   public void testPopUpWithEmptyCart() {
      app.header().openPopUpCart();
      app.header().checkCartIsEmpty();
   }

   @Title("Отображение кол-ва товаров в wishlist")
   @Severity(CRITICAL)
   @Test
   public void testWishListCounterVisibleInHeader() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";

      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.navigation().openWishListPage();

      assertNotEquals(app.header().getWishlistItemscount(), 0);
   }
}
