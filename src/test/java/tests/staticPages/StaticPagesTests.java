package tests.staticPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class StaticPagesTests extends BaseTest{


   @Test
   public void testCheckOpenAboutPage(){
      app.footer().gotoStaticPage("Универмаг");
      Assert.assertEquals(app.page().pageContainsText(By.cssSelector(".static-about-title"), "универмаг и интернет-магазин"), true);
   }

   @Test
   public void testCheckOpenContactPage(){
      app.footer().gotoStaticPage("Контакты");
      Assert.assertEquals(app.page().pageContainsText(By.cssSelector(".contacts__title"), "контакты"), true);
   }

   @Test
   public void testCheckOpenDeliveryPage(){
      app.footer().gotoStaticPage("Доставка");
      Assert.assertEquals(app.page().pageContainsText(By.cssSelector(".delivery__title"), "доставка"), true);
   }

   @Test
   public void testCheckOpenRefundPage(){
      app.footer().gotoStaticPage("Возврат");
      Assert.assertEquals(app.page().pageContainsText(By.cssSelector(".return__title"), "возврат"), true);
   }

   @Test
   public void testCheckOpenPromoInformationPage(){
      app.footer().gotoStaticPage("Текущие акции");
      Assert.assertEquals(app.page().pageContainsText(By.cssSelector(".stock__title"), "акции"), true);
   }

   @Test
   public void testCheckOpenClubCardPage(){
      app.footer().gotoStaticPage("Клубная система");
      Assert.assertEquals(app.page().pageContainsText(By.cssSelector(".clubcard__title"), "клубная карта"), true);
   }

   @Test
   public void testCheckOpenCertificatesPage(){
      app.footer().gotoStaticPage("Сертификаты");
      Assert.assertEquals(app.page().pageContainsText(By.cssSelector(".certificates__title"), "сертификат"), true);
   }

   @Test
   public void testCheckOpenSizesTablePage(){
      app.footer().gotoStaticPage("Таблица размеров");
      Assert.assertEquals(app.page().pageContainsText(By.cssSelector(".main-title"), "таблица размеров"), true);
   }

   @Test
   public void testCheckOpenHelpfulInfoPage(){
      app.footer().gotoStaticPage("Полезная информация");
      Assert.assertEquals(app.page().pageContainsText(By.xpath("//h3[contains(text(),'Полезная информация')]"), "полезная информация"), true);
   }

   @Test
   public void testCheckOpenFeedbackPage(){
      app.footer().gotoStaticPage("Задать вопрос");
      Assert.assertEquals(app.page().pageContainsText(By.cssSelector(".feedback__title"), "задать вопрос или оставить отзыв"), true);
   }

   @Test
   public void testCheckOpenReviewsOnYandexPage(){
      app.footer().gotoStaticPage("Отзывы на");
      Assert.assertEquals(app.page().getLinkForLocator(By.xpath("//a[contains(text(),'Отзывы на')]")), "https://market.yandex.ru/shop/1818/reviews");
   }

   @Test
   public void testCheckOpenOfferPage(){
      app.footer().gotoStaticPage("Оферта");
      Assert.assertEquals(app.page().pageContainsText(By.cssSelector(".offer__title"), "оферта"), true);
   }

   @Test
   public void testCheckOpenInstashopPage(){
      app.footer().gotoStaticPage("Instashop");
      Assert.assertEquals(app.page().pageContainsText(By.cssSelector(".fotoshmoto-heading"), "instashop"), true);
   }
}
