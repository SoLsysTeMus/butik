package tests.registration;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CorrectRegistrationTests extends BaseTest {


   @Test
   public void testRegistrationWithValidDataPopUp() {

      String name = "Test";
      String randomEmail = "test" + (int) (Math.random() * 20000) + "@test" + (int) (Math.random() * 20000) + ".ru";
      String password = "12345";

      System.out.println(randomEmail);
      app.navigation().openAuthorizationPopUp();
      app.navigation().gotoRegistrationPopUpForm();
      app.registration().fillPopUpRegistrationForm(name, randomEmail, password);
      app.registration().submitPopUpRegistrationData();
      app.header().openPersonalMenu();
      app.personalMenu().gotoProfile();

      Assert.assertEquals(app.userProfile().getProfileEmail(), randomEmail);
   }

   @Test
   public void testRegistrationWithValidData() {

      String name = "Test";
      String randomEmail = "test" + (int) (Math.random() * 20000) + "@test" + (int) (Math.random() * 20000) + ".ru";
      String password = "12345";

      System.out.println(randomEmail);
      app.navigation().openRegistrationPage();
      app.registration().fillRegistrationForm(name, randomEmail, password);
      app.registration().submitRegistrationData();
      app.header().openPersonalMenu();
      app.personalMenu().gotoProfile();

      Assert.assertEquals(app.userProfile().getProfileEmail(), randomEmail);
   }


}
