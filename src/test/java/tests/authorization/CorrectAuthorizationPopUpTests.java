package tests.authorization;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CorrectAuthorizationPopUpTests extends BaseTest {


   @Test
   public void testCorrectAuthorizationPopUp(){

      String testLoginEmail = "butik.tester@bk.ru";
      String testPassword = "!Q2w3e4r5t6y";

      app.getNavigationHelper().openAuthorizationPopUp();
      app.getAuthorizationHelper().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.getAuthorizationHelper().submitPopUpLoginData();
      app.getNavigationHelper().gotoProfile();

      Assert.assertEquals(app.getUserProfileHelper().getProfileEmail(),testLoginEmail);
   }



}
