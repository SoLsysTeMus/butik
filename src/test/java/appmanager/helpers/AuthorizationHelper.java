package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AuthorizationHelper extends BaseHelper {

   public AuthorizationHelper(WebDriver wd) {
      super(wd);
   }

   public void fillPopUpAuthorizationForm(String login, String password) {
      waitLoadingElement(By.id("js-login-email"),5);
      type(By.id("js-login-email"), login);
      type(By.xpath("//input[@type='password']"), password);
   }

   public void fillAuthorizationForm(String login, String password) {
      type(By.xpath("/html/body/div[2]/div[1]/div/div[1]/form/div[1]/input"), login);
      type(By.xpath("//input[@type='password']"), password);
   }

   public void submitPopUpLoginData() {
      click(By.xpath("//div[@id='authPopup']/div[2]/div/div/form/button"));
   }

   public void submitLoginData() {
      click(By.xpath("/html/body/div[2]/div[1]/div/div[1]/form/button"));
   }


}
