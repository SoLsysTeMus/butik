package tests.registration;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

@Features("Регистрация")
public class CorrectRegistrationTests extends BaseTest {

   @BeforeMethod
   public void cleanUpSession() {
      clearBrowserCookies();
      clearBrowserCache();
      app.navigation().openUrl(Configuration.baseUrl);
   }

   @Title("Регистрация пользователя через Pop-up")
   @Severity(SeverityLevel.CRITICAL)
   @Test
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
   @Test
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
