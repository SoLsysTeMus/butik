package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BaseHelper {

   protected WebDriver wd;

   public BaseHelper(WebDriver wd) {
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

   protected String getTextForElement(By locator) {
      return wd.findElement(locator).getText();
   }

   protected void waitLoadingElement(By locator, int timeOutInSeconds) {
      WebDriverWait wait = new WebDriverWait(wd, timeOutInSeconds);
      WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
   }

   protected void waitForElementInvisible(By locator, int timeOutSeconds) {
      WebDriverWait wait = new WebDriverWait(wd, timeOutSeconds);
      Boolean element = wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
   }

   public boolean elementIsNotPresent(WebElement element) {

      boolean notExist;

      try {
         wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
         notExist = element.isEnabled();
      } catch (NoSuchElementException e) {
         notExist = true;
      } finally {
         wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      }

      return notExist;

   }

}

