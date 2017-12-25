package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalMenuHelper extends BaseHelper {

   public PersonalMenuHelper(WebDriver wd) {
      super(wd);
   }

   public void gotoProfile() {
      waitLoadingElement(By.xpath("(//a[contains(text(),'Персональные данные')])[2]"), 5);
      click(By.xpath("(//a[contains(text(),'Персональные данные')])[2]"));
   }

}
