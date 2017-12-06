package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PersonalMenuHelper extends BaseHelper {

   public PersonalMenuHelper(WebDriver wd) {
      super(wd);
   }

   public void gotoProfile() {
      click(By.xpath("(//a[contains(text(),'Персональные данные')])[2]"));
   }

}
