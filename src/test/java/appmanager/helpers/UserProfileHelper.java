package appmanager.helpers;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class UserProfileHelper extends BaseHelper {

   public void checkProfileEmail(String email) {
      $(By.xpath("//input[@type=\"email\"]")).shouldHave(Condition.exactValue(email));
   }

   public void fillSurname(String surname) {
      $(By.name("surname")).setValue(surname);
   }

   public void fillName(String name) {
      $(By.name("name")).setValue(name);
   }

   public void fillPatronymic(String patronymic) {
      $(By.name("patronymic")).setValue(patronymic);
   }

   public void fillEmail(String email) {
      $(By.name("email")).setValue(email);
   }

   public void fillPhone(String phone) {
      $(By.name("phone")).setValue(phone);
   }

   public void fillDob(String dob) {
      $(By.name("dob")).setValue(dob);
   }

   public void cheangeSex(String sex) {
      $(".content__block").$$x(".//label[@class='cln-xs_6 dib inp-r-label']").filterBy(Condition.matchText(sex)).first().click();
   }

   public void fillOldPassword(String password) {
      $(By.name("old_password")).setValue(password);
   }

   public void fillNewPassword(String password) {
      $(By.name("new_password")).setValue(password);
   }

   public void fillNewPasswordRepeat(String password) {
      $(By.name("new_password_repeat")).setValue(password);
   }

   public void errorIsDisplayedForField(String field, String error) {
      $x(String.format("//input[@name='%s']//following-sibling::span//span", field)).shouldHave(Condition.text(error));
   }

   public void pressSaveButton() {
      $x("//button[@type='submit']").click();
   }

   public void displayedSystemMessage(String message) {
      ElementsCollection collection = $x("//div[@class='profile__form-messages']").$$x(".//div[contains(@class, 'profile__')]");
      collection.filterBy(Condition.visible).filterBy(Condition.text(message)).shouldHave(CollectionCondition.size(1));
   }

   public void noDisplayedSystemMessage(String message) {
      ElementsCollection collection = $x("//div[@class='profile__form-messages']").$$x(".//div[contains(@class, 'profile__')]");
      collection.filterBy(Condition.visible).filterBy(Condition.text(message)).shouldHave(CollectionCondition.size(0));
   }

   public void pressChangePasswordButton() {
      $(".profile__pass-btn").click();
   }

   public void pressSendQuestionButton() {
      $x("//button[@type='submit']").click();
   }

   public void fillCity(String city) {
      $(By.name("city")).setValue(city);
   }

   public void selectTypeQuestion(String value) {
      $x("//select[@name='type']").click();
      $x("//select[@name='type']").$$(By.tagName("option")).filterBy(Condition.text(value)).first().click();
   }

   public void questionErrorIsDisplayed(String errorText) {
      $$(".profile__errors").filterBy(Condition.text(errorText)).shouldHaveSize(1);
   }

   public void fillQuestionText(String text) {
      $(By.name("question")).setValue(text);
   }
}
