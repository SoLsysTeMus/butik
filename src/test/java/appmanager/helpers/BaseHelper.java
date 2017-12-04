package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseHelper {

   protected ChromeDriver wd;

   public BaseHelper(ChromeDriver wd) {
      this.wd = wd;
   }


   protected void click(By locator) {
      wd.findElement(locator).click();
   }

   protected void type(By locator, String text) {
      wd.findElement(locator).click();
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
   }

   protected void moveTo(By locator) {
      Actions action = new Actions(wd);
      WebElement we = wd.findElement(locator);
      action.moveToElement(we).moveToElement(wd.findElement(locator)).build().perform();
   }

   protected void getTitle(){
      wd.getTitle();
   }




   public boolean isAlertPresent() {
      try {
         wd.switchTo().alert();
         return true;
      } catch (NoAlertPresentException e) {
         return false;
      }
   }


}

