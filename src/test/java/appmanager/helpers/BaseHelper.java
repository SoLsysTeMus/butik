package appmanager.helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class BaseHelper {

   protected void click(By locator) {
      $(locator).click();
   }

   protected void type(By locator, String text) {
      $(locator).setValue(text);
   }

   protected void moveTo(By locator) {
      actions().moveToElement($(locator)).build().perform();
   }

   protected String getValueForElement(By locator) {
      return $(locator).getAttribute("value");
   }

   protected String getTextForElement(By locator) {
      return $(locator).shouldBe(Condition.visible).getText();
   }

   public void waitLoader() {
      Configuration.timeout = 7000;
      $(By.xpath("//div[contains(@data-bind,\"showLoader\")]")).shouldNotBe(Condition.visible);
      Configuration.timeout = 4000;
   }
}

