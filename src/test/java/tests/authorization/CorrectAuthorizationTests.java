package tests.authorization;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

import static appmanager.ApplicationManager.baseUrl;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class CorrectAuthorizationTests extends BaseTest {

   @BeforeMethod
   public void cleanUpSession() {
      clearBrowserCookies();
      clearBrowserCache();
      open(baseUrl);
   }

   @Test
   public void testCorrectAuthorization() {

      String testLoginEmail = "auth_test@auth.test";
      String testPassword = "12345";

      app.navigation().openLoginPage();
      app.authorization().fillAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitLoginData();
      app.header().openPersonalMenu();
      app.personalMenu().gotoProfile();

      app.userProfile().checkProfileEmail(testLoginEmail);
   }


   @Test
   public void testCorrectAuthorizationPopUp() {

      String testLoginEmail = "auth_test@auth.test";
      String testPassword = "12345";

      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.header().openPersonalMenu();
      app.personalMenu().gotoProfile();

      app.userProfile().checkProfileEmail(testLoginEmail);
   }


}
