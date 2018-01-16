package appmanager.helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class AuthorizationHelper extends BaseHelper {


   public void fillPopUpAuthorizationForm(String login, String password) {
      fillLoginPopUpField(login);
      fillPasswordPopUpField(password);
   }

   public void fillAuthorizationForm(String login, String password) {
      type(By.xpath("/html/body/div[2]/div[1]/div/div[1]/form/div[1]/input"), login);
      type(By.xpath("//input[@type='password']"), password);
   }

   public void submitPopUpLoginData() {
      click(By.xpath("//div[@id='authPopup']/div[2]/div/div/form/button"));
      waitLoader();
      $(By.xpath("//div[contains(@class,'p-x-sm_0-5 p-x-lg_1 dib hidden-xs')]//a[contains(@href,'wishlist')]")).shouldBe(Condition.visible);
   }

   public void submitLoginData() {
      click(By.xpath("/html/body/div[2]/div[1]/div/div[1]/form/button"));
      waitLoader();
   }

   public void fillLoginPopUpField(String login) {
      $(By.cssSelector(".authorization__login-form")).$x(".//input[@type='text']").setValue(login);
   }

   public void fillPasswordPopUpField(String password) {
      $(By.cssSelector(".authorization__login-form")).$x("//input[@type='password']").setValue(password);
   }

   public void closeAuthPopUp() {
      $(".popup__close.arcticmodal-close").click();
   }

   public void clickPopUpLoginButton() {
      click(By.xpath("//div[@id='authPopup']/div[2]/div/div/form/button"));
      sleep(300);
   }

   public void checkAllPopUpElementsIsDisplayed() {
      $(".popup__title").shouldBe(Condition.visible).shouldBe(Condition.text("Вход"));
      $x("//div[@class='authorization m-login']//ul[@class='authorization__social-networks']").shouldBe(Condition.visible);
      $(By.id("js-login-email")).shouldBe(Condition.visible).shouldHave(Condition.attribute("placeholder", "E-mail или номер телефона"));
      $x("//input[@type='password']").shouldBe(Condition.visible).shouldHave(Condition.attribute("placeholder", "Пароль"));
      $x("//span[@data-bind='click: remindPassword']").shouldBe(Condition.visible).shouldHave(Condition.text("Напомнить?"));
      $(".button.authorization__button.m-login").shouldBe(Condition.visible).shouldHave(Condition.text("Войти"));
      $x("//div[@class='authorization__login']//div[@class='m-t-xs_1']").shouldBe(Condition.visible);
      $x("//span[@data-bind='click: register']").shouldBe(Condition.visible);
   }

   public boolean errorIsDisplayed(String s) {
      ElementsCollection elements = $$x("//p[contains(@class,'authorization__error')]");
      boolean bool = false;
      for (SelenideElement element : elements) {
         if (element.text().equals(s)) {
            bool = true;
         }
      }
      return bool;
   }
}
