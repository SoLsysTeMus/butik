package appmanager.helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.*;


public class AuthorizationHelper extends BaseHelper {

   @Step("Заполнение полей login и password на форме PopUp")
   public void fillPopUpAuthorizationForm(String login, String password) {
      fillLoginPopUpField(login);
      fillPasswordPopUpField(password);
   }

   @Step("Заполнение полей login и password на странице /login")
   public void fillAuthorizationForm(String login, String password) {
      type(By.xpath("/html/body/div[2]/div[1]/div/div[1]/form/div[1]/input"), login);
      type(By.xpath("//input[@type='password']"), password);
   }

   @Step("Нажатие на кнопку \"Войти\" на форме PopUp и ожидание перезагрузки страницы")
   public void submitPopUpLoginData() {
      click(By.xpath("//div[@id='authPopup']/div[2]/div/div/form/button"));
      waitLoader();
      $(By.xpath("//div[contains(@class,'p-x-sm_0-5 p-x-lg_1 dib hidden-xs')]//a[contains(@href,'wishlist')]")).shouldBe(Condition.visible);
   }

   @Step("Нажатие на кнопку \"Войти\" на станице /login и ожидание перезагрузки страницы")
   public void submitLoginData() {
      click(By.xpath("/html/body/div[2]/div[1]/div/div[1]/form/button"));
      waitLoader();
   }

   @Step("Заполнение поля login на форме PopUp")
   public void fillLoginPopUpField(String login) {
      String formSelector = ".authorization__login-form";
      $(formSelector).$x(".//input[@type='text']").setValue(login).click();
   }

   @Step("Заполнение поля password на форме PopUp")
   public void fillPasswordPopUpField(String password) {
      String formSelector = ".authorization__login-form";
      $(formSelector).$x("//input[@type='password']").setValue(password).click();
   }

   public void closeAuthPopUp() {
      $(".popup__close.arcticmodal-close").click();
   }

   @Step("Клик по кнопке \"Войти\" на форме PopUp")
   public void clickPopUpLoginButton() {
      click(By.xpath("//div[@id='authPopup']/div[2]/div/div/form/button"));
      sleep(300);
   }

   @Step("Проверка отображаения всех эелементов на форме Авторизации")
   public boolean isAllPopUpElementsDisplayed() {
      $(".popup__title").shouldBe(Condition.visible).shouldBe(Condition.text("Вход"));
      $x("//div[@class='authorization m-login']//ul[@class='authorization__social-networks']").shouldBe(Condition.visible);
      $(By.id("js-login-email")).shouldBe(Condition.visible).shouldHave(Condition.attribute("placeholder", "E-mail или номер телефона"));
      $x("//input[@type='password']").shouldBe(Condition.visible).shouldHave(Condition.attribute("placeholder", "Пароль"));
      $x("//span[@data-bind='click: remindPassword']").shouldBe(Condition.visible).shouldHave(Condition.text("Напомнить?"));
      $(".button.authorization__button.m-login").shouldBe(Condition.visible).shouldHave(Condition.text("Войти"));
      $x("//div[@class='authorization__login']//div[@class='m-t-xs_1']").shouldBe(Condition.visible);
      $x("//span[@data-bind='click: register']").shouldBe(Condition.visible);
      return true;
   }

   @Step("Отображения ошибки на форме PopUp")
   public boolean errorIsDisplayedOnPopUpForm(String s) {
      ElementsCollection elements = $$x("//p[contains(@class,'authorization__error')]")
              .filterBy(Condition.visible);
      boolean bool = false;
      for (SelenideElement element : elements) {
         if (element.text().equals(s)) {
            bool = true;
         }
      }
      return bool;
   }
}
