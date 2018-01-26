package tests.registration;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import tests.BaseTest;

import static ru.yandex.qatools.allure.model.SeverityLevel.*;

@Features("Регистрация")
public class RegistrationTests extends BaseTest {

   @BeforeMethod
   public void cleanUpSession() {
      app.navigation().openUrl(Configuration.baseUrl);
   }

   @Title("Регистрация пользователя через Pop-up")
   @Severity(CRITICAL)
   @Test
   public void testRegistrationWithValidDataPopUp() {
      long now = System.currentTimeMillis();
      String name = "Test";
      String randomEmail = "autoTest" + now + "@autoTest" + now + ".ru";
      String password = "12345";

      logger.info("Generated email for testRegistrationWithValidDataPopUp = " + randomEmail);
      app.navigation().openAuthorizationPopUp();
      app.navigation().openRegistrationPopUpForm();
      app.registration().fillPopUpRegistrationForm(name, randomEmail, password);
      app.registration().submitPopUpRegistrationData();
      app.header().checkUserName(name);
   }

   @Title("Регистрация пользователя через страницу /register")
   @Severity(CRITICAL)
   @Test
   public void testRegistrationWithValidData() {
      long now = System.currentTimeMillis();
      String name = "Test";
      String randomEmail = "autoTest" + now + "@autoTest" + now + ".ru";
      String password = "12345";

      logger.info("Generated email for testRegistrationWithValidData = " + randomEmail);
      app.navigation().openRegistrationPage();
      app.registration().fillRegistrationForm(name, randomEmail, password);
      app.registration().submitRegistrationData();
      app.header().checkUserName(name);
   }


}
