package tests.authorization;

import org.testng.annotations.Test;
import tests.BaseTest;

public class CorrectAuthorizationTests extends BaseTest {

   @Test
   public void testCorrectAuthorization(){

      app.getNavigationHelper().openLoginPage();
      app.getAuthorizationHelper().fillAuthorizationForm("volkovsky@ros-it.ru", "Parlament1987");
      app.getAuthorizationHelper().submitLoginData();
      app.getNavigationHelper().gotoProfile();
   }



}
