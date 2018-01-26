package tests.authorization;

import org.testng.Assert;
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

      Assert.assertTrue(app.authorization().isAllPopUpElementsDisplayed());
   }

   @Severity(SeverityLevel.MINOR)
   @Title("Авторизация через страницу /login")
   @Test
   public void testCorrectAuthorization() {

      String login = testDataProperties.getProperty("authDataLogin");
      String password = testDataProperties.getProperty("authDataPassword");
      String name = testDataProperties.getProperty("authDataName");

      app.navigation().openLoginPage();
      app.authorization().fillAuthorizationForm(login, password);
      app.authorization().submitLoginData();
      app.header().checkUserName(name);
   }

   @Severity(SeverityLevel.CRITICAL)
   @Title("Авторизация через Pop-Up")
   @Test
   public void testCorrectAuthorizationPopUp() {

      String login = testDataProperties.getProperty("authDataLogin");
      String password = testDataProperties.getProperty("authDataPassword");
      String name = testDataProperties.getProperty("authDataName");

      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(login, password);
      app.authorization().submitPopUpLoginData();
      app.header().checkUserName(name);
   }


   @Severity(SeverityLevel.MINOR)
   @Title("Авторизация через страницу /login используя номер телефона")
   @Test
   public void testCorrectAuthorizationByPhone() {

      String login = testDataProperties.getProperty("authPhoneDataLogin");
      String password = testDataProperties.getProperty("authPhoneDataPassword");
      String name = testDataProperties.getProperty("authPhoneDataName");

      app.navigation().openLoginPage();
      app.authorization().fillAuthorizationForm(login, password);
      app.authorization().submitLoginData();
      app.header().checkUserName(name);
   }

   @Severity(SeverityLevel.CRITICAL)
   @Title("Авторизация через Pop-Up используя номер телефона")
   @Test
   public void testCorrectAuthorizationPopUpByPhone() {

      String login = testDataProperties.getProperty("authPhoneDataLogin");
      String password = testDataProperties.getProperty("authPhoneDataPassword");
      String name = testDataProperties.getProperty("authPhoneDataName");

      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(login, password);
      app.authorization().submitPopUpLoginData();
      app.header().checkUserName(name);
   }

}
