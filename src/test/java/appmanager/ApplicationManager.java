package appmanager;

import appmanager.helpers.*;
import appmanager.helpers.header.HeaderHelper;
import appmanager.helpers.header.MainMenuHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

   protected WebDriver wd;

   public static String baseUrl = "https://stage.butik.ru/";

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

      wd = null;
      try {
         wd = new RemoteWebDriver(new URL("http://172.16.83.128:32768/wd/hub"),
                 DesiredCapabilities.chrome());
      } catch (MalformedURLException e) {
         e.printStackTrace();
      }
      //wd.manage().window().;
      wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      wd.get(baseUrl);

      initHelpers();
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

