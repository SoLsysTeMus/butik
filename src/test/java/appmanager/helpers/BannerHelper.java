package appmanager.helpers;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BannerHelper extends BaseHelper{

   public void selectSexOnGenderBanner(String sex) {
      $(By.xpath(String.format("//a//span[contains(text(),'%s')]",sex))).click();
   }
}
