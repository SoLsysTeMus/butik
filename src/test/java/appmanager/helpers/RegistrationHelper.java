package appmanager.helpers;

import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class RegistrationHelper extends BaseHelper {

   @Step("Заполнение полей Имя, email и пароль на форме PopUp")
   public void fillPopUpRegistrationForm(String name, String email, String password) {
      fillPopUpRegistrationEmailField(email);
      fillPopUpRegistrationNameField(name);
      fillPopUpRegistrationPasswordField(password);
   }

   private void fillPopUpRegistrationPasswordField(String password) {
      String formSelector = ".authorization__registration";
      $(formSelector).$x(".//input[@type='password']").setValue(password).click();
      sleep(100);
   }

   private void fillPopUpRegistrationEmailField(String email) {
      String formSelector = ".authorization__registration";
      $(formSelector).$x(".//input[@placeholder='E-mail']").setValue(email).click();
      sleep(100);
   }

   private void fillPopUpRegistrationNameField(String name) {
      String formSelector = ".authorization__registration";
      $(formSelector).$x(".//input[@id='js-registration-name']").setValue(name).click();
      sleep(100);
   }

   @Step("Заполнение полей Имя, email и пароль на странице /register")
   public void fillRegistrationForm(String name, String randomEmail, String password) {
      type(By.xpath("//*[@id=\"js-registration-name\"]"), name);
      type(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/form/div[2]/input"), randomEmail);
      type(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/form/div[5]/input"), password);
   }

   @Step("Нажатие на кнопку \"Регистрация\" на форме PopUp ")
   public void submitPopUpRegistrationData() {
      click(By.xpath("//*[@id=\"authPopup\"]/div[2]/div[2]/div/div[2]/form/button"));
      waitLoader();
   }

   @Step("Нажатие на кнопку \"Регистрация\" на странице /register")
   public void submitRegistrationData() {
      click(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/form/button"));
      waitLoader();
   }
}
