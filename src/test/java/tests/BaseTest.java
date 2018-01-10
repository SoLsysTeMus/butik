package tests;

import appmanager.ApplicationManager;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

   protected final ApplicationManager app = new ApplicationManager();

   @BeforeMethod
   public void setUp() {

      String baseUrl = "https://butik.ru/";
      //Configuration.browser = "chrome";
      Configuration.browserSize = "1920x1080";
      Configuration.captureJavascriptErrors = true;
      Configuration.headless = false;
      Configuration.baseUrl = baseUrl;
      Configuration.timeout = 5000;

      app.init();
      //open(baseUrl);
   }

   @AfterMethod
   public void teardown() {

   }
}
