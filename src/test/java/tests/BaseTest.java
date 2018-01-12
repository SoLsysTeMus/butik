package tests;

import appmanager.ApplicationManager;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.AllureListeners;
import utils.AllureUtils;

import java.util.Properties;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static utils.Utils.loadPropertiesFromConfig;

@Listeners({AllureListeners.class})
public class BaseTest {

   public static long baseTimeout;
   protected final ApplicationManager app = new ApplicationManager();

   @BeforeMethod
   public void setUp() {

      Properties systemProperties = System.getProperties();
      Properties testProperties = loadPropertiesFromConfig("src/test/resources/test.properties");

      setConfig(systemProperties, testProperties);
      app.init();

      open(baseUrl);
   }

   private void setConfig(Properties systemProperties, Properties testProperties) {

      if (!systemProperties.containsKey("gradle")) {
         Configuration.browser = "chrome";
      } else if (Configuration.browser.equals("opera")) {
         Configuration.browserBinary = "/usr/bin/opera-beta";
      }

      baseUrl = testProperties.getProperty("baseUrl");
      baseTimeout = Long.parseLong(testProperties.getProperty("timeout"));
      Configuration.browserSize = testProperties.getProperty("browserSize");
      Configuration.reportsFolder = testProperties.getProperty("reportsFolder");
      Configuration.headless = Boolean.parseBoolean(testProperties.getProperty("headless"));
      Configuration.screenshots = Boolean.parseBoolean(testProperties.getProperty("screenshots"));
      Configuration.timeout = baseTimeout;
   }


   @AfterMethod
   public void teardown() {

   }

   @AfterSuite
   public void createEnvForAllure() {
      AllureUtils.createEnvironmentProperties();
   }
}
