package tests.authorization;

import org.testng.annotations.Test;
import tests.BaseTest;

public class CorrectAuthorizationPopUpTests extends BaseTest {

   @Test
   public void testCorrectAuthorizationPopUp(){

      app.getNavigationHelper().openAuthorizationPopUp();
      app.getAuthorizationHelper().fillPopUpAuthorizationForm("volkovsky@ros-it.ru", "Parlament1987");
      app.getAuthorizationHelper().submitPopUpLoginData();
      app.getNavigationHelper().gotoProfile();
   }



}
