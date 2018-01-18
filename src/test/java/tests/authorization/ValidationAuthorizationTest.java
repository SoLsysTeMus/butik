package tests.authorization;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import tests.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;

@Features("Валидация полей формы авторизации")
public class ValidationAuthorizationTest extends BaseTest {

   @Test
   @Title("Обязательность заполнения полей формы авторизации")
   public void testAllFieldsIsEmpty() {
      app.navigation().openUrl(baseUrl);
      app.navigation().openAuthorizationPopUp();
      app.authorization().clickPopUpLoginButton();

      Assert.assertEquals(app.authorization().errorIsDisplayedOnPopUpForm("Введите е-mail или номер телефона"), true);
      Assert.assertEquals(app.authorization().errorIsDisplayedOnPopUpForm("Введите пароль"), true);
   }

   @Test
   @Title("Обязательность заполнения поля Login формы авторизации")
   public void testLoginFieldIsEmpty() {
      app.navigation().openUrl(baseUrl);
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPasswordPopUpField("12345");
      app.authorization().clickPopUpLoginButton();

      Assert.assertEquals(app.authorization().errorIsDisplayedOnPopUpForm("Введите е-mail или номер телефона"), true);
      Assert.assertEquals(app.authorization().errorIsDisplayedOnPopUpForm("Введите пароль"), false);

   }

   @Test
   @Title("Обязательность заполнения поля Password формы авторизации")
   public void testPasswordFieldIsEmpty() {
      app.navigation().openUrl(baseUrl);
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillLoginPopUpField("test@test.ru");
      app.authorization().clickPopUpLoginButton();

      Assert.assertEquals(app.authorization().errorIsDisplayedOnPopUpForm("Введите е-mail или номер телефона"), false);
      Assert.assertEquals(app.authorization().errorIsDisplayedOnPopUpForm("Введите пароль"), true);
   }

   @Test
   @Title("Проверка коммуникаци при неверной паре login и pass формы авторизации")
   public void testPasswordIsNotValidMessage() {
      app.navigation().openUrl(baseUrl);
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm("test2@test2.ru", "12345");
      app.authorization().clickPopUpLoginButton();

      Assert.assertEquals(app.authorization().errorIsDisplayedOnPopUpForm("Имя пользователя и пароль не совпадают."), true);
      Assert.assertEquals(app.authorization().errorIsDisplayedOnPopUpForm("Введите пароль"), false);
   }

   @Test
   @Title("Проверка блокировки авторизации при 3-х попытках с невалидными данными")
   public void testBlockWithManyLoginError() {
      app.navigation().openUrl(baseUrl);
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm("test1@test1.ru", "12345");
      app.authorization().clickPopUpLoginButton();
      app.authorization().clickPopUpLoginButton();
      app.authorization().clickPopUpLoginButton();
      app.authorization().clickPopUpLoginButton();

      Assert.assertEquals(app.authorization().errorIsDisplayedOnPopUpForm("Слишком много попыток входа. Повторите вход позже."), true);
      Assert.assertEquals(app.authorization().errorIsDisplayedOnPopUpForm("Введите пароль"), false);
   }

}
