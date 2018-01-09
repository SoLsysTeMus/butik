package tests.header;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class HeaderTest extends BaseTest{

   @BeforeMethod
   public void cleanUpSession() {
      clearBrowserCookies();
      clearBrowserCache();
      app.navigation().openUrl(Configuration.baseUrl);
   }

   @Test
   public void testWomenSexSelectedOnGenderBanner(){

      app.banner().selectSexOnGenderBanner("ЖЕНЩИНАМ");

      Assert.assertEquals(app.header().getActiveGender(),"Женщинам");
   }

   @Test
   public void testMenSexSelectedOnGenderBanner(){
      app.banner().selectSexOnGenderBanner("МУЖЧИНАМ");

      Assert.assertEquals(app.header().getActiveGender(),"Мужчинам");
   }

   @Test
   public void testLinkToAboutPage(){
      app.header().gotoAboutPage();

      app.page().pageContainsText(By.cssSelector(".static-about-title"), "универмаг и интернет-магазин");
      app.header().checkAboutLinkIsActive();
   }

   @Test
   public void testOpenSearchForm(){
      app.header().openSearchForm();

      app.header().checkSearchFieldIsVisible();
      app.header().checkSearchButtonIsVisible();
      app.header().checkHintsIsVisible();
   }

   @Test
   public void testPopUpWithEmptyCart(){
      app.header().openPopUpCart();
      app.header().checkCartIsEmpty();
   }
}
