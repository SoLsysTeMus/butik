package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserProfileHelper extends BaseHelper {

   public UserProfileHelper(ChromeDriver wd) {
      super(wd);
   }

   public String getProfileEmail() {
      return getValueForElement(By.xpath("/html/body/div[2]/div[1]/div[3]/form/div/div[2]/div[2]/div[1]/input"));
   }

}
