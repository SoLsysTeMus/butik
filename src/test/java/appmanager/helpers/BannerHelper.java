package appmanager.helpers;

import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class BannerHelper extends BaseHelper {

   @Step("Выбор пола на раводящей через баннер")
   public void selectSexOnGenderBanner(String sex) {
      $(By.xpath(String.format("//a//span[contains(text(),'%s')]", sex))).click();
   }
}
