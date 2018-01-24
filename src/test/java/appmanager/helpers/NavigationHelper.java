package appmanager.helpers;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class NavigationHelper extends BaseHelper {

   @Step("Открытие PopUp авторизации")
   public void openAuthorizationPopUp() {
      $x("//div[contains(@class,'user-block fr nowrp')]//div[contains(@class,'dropmenu-root')]").click();
      $(By.id("authPopup")).shouldBe(Condition.visible);
      $(".button.authorization__button.m-login").shouldBe(Condition.visible);
   }

   @Step("Открытие стрианцы /login")
   public void openLoginPage() {
      open(baseUrl + "login");
   }

   @Step("Открытие стрианцы /register")
   public void openRegistrationPage() {
      open(baseUrl + "register");
   }

   @Step("Открытие PopUp регистрации")
   public void openRegistrationPopUpForm() {
      $x("//span[@data-bind='click: register']").click();
      sleep(700);
   }

   @Step("Открытие url")
   public void openUrl(String url) {
      open(url);
   }

   @Step("Открытие стрианцы /checkout")
   public void openCheckoutPage() {
      open(baseUrl + "checkout");
   }

   public void logoutBylink() {
      openUrl(baseUrl + "logout");
   }

   @Step("Открытие стрианцы /wishlist")
   public void openWishListPage() {
      openUrl(baseUrl + "wishlist");
   }
}
