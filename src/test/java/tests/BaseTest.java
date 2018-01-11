package tests;

import appmanager.ApplicationManager;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import utils.AllureEnvironmentUtils;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

   protected final ApplicationManager app = new ApplicationManager();
   public static final int baseTimeout = 5000;

   @BeforeMethod
   public void setUp() {

      String baseUrl = "https://stage.butik.ru/";
      //Configuration.browser = "chrome";
      Configuration.browserSize = "1920x1080";
      Configuration.captureJavascriptErrors = true;
      Configuration.baseUrl = baseUrl;
      Configuration.timeout = baseTimeout;

      app.init();
      open(baseUrl);
   }

   @AfterMethod
   public void teardown() {

   }

   @AfterSuite
   public void createEnvForAllure() {
      AllureEnvironmentUtils.create();
   }
}
