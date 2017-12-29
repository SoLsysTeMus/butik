package appmanager.helpers;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static appmanager.ApplicationManager.getBaseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NavigationHelper extends BaseHelper {

   public void openAuthorizationPopUp() {
      click(By.xpath("//div[contains(@class,'user-block fr nowrp')]//div[contains(@class,'dropmenu-root')]"));
      $(By.id("authPopup")).shouldBe(Condition.visible);
   }

   public void openLoginPage() {
      open(getBaseUrl() + "login");
   }

   public void openRegistrationPage() {
      open(getBaseUrl() + "register");
   }

   public void gotoRegistrationPopUpForm() {
      click(By.xpath("//*[@id=\"authPopup\"]/div[2]/div[1]/div[2]/span"));
   }

   public void openUrl(String url) {
      open(url);
   }

   public void gotoCheckout() {
      open(getBaseUrl() + "checkout");
   }

   public void logoutBylink(){
      openUrl(getBaseUrl() + "logout");
   }
}
