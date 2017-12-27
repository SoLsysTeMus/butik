package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterHelper extends BaseHelper {

   public FooterHelper(WebDriver wd) {
      super(wd);
   }

   public void gotoStaticPage(String pageName){
      click(By.xpath(String.format("//footer//a[contains(text(),'%s')]", pageName)));
   }
}
