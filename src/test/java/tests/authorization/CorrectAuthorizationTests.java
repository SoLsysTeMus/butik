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

      app.navigation().openLoginPage();
      app.authorization().fillAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitLoginData();
      app.header().openPersonalMenu();
      app.personalMenu().gotoProfile();

      Assert.assertEquals(app.userProfile().getProfileEmail(), testLoginEmail);
   }

   @Step("Авторизация через Pop-up")
   @Test
   public void testCorrectAuthorizationPopUp() {

      String testLoginEmail = "auth_test@auth.test";
      String testPassword = "12345";

      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.header().openPersonalMenu();
      app.personalMenu().gotoProfile();

      Assert.assertEquals(app.userProfile().getProfileEmail(), testLoginEmail);
   }


}
