package tests.staticPages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.BaseTest;

import static ru.yandex.qatools.allure.model.SeverityLevel.*;

@Features("Статические страницы")
public class StaticPagesTests extends BaseTest {

   @Title("Доступность страницы \"Универмаг\"")
   @Severity(NORMAL)
   @Test
   public void testCheckOpenAboutPage() {
      app.footer().gotoStaticPage("Универмаг");
      app.page().pageContainsText(By.cssSelector(".static-about-title"), "универмаг и интернет-магазин");
   }

   @Title("Доступность страницы \"Контакты\"")
   @Severity(NORMAL)
   @Test
   public void testCheckOpenContactPage() {
      app.footer().gotoStaticPage("Контакты");
      app.page().pageContainsText(By.cssSelector(".contacts__title"), "контакты");
   }

   @Title("Доступность страницы \"Доставка\"")
   @Severity(NORMAL)
   @Test
   public void testCheckOpenDeliveryPage() {
      app.footer().gotoStaticPage("Доставка");
      app.page().pageContainsText(By.cssSelector(".delivery__title"), "доставка");
   }

   @Title("Доступность страницы \"Возврат\"")
   @Severity(NORMAL)
   @Test
   public void testCheckOpenRefundPage() {
      app.footer().gotoStaticPage("Возврат");
      app.page().pageContainsText(By.cssSelector(".return__title"), "возврат");
   }

   @Title("Доступность страницы \"Текущие акции\"")
   @Severity(NORMAL)
   @Test
   public void testCheckOpenPromoInformationPage() {
      app.footer().gotoStaticPage("Текущие акции");
      app.page().pageContainsText(By.cssSelector(".stock__title"), "акции");
   }

   @Title("Доступность страницы \"Клубная система\"")
   @Severity(NORMAL)
   @Test
   public void testCheckOpenClubCardPage() {
      app.footer().gotoStaticPage("Клубная система");
      app.page().pageContainsText(By.cssSelector(".clubcard__title"), "клубная карта");
   }

   @Title("Доступность страницы \"Сертификаты\"")
   @Severity(NORMAL)
   @Test
   public void testCheckOpenCertificatesPage() {
      app.footer().gotoStaticPage("Сертификаты");
      app.page().pageContainsText(By.cssSelector(".certificates__title"), "сертификат");
   }

   @Title("Доступность страницы \"Таблица размеров\"")
   @Severity(NORMAL)
   @Test
   public void testCheckOpenSizesTablePage() {
      app.footer().gotoStaticPage("Таблица размеров");
      app.page().pageContainsText(By.cssSelector(".main-title"), "таблица размеров");
   }

   @Title("Доступность страницы \"Полезная информация\"")
   @Severity(NORMAL)
   @Test
   public void testCheckOpenHelpfulInfoPage() {
      app.footer().gotoStaticPage("Полезная информация");
      app.page().pageContainsText(By.xpath("//h3[contains(text(),'Полезная информация')]"), "полезная информация");
   }

   @Title("Доступность страницы \"Задать вопрос\"")
   @Severity(NORMAL)
   @Test
   public void testCheckOpenFeedbackPage() {
      app.footer().gotoStaticPage("Задать вопрос");
      app.page().pageContainsText(By.cssSelector(".feedback__title"), "задать вопрос или оставить отзыв");
   }

   @Title("Доступность страницы \"Отзывы на Яндекс\"")
   @Severity(NORMAL)
   @Test
   public void testCheckOpenReviewsOnYandexPage() {
      app.footer().gotoStaticPage("Отзывы на");
      app.page().locatorContainsLink(By.xpath("//a[contains(text(),'Отзывы на')]"), "https://market.yandex.ru/shop/1818/reviews");
   }

   @Title("Доступность страницы \"Оферта\"")
   @Severity(NORMAL)
   @Test
   public void testCheckOpenOfferPage() {
      app.footer().gotoStaticPage("Оферта");
      app.page().pageContainsText(By.cssSelector(".offer__title"), "оферта");
   }

   @Title("Доступность страницы \"Instashop\"")
   @Severity(NORMAL)
   @Test
   public void testCheckOpenInstashopPage() {
      app.footer().gotoStaticPage("Instashop");
      app.page().pageContainsText(By.cssSelector(".fotoshmoto-heading"), "instashop");
   }
}
