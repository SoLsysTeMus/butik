package tests;

import appmanager.ApplicationManager;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

   protected final ApplicationManager app = new ApplicationManager();

   @BeforeMethod
   public void setUp() {

      String baseUrl = "https://stage.butik.ru/";
      Configuration.browser = "chrome";
//
//      if (Configuration.browser.contains("opera")){
//      Configuration.browserBinary = "/usr/bin/opera";
//         Configuration.openBrowserTimeoutMs = 10000;
//         Configuration.timeout = 10000;
//      }

      Configuration.browserSize = "1920x1080";
      Configuration.baseUrl = baseUrl;


      app.init();
      open(baseUrl);
   }

   @AfterMethod
   public void teardown() {

   }
}
