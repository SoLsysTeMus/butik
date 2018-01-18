package appmanager.helpers;

import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class PersonalMenuHelper extends BaseHelper {

   @Step("Переход на страницу с Персональным данными пользователя")
   public void gotoProfile() {
      $(".user-block.fr.nowrp").$x(".//a[contains(text(),'Персональные данные')]").click();
   }

   @Step("Переход на страницу с Задать вопрос")
   public void gotoSendQuestion() {
      $(".user-block.fr.nowrp").$x(".//a[contains(text(),'Задать вопрос')]").click();
   }

}
