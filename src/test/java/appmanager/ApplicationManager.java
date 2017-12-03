package appmanager;

import appmanager.helpers.AuthorizationHelper;
import appmanager.helpers.NavigationHelper;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

   ChromeDriver wd;

   private NavigationHelper navigationHelper;
   private AuthorizationHelper authorizationHelper;

   public void init() {

      System.setProperty("webdriver.chrome.driver", "/home/solsystem/qa/chromedriver");
      wd = new ChromeDriver();
      wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      wd.get("https://butik.ru/");

      navigationHelper = new NavigationHelper(wd);
      authorizationHelper = new AuthorizationHelper(wd);
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
}
