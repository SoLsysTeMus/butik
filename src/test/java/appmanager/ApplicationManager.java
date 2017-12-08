package appmanager;

import appmanager.helpers.*;
import appmanager.helpers.header.HeaderHelper;
import appmanager.helpers.header.MainMenuHelper;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

   protected WebDriver wd;

   public static String baseUrl = "https://stage.butik.ru/";
   public boolean useSelenoid = true;

   private NavigationHelper navigationHelper;
   private RegistrationHelper registrationHelper;
   private AuthorizationHelper authorizationHelper;
   private UserProfileHelper userProfileHelper;
   private PersonalMenuHelper personalMenuHelper;
   private HeaderHelper headerHelper;
   private MainMenuHelper mainMenuHelper;
   private CatalogHelper catalogHelper;
   private ProductCardHelpers productCardHelpers;

   public void init() {

      if (useSelenoid) {
         initSelenoidDriver();
      } else {
         initLocalDriver();
      }

      wd.get(baseUrl);

      initHelpers();
   }

   private void initLocalDriver() {
      //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
      System.setProperty("webdriver.gecko.driver", "drivers/firefox");
      wd = new FirefoxDriver();
      wd.manage().window().maximize();
      wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


   }

   private void initSelenoidDriver() {
      wd = null;
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setBrowserName("firefox");
      capabilities.setVersion("56.0");
      capabilities.setCapability("enableVNC",true);
      capabilities.setCapability("enableVideo",true);

      try {
         wd = new RemoteWebDriver(
                 URI.create("http://172.16.83.128:4444/wd/hub").toURL(),
                 capabilities
         );
      } catch (MalformedURLException e) {
         e.printStackTrace();
      }
      wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      wd.manage().window().setSize(new Dimension(1920,1080));
   }

   private void initHelpers() {
      navigationHelper = new NavigationHelper(wd);
      mainMenuHelper = new MainMenuHelper(wd);
      registrationHelper = new RegistrationHelper(wd);
      authorizationHelper = new AuthorizationHelper(wd);
      userProfileHelper = new UserProfileHelper(wd);
      personalMenuHelper = new PersonalMenuHelper(wd);
      headerHelper = new HeaderHelper(wd);
      catalogHelper = new CatalogHelper(wd);
      productCardHelpers = new ProductCardHelpers(wd);
   }

   public void stop() {
      wd.quit();
   }

   public NavigationHelper getNavigationHelper() {
      return navigationHelper;
   }

   public AuthorizationHelper getAuthorizationHelper() {
      return authorizationHelper;
   }

   public UserProfileHelper getUserProfileHelper() {
      return userProfileHelper;
   }

   public RegistrationHelper getRegistrationHelper() {
      return registrationHelper;
   }

   public PersonalMenuHelper getPersonalMenuHelper() {
      return personalMenuHelper;
   }

   public HeaderHelper getHeaderHelper() {
      return headerHelper;
   }

   public MainMenuHelper getMainMenuHelper() {
      return mainMenuHelper;
   }

   public CatalogHelper getCatalogHelper() {
      return catalogHelper;
   }

   public ProductCardHelpers getProductCardHelpers() {
      return productCardHelpers;
   }

   public static String getBaseUrl() {
      return baseUrl;
   }
}

