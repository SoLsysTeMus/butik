package appmanager.helpers;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class AuthorizationHelper extends BaseHelper {


   public void fillPopUpAuthorizationForm(String login, String password) {
      $(By.id("js-login-email")).setValue(login).click();
      $(By.xpath("//input[@type='password']")).setValue(password).click();
   }

   public void fillAuthorizationForm(String login, String password) {
      type(By.xpath("/html/body/div[2]/div[1]/div/div[1]/form/div[1]/input"), login);
      type(By.xpath("//input[@type='password']"), password);
   }

   public void submitPopUpLoginData() {
      click(By.xpath("//div[@id='authPopup']/div[2]/div/div/form/button"));
      waitLoader();
      $(By.xpath("//div[contains(@class,'p-x-sm_0-5 p-x-lg_1 dib hidden-xs')]//a[contains(@href,'wishlist')]")).shouldBe(Condition.visible);
   }

   public void submitLoginData() {
      click(By.xpath("/html/body/div[2]/div[1]/div/div[1]/form/button"));
      waitLoader();
   }


}
