package tests;

import appmanager.ApplicationManager;
import com.automation.remarks.testng.VideoListener;
import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.AllureListeners;

import java.util.Properties;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static utils.Utils.loadPropertiesFromConfig;

@Listeners({AllureListeners.class, VideoListener.class})

public class BaseTest {

   public final static Logger logger = LoggerFactory.getLogger(BaseTest.class);
   public static long baseTimeout;
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
      open(baseUrl);
   }

   private void setConfig(Properties systemProperties, Properties testProperties) {

      if (!systemProperties.containsKey("gradle")) {
         Configuration.browser = "chrome";
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
