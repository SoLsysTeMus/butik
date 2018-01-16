package tests.registration;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.BaseTest;

@Features("Регистрация")
public class RegistrationTests extends BaseTest {

   @BeforeMethod
   public void cleanUpSession() {
      app.navigation().openUrl(Configuration.baseUrl);
   }

   @Title("Регистрация пользователя через Pop-up")
   @Severity(SeverityLevel.CRITICAL)
   @Test //(enabled = false)
   public void testRegistrationWithValidDataPopUp() {

      String name = "Test";
      String randomEmail = "test" + (int) (Math.random() * 20000) + "@test" + (int) (Math.random() * 20000) + ".ru";
      String password = "12345";

      System.out.println(randomEmail);
      app.navigation().openAuthorizationPopUp();
      app.navigation().openRegistrationPopUpForm();
      app.registration().fillPopUpRegistrationForm(name, randomEmail, password);
      app.registration().submitPopUpRegistrationData();
      app.header().checkUserName(name);
   }

   @Title("Регистрация пользователя через страницу /register")
   @Severity(SeverityLevel.CRITICAL)
   @Test //(enabled = false)
   public void testRegistrationWithValidData() {

      String name = "Test";
      String randomEmail = "test" + (int) (Math.random() * 20000) + "@test" + (int) (Math.random() * 20000) + ".ru";
      String password = "12345";

      System.out.println(randomEmail);
      app.navigation().openRegistrationPage();
      app.registration().fillRegistrationForm(name, randomEmail, password);
      app.registration().submitRegistrationData();
      app.header().checkUserName(name);
   }


}
