package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
      new Actions(wd).moveToElement(wd.findElement(locator)).build().perform();
   }

   public void getTitle(){
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


   protected String getValueForElement(By locator) {
       return wd.findElement(locator).getAttribute("value");
   }

   protected String getTextForElement(By locator){
      return wd.findElement(locator).getText();
   }

   protected void waitLoadingElement(By locator, int timeOutInSeconds) {
      WebDriverWait wait = new WebDriverWait(wd, timeOutInSeconds);
      WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
   }
}

