package tests.userProfile;

import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.BaseTest;

@Features("Валидация полей в Личном кабинете - Задать вопрос")
public class SendQuestionValidation extends BaseTest {

   @Test
   @Title("Проверка валидации поля Имя")
   @Severity(SeverityLevel.MINOR)
   public void testValidateName() {

      String login = testDataProperties.getProperty("personalDataLogin");
      String password = testDataProperties.getProperty("personalDataPassword");

      app.navigation().openLoginPage();
      app.authorization().fillAuthorizationForm(login, password);
      app.authorization().submitLoginData();
      app.header().openPersonalMenu();
      app.personalMenu().gotoSendQuestion();
      app.userProfile().fillName("И");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().errorIsDisplayedForField("name", "Пожалуйста, введите не менее 2 символов");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");
      app.userProfile().fillName("123");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().errorIsDisplayedForField("name", "В поле введены некорректные символы. Можно вводить буквы, пробел и символы \" - \" и \" ' \"");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");
   }

   @Test
   @Title("Проверка валидации поля Email")
   @Severity(SeverityLevel.NORMAL)
   public void testValidateEmail() {

      String login = testDataProperties.getProperty("personalDataLogin");
      String password = testDataProperties.getProperty("personalDataPassword");

      app.navigation().openLoginPage();
      app.authorization().fillAuthorizationForm(login, password);
      app.authorization().submitLoginData();
      app.header().openPersonalMenu();
      app.personalMenu().gotoSendQuestion();

      app.userProfile().fillEmail("");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("@domain.ru");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("name@.ru");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("name@domain.");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("name@domain");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("name@");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("namedomain.ru");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("name @domain.ru");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail(" na me@domain.ru");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail(" name@do main.ru");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail(".name@domain.ru");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("name.@domain.ru");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("\\name@domain.ru");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("3333@22222.22");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("3333@11111");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");
   }

   @Test
   @Title("Проверка валидации поля Текст вопроса")
   @Severity(SeverityLevel.MINOR)
   public void testValidateQuestionName() {

      String login = testDataProperties.getProperty("personalDataLogin");
      String password = testDataProperties.getProperty("personalDataPassword");

      app.navigation().openLoginPage();
      app.authorization().fillAuthorizationForm(login, password);
      app.authorization().submitLoginData();
      app.header().openPersonalMenu();
      app.personalMenu().gotoSendQuestion();
      app.userProfile().selectTypeQuestion("Запрос");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().questionErrorIsDisplayed("Введите вопрос");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");
   }

   @Test
   @Title("Проверка валидации поля Текст вопроса")
   @Severity(SeverityLevel.MINOR)
   public void testValidateQuestionType() {

      String login = testDataProperties.getProperty("personalDataLogin");
      String password = testDataProperties.getProperty("personalDataPassword");

      app.navigation().openLoginPage();
      app.authorization().fillAuthorizationForm(login, password);
      app.authorization().submitLoginData();
      app.header().openPersonalMenu();
      app.personalMenu().gotoSendQuestion();
      app.userProfile().fillQuestionText("question text");
      app.userProfile().pressSendQuestionButton();
      app.userProfile().questionErrorIsDisplayed("Выберите тему");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");
   }
}
