package tests.authorization;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;
import tests.BaseTest;

public class CorrectAuthorizationTests extends BaseTest {

   @Step("Авторизация с cтраницы /login")
   @Test
   public void testCorrectAuthorization() {

      String testLoginEmail = "auth_test@auth.test";
      String testPassword = "12345";

      app.getNavigationHelper().openLoginPage();
      app.getAuthorizationHelper().fillAuthorizationForm(testLoginEmail, testPassword);
      app.getAuthorizationHelper().submitLoginData();
      app.getHeaderHelper().openPersonalMenu();
      app.getPersonalMenuHelper().gotoProfile();

      Assert.assertEquals(app.getUserProfileHelper().getProfileEmail(), testLoginEmail);
   }

   @Step("Авторизация через Pop-up")
   @Test
   public void testCorrectAuthorizationPopUp() {

      String testLoginEmail = "auth_test@auth.test";
      String testPassword = "12345";

      app.getNavigationHelper().openAuthorizationPopUp();
      app.getAuthorizationHelper().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.getAuthorizationHelper().submitPopUpLoginData();
      app.getHeaderHelper().openPersonalMenu();
      app.getPersonalMenuHelper().gotoProfile();

      Assert.assertEquals(app.getUserProfileHelper().getProfileEmail(), testLoginEmail);
   }


}
