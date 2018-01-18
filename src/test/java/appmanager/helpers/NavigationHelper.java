package appmanager.helpers;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class NavigationHelper extends BaseHelper {

   public void openAuthorizationPopUp() {
      $("//div[contains(@class,'user-block fr nowrp')]//div[contains(@class,'dropmenu-root')]").click();
      $(By.id("authPopup")).shouldBe(Condition.visible);
      $(".button.authorization__button.m-login").shouldBe(Condition.visible);
   }

   public void openLoginPage() {
      open(baseUrl + "login");
   }

   public void openRegistrationPage() {
      open(baseUrl + "register");
   }

   public void openRegistrationPopUpForm() {
      $x("//span[@data-bind='click: register']").click();
      sleep(700);
   }

   public void openUrl(String url) {
      open(url);
   }

   public void openCheckoutPage() {
      open(baseUrl + "checkout");
   }

   public void logoutBylink() {
      openUrl(baseUrl + "logout");
   }

   public void openWishListPage() {
      openUrl(baseUrl + "wishlist");
   }
}
