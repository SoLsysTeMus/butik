package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class FooterHelper extends BaseHelper {

   public FooterHelper(WebDriver wd) {
      super(wd);
   }

   public void gotoStaticPage(String pageName){
      $(By.xpath(String.format("//footer//a[contains(text(),'%s')]", pageName))).click();
   }
}
