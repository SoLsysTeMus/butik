package appmanager.helpers;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UserProfileHelper extends BaseHelper {

   public void checkProfileEmail(String email) {
      $(By.xpath("//input[@type=\"email\"]")).shouldHave(Condition.exactValue(email));
   }

}
