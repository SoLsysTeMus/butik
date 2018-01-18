package tests;

import appmanager.ApplicationManager;
import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utils.AllureListeners;

import java.util.Properties;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static utils.Utils.loadPropertiesFromConfig;

@Listeners({AllureListeners.class})
public class BaseTest {

   public static long baseTimeout;
   public static Logger logger = LoggerFactory.getLogger(BaseTest.class);
   protected static Properties testDataProperties;
   private static Properties systemProperties;
   private static Properties testProperties;
   protected final ApplicationManager app = new ApplicationManager();

   @BeforeSuite
   public void loadProperties() {
      systemProperties = System.getProperties();
      testProperties = loadPropertiesFromConfig("src/test/resources/test.properties");
      testDataProperties = loadPropertiesFromConfig("src/test/resources/testData.properties");
   }

   @BeforeMethod
   public void setUp() {
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
      close();
   }

}
