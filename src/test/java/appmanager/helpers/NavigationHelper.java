package appmanager.helpers;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NavigationHelper extends BaseHelper {

   public NavigationHelper(ChromeDriver wd) {
      super(wd);
   }


   public void openAuthorizationPopUp() {
      click(By.xpath("//div[5]/div[3]/div/div/div"));
   }

   public void openLoginPage() {
      wd.get(ApplicationManager.getBaseUrl() + "login");
   }

   public void openRegistrationPage() {
      wd.get(ApplicationManager.getBaseUrl() + "register");
   }

   public void gotoRegistrationPopUpForm() {
      click(By.xpath("//*[@id=\"authPopup\"]/div[2]/div[1]/div[2]/span"));
   }
}
