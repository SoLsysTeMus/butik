package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageHelper extends BaseHelper {
   public PageHelper(WebDriver wd) {
      super(wd);
   }

   public String getTitle() {
      return wd.getTitle();
   }

   public String getPageUrl() {
      return wd.getCurrentUrl();
   }

   public boolean pageContainsText(By locator, String text) {
      return wd.findElement(locator).getText().toLowerCase().contains(text);
   }

   public String getLinkForLocator(By xpath) {
      return wd.findElement(xpath).getAttribute("href");
   }
}
