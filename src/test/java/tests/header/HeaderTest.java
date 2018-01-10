package tests.header;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

@Features("Хедер")
public class HeaderTest extends BaseTest {

   @BeforeMethod
   public void cleanUpSession() {
      clearBrowserCookies();
      clearBrowserCache();
      app.navigation().openUrl(Configuration.baseUrl);
   }

   @Title("Выбран женский пол на разводящей")
   @Severity(SeverityLevel.NORMAL)
   @Test
   public void testWomenSexSelectedOnGenderBanner() {

      app.banner().selectSexOnGenderBanner("ЖЕНЩИНАМ");

      Assert.assertEquals(app.header().getActiveGender(), "Женщинам");
   }

   @Title("Выбран мужской пол на разводящей")
   @Severity(SeverityLevel.NORMAL)
   @Test
   public void testMenSexSelectedOnGenderBanner() {
      app.banner().selectSexOnGenderBanner("МУЖЧИНАМ");

      Assert.assertEquals(app.header().getActiveGender(), "Мужчинам");
   }

   @Title("Индикация ссылки \"О универмаге\" на странице /about")
   @Severity(SeverityLevel.NORMAL)
   @Test
   public void testLinkToAboutPage() {
      app.header().gotoAboutPage();

      app.page().pageContainsText(By.cssSelector(".static-about-title"), "универмаг и интернет-магазин");
      app.header().checkAboutLinkIsActive();
   }

   @Title("Открытие формы поиска и отображение элементов")
   @Severity(SeverityLevel.NORMAL)
   @Test
   public void testOpenSearchForm() {
      app.header().openSearchForm();

      app.header().checkSearchFieldIsVisible();
      app.header().checkSearchButtonIsVisible();
      app.header().checkHintsIsVisible();
   }

   @Title("Pop-up для пустой корзины")
   @Severity(SeverityLevel.NORMAL)
   @Test
   public void testPopUpWithEmptyCart() {
      app.header().openPopUpCart();
      app.header().checkCartIsEmpty();
   }
}
