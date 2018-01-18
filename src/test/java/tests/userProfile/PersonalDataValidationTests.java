package tests.userProfile;

import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.BaseTest;

@Features("Валидация полей в Личном кабинете - Мои данные")
public class PersonalDataValidationTests extends BaseTest {

   @Test
   @Title("Проверка валидации поля Фамилия")
   @Severity(SeverityLevel.NORMAL)
   public void testValidateSurname(){

      String login = "personaltest@test.ru";
      String password = "12345";

      app.navigation().openLoginPage();
      app.authorization().fillAuthorizationForm(login, password);
      app.authorization().submitLoginData();
      app.header().openPersonalMenu();
      app.personalMenu().gotoProfile();
      app.userProfile().fillSurname("И");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("surname", "Пожалуйста, введите не менее 2 символов");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");
      app.userProfile().fillSurname("123");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("surname", "В поле введены некорректные символы. Можно вводить буквы, пробел и символы \" - \" и \" ' \"");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");
   }


   @Test
   @Title("Проверка валидации поля Имя")
   @Severity(SeverityLevel.NORMAL)
   public void testValidateName(){

      String login = "personaltest@test.ru";
      String password = "12345";

      app.navigation().openLoginPage();
      app.authorization().fillAuthorizationForm(login, password);
      app.authorization().submitLoginData();
      app.header().openPersonalMenu();
      app.personalMenu().gotoProfile();
      app.userProfile().fillName("И");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("name", "Пожалуйста, введите не менее 2 символов");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");
      app.userProfile().fillName("123");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("name", "В поле введены некорректные символы. Можно вводить буквы, пробел и символы \" - \" и \" ' \"");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");
   }

   @Test
   @Title("Проверка валидации поля Отчество")
   @Severity(SeverityLevel.NORMAL)
   public void testValidatePatronymic(){

      String login = "personaltest@test.ru";
      String password = "12345";

      app.navigation().openLoginPage();
      app.authorization().fillAuthorizationForm(login, password);
      app.authorization().submitLoginData();
      app.header().openPersonalMenu();
      app.personalMenu().gotoProfile();
      app.userProfile().fillPatronymic("И");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("patronymic", "Пожалуйста, введите не менее 2 символов");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");
      app.userProfile().fillPatronymic("123");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("patronymic", "В поле введены некорректные символы. Можно вводить буквы, пробел и символы \" - \" и \" ' \"");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");
   }

   @Test
   @Title("Проверка валидации поля Email")
   @Severity(SeverityLevel.NORMAL)
   public void testValidateEmail(){

      String login = "personaltest@test.ru";
      String password = "12345";

      app.navigation().openLoginPage();
      app.authorization().fillAuthorizationForm(login, password);
      app.authorization().submitLoginData();
      app.header().openPersonalMenu();
      app.personalMenu().gotoProfile();

      app.userProfile().fillEmail("");
      app.userProfile().pressSaveButton();
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("@domain.ru");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("name@.ru");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("name@domain.");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("name@domain");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("name@");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("namedomain.ru");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("name @domain.ru");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail(" na me@domain.ru");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail(" name@do main.ru");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail(".name@domain.ru");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("name.@domain.ru");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("\\name@domain.ru");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("3333@22222.22");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillEmail("3333@11111");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("email", "Пожалуйста, укажите здесь правильный адрес электронной почты");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");
   }

   @Test
   @Title("Проверка валидации поля Телефон")
   @Severity(SeverityLevel.NORMAL)
   public void testValidatePhone(){

      String login = "personaltest@test.ru";
      String password = "12345";

      app.navigation().openLoginPage();
      app.authorization().fillAuthorizationForm(login, password);
      app.authorization().submitLoginData();
      app.header().openPersonalMenu();
      app.personalMenu().gotoProfile();
      app.userProfile().fillPhone("+7964531010");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("phone", "Введите 10 цифр номера");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");
      app.userProfile().fillPhone("+70000000000");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("phone", "Поле телефон не является номером телефона.");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");
   }

   @Test
   @Title("Проверка валидации поля Дата Рождения")
   @Severity(SeverityLevel.NORMAL)
   public void testValidateDob(){

      String login = "personaltest@test.ru";
      String password = "12345";

      app.navigation().openLoginPage();
      app.authorization().fillAuthorizationForm(login, password);
      app.authorization().submitLoginData();
      app.header().openPersonalMenu();
      app.personalMenu().gotoProfile();
      app.userProfile().fillDob("00-12-1978");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("dob", "Пожалуйста, введите дату рождения в формате дд-мм-гггг");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillDob("32-12-1978");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("dob", "Пожалуйста, введите дату рождения в формате дд-мм-гггг");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillDob("01-00-1978");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("dob", "Пожалуйста, введите дату рождения в формате дд-мм-гггг");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillDob("01-13-1978");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("dob", "Пожалуйста, введите дату рождения в формате дд-мм-гггг");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillDob("01-12-0000");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("dob", "Пожалуйста, введите дату рождения в формате дд-мм-гггг");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillDob("01-12-2030");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("dob", "Пожалуйста, введите дату рождения в формате дд-мм-гггг");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");
   }

   @Test
   @Title("Проверка валидации формы - Сменить пароль")
   @Severity(SeverityLevel.NORMAL)
   public void testValidatePassword(){

      String login = "personaltest@test.ru";
      String password = "12345";

      app.navigation().openLoginPage();
      app.authorization().fillAuthorizationForm(login, password);
      app.authorization().submitLoginData();
      app.header().openPersonalMenu();
      app.personalMenu().gotoProfile();
      app.userProfile().pressChangePasswordButton();
      app.userProfile().pressSaveButton();
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillOldPassword("1");
      app.userProfile().fillNewPassword("1");
      app.userProfile().fillNewPasswordRepeat("1");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("old_password", "ПОЖАЛУЙСТА, ВВЕДИТЕ НЕ МЕНЕЕ 5 СИМВОЛОВ");
      app.userProfile().errorIsDisplayedForField("new_password", "ПОЖАЛУЙСТА, ВВЕДИТЕ НЕ МЕНЕЕ 5 СИМВОЛОВ");
      app.userProfile().errorIsDisplayedForField("new_password_repeat", "ПОЖАЛУЙСТА, ВВЕДИТЕ НЕ МЕНЕЕ 5 СИМВОЛОВ");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");

      app.userProfile().fillOldPassword("123456");
      app.userProfile().fillNewPassword("12345");
      app.userProfile().fillNewPasswordRepeat("12345");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("old_password", "НЕВЕРНЫЙ ПАРОЛЬ");

      app.userProfile().fillOldPassword("12345");
      app.userProfile().fillNewPassword("123456");
      app.userProfile().fillNewPasswordRepeat("12345");
      app.userProfile().pressSaveButton();
      app.userProfile().errorIsDisplayedForField("new_password_repeat", "ЗНАЧЕНИЯ ДОЛЖНЫ БЫТЬ РАВНЫ");
      app.userProfile().noDisplayedSystemMessage("Изменения были успешно сохранены!");
   }
}
