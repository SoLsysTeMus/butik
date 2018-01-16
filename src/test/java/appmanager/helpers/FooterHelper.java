package appmanager.helpers;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FooterHelper extends BaseHelper {

   public void gotoStaticPage(String pageName) {
      $(By.xpath(String.format("//footer//a[contains(text(),'%s')]", pageName))).click();
   }
}
