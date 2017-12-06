package appmanager.helpers.header;

import appmanager.helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainMenuHelper extends BaseHelper{

   public MainMenuHelper(WebDriver wd) {
      super(wd);
   }

   public void gotoCategory(By category){
      click(category);
   }

   public void gotoSubcategory(By category, By subcategory){
      moveTo(category);
      moveTo(subcategory);
      click(subcategory);
   }


}
