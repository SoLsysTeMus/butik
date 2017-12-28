package appmanager.helpers;

import org.openqa.selenium.By;

public class PersonalMenuHelper extends BaseHelper {

   public void gotoProfile() {
      click(By.xpath("(//a[contains(text(),'Персональные данные')])[2]"));
   }

}
