package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserProfileHelper extends BaseHelper {

   public UserProfileHelper(WebDriver wd) {
      super(wd);
   }

   public String getProfileEmail() {
      return getValueForElement(By.xpath("//input[@type=\"email\"]"));
   }

}
