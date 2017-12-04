package tests.authorization;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CorrectAuthorizationTests extends BaseTest {

   @Test
   public void testCorrectAuthorization(){

       String testLoginEmail = "butik.tester@bk.ru";
       String testPassword = "!Q2w3e4r5t6y";

      app.getNavigationHelper().openLoginPage();
      app.getAuthorizationHelper().fillAuthorizationForm(testLoginEmail, testPassword);
      app.getAuthorizationHelper().submitLoginData();
      app.getNavigationHelper().gotoProfile();

      Assert.assertEquals(app.getUserProfileHelper().getProfileEmail(),testLoginEmail);
   }



}
