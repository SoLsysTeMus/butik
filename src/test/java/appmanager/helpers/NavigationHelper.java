package appmanager.helpers;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static appmanager.ApplicationManager.getBaseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NavigationHelper extends BaseHelper {

   public void openAuthorizationPopUp() {
      click(By.xpath("//div[contains(@class,'user-block fr nowrp')]//div[contains(@class,'dropmenu-root')]"));
      $(By.id("authPopup")).shouldBe(Condition.visible);
      $(".button.authorization__button.m-login").shouldBe(Condition.visible);
   }

   public void openLoginPage() {
      open(getBaseUrl() + "login");
   }

   public void openRegistrationPage() {
      open(getBaseUrl() + "register");
   }

   public void openRegistrationPopUpForm() {
      click(By.xpath("//*[@id=\"authPopup\"]/div[2]/div[1]/div[2]/span"));
   }

   public void openUrl(String url) {
      open(url);
   }

   public void openCheckoutPage() {
      open(getBaseUrl() + "checkout");
   }

   public void logoutBylink() {
      openUrl(getBaseUrl() + "logout");
   }

   public void openWishlistPage() {
      openUrl(getBaseUrl() + "wishlist");
   }
}
