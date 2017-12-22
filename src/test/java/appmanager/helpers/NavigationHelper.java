package appmanager.helpers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static appmanager.ApplicationManager.baseUrl;
import static appmanager.ApplicationManager.getBaseUrl;

public class NavigationHelper extends BaseHelper {

   public NavigationHelper(WebDriver wd) {
      super(wd);
   }


   public void openAuthorizationPopUp() {
      click(By.xpath("//header/div[2]/div[5]/div[3]/div"));
   }

   public void openLoginPage() {
      wd.get(getBaseUrl() + "login");
   }

   public void openRegistrationPage() {
      wd.get(getBaseUrl() + "register");
   }

   public void gotoRegistrationPopUpForm() {
      click(By.xpath("//*[@id=\"authPopup\"]/div[2]/div[1]/div[2]/span"));
   }

   public void openUrl(String url){ wd.get(url);}

   public void gotoCheckout() { wd.get(baseUrl + "checkout");}
}
