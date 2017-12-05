package tests.registration;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CorrectRegistrationTests extends BaseTest {


   @Test
   public void testRegistrationWithValidDataPopUp() {

      String name = "Test";
      String randomEmail = "test" + (int) (Math.random() * 2000) + "@test" + (int) (Math.random() * 2000) + ".ru";
      String password = "12345";

      System.out.println(randomEmail);
      app.getNavigationHelper().openAuthorizationPopUp();
      app.getNavigationHelper().gotoRegistrationPopUpForm();
      app.getRegistrationHelper().fillPopUpRegistrationForm(name, randomEmail, password);
      app.getRegistrationHelper().submitPopUpRegistrationData();
      app.getHeaderHelper().openPersonalMenu();
      app.getPersonalMenuHelper().gotoProfile();

      Assert.assertEquals(app.getUserProfileHelper().getProfileEmail(), randomEmail);
   }

   @Test
   public void testRegistrationWithValidData() {

      String name = "Test";
      String randomEmail = "test" + (int) (Math.random() * 2000) + "@test" + (int) (Math.random() * 2000) + ".ru";
      String password = "12345";

      System.out.println(randomEmail);
      app.getNavigationHelper().openRegistrationPage();
      app.getRegistrationHelper().fillRegistrationForm(name, randomEmail, password);
      app.getRegistrationHelper().submitRegistrationData();
      app.getHeaderHelper().openPersonalMenu();
      app.getPersonalMenuHelper().gotoProfile();

      Assert.assertEquals(app.getUserProfileHelper().getProfileEmail(), randomEmail);
   }


}
