package tests.authorization;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class CorrectAuthorizationTests extends BaseTest {

   @BeforeMethod
   public void cleanUpSession() {
      clearBrowserCookies();
      clearBrowserCache();
      app.navigation().openUrl(Configuration.baseUrl);
   }

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


}
