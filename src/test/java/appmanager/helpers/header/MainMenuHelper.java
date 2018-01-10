package appmanager.helpers.header;

import appmanager.helpers.BaseHelper;
import org.openqa.selenium.By;

public class MainMenuHelper extends BaseHelper {

   public void gotoCategory(By category) {
      click(category);
   }

   public void gotoSubcategory(By category, By subcategory) {
      moveTo(category);
      moveTo(subcategory);
      click(subcategory);
   }


}
