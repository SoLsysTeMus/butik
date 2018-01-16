package tests.authorization;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;

@Features("Авторизация")
public class AuthorizationTests extends BaseTest {

   @BeforeMethod
   public void cleanUpSession() {
      app.navigation().openUrl(baseUrl);
   }

   @Severity(SeverityLevel.CRITICAL)
   @Title("Проверка отображения элементов формы")
   @Test
   public void testAuthorizationPopUpElementIsVisible() {
      app.navigation().openAuthorizationPopUp();

      app.authorization().checkAllPopUpElementsIsDisplayed();
   }

   @Severity(SeverityLevel.MINOR)
   @Title("Авторизация через страницу /login")
   @Test
   public void testCorrectAuthorization() {

      String testLoginEmail = "auth_test@auth.test";
      String testPassword = "12345";
      String name = "authtest";

      app.navigation().openLoginPage();
      app.authorization().fillAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitLoginData();
      app.header().checkUserName(name);
   }

   @Severity(SeverityLevel.CRITICAL)
   @Title("Авторизация через Pop-Up")
   @Test
   public void testCorrectAuthorizationPopUp() {

      String testLoginEmail = "auth_test@auth.test";
      String testPassword = "12345";
      String name = "authtest";

      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.header().checkUserName(name);
   }


   @Severity(SeverityLevel.MINOR)
   @Title("Авторизация через страницу /login используя номер телефона")
   @Test
   public void testCorrectAuthorizationByPhone() {

      String testLoginEmail = "9645388080";
      String testPassword = "12345";
      String name = "test";

      app.navigation().openLoginPage();
      app.authorization().fillAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitLoginData();
      app.header().checkUserName(name);
   }

   @Severity(SeverityLevel.CRITICAL)
   @Title("Авторизация через Pop-Up используя номер телефона")
   @Test
   public void testCorrectAuthorizationPopUpByPhone() {

      String testLoginEmail = "9645388080";
      String testPassword = "12345";
      String name = "test";

      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.header().checkUserName(name);
   }

}
