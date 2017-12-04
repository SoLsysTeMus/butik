package appmanager;

import appmanager.helpers.AuthorizationHelper;
import appmanager.helpers.NavigationHelper;
import appmanager.helpers.UserProfileHelper;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

   ChromeDriver wd;

   private NavigationHelper navigationHelper;
   private AuthorizationHelper authorizationHelper;
   private UserProfileHelper userProfileHelper;

   public void init() {

      System.setProperty("webdriver.chrome.driver", "/home/sol/drivers/chromedriver");
      wd = new ChromeDriver();
      wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      wd.get("https://butik.ru/");

      navigationHelper = new NavigationHelper(wd);
      authorizationHelper = new AuthorizationHelper(wd);
      userProfileHelper = new UserProfileHelper(wd);
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
}
