package tests.staticPages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;

public class StaticPagesTests extends BaseTest {


   @Test
   public void testCheckOpenAboutPage() {
      app.footer().gotoStaticPage("Универмаг");
      app.page().pageContainsText(By.cssSelector(".static-about-title"), "универмаг и интернет-магазин");
   }

   @Test
   public void testCheckOpenContactPage() {
      app.footer().gotoStaticPage("Контакты");
      app.page().pageContainsText(By.cssSelector(".contacts__title"), "контакты");
   }

   @Test
   public void testCheckOpenDeliveryPage() {
      app.footer().gotoStaticPage("Доставка");
      app.page().pageContainsText(By.cssSelector(".delivery__title"), "доставка");
   }

   @Test
   public void testCheckOpenRefundPage() {
      app.footer().gotoStaticPage("Возврат");
      app.page().pageContainsText(By.cssSelector(".return__title"), "возврат");
   }

   @Test
   public void testCheckOpenPromoInformationPage() {
      app.footer().gotoStaticPage("Текущие акции");
      app.page().pageContainsText(By.cssSelector(".stock__title"), "акции");
   }

   @Test
   public void testCheckOpenClubCardPage() {
      app.footer().gotoStaticPage("Клубная система");
      app.page().pageContainsText(By.cssSelector(".clubcard__title"), "клубная карта");
   }

   @Test
   public void testCheckOpenCertificatesPage() {
      app.footer().gotoStaticPage("Сертификаты");
      app.page().pageContainsText(By.cssSelector(".certificates__title"), "сертификат");
   }

   @Test
   public void testCheckOpenSizesTablePage() {
      app.footer().gotoStaticPage("Таблица размеров");
      app.page().pageContainsText(By.cssSelector(".main-title"), "таблица размеров");
   }

   @Test
   public void testCheckOpenHelpfulInfoPage() {
      app.footer().gotoStaticPage("Полезная информация");
      app.page().pageContainsText(By.xpath("//h3[contains(text(),'Полезная информация')]"), "полезная информация");
   }

   @Test
   public void testCheckOpenFeedbackPage() {
      app.footer().gotoStaticPage("Задать вопрос");
      app.page().pageContainsText(By.cssSelector(".feedback__title"), "задать вопрос или оставить отзыв");
   }

   @Test
   public void testCheckOpenReviewsOnYandexPage() {
      app.footer().gotoStaticPage("Отзывы на");
      app.page().locatorContainsLink(By.xpath("//a[contains(text(),'Отзывы на')]"), "https://market.yandex.ru/shop/1818/reviews");
   }

   @Test
   public void testCheckOpenOfferPage() {
      app.footer().gotoStaticPage("Оферта");
      app.page().pageContainsText(By.cssSelector(".offer__title"), "оферта");
   }

   @Test
   public void testCheckOpenInstashopPage() {
      app.footer().gotoStaticPage("Instashop");
      //p.page().pageContainsText(By.cssSelector(".fotoshmoto-heading"), "instashop");
   }
}
