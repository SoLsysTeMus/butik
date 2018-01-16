package appmanager.helpers;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PageHelper extends BaseHelper {

   public void pageContainsText(By locator, String text) {
      $(locator).shouldHave(text(text));
   }

   public void locatorContainsLink(By locator, String url) {
      $(locator).shouldBe(attribute("href", url));
   }
}
