package appmanager.helpers;

import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class FooterHelper extends BaseHelper {

   @Step("Переход на выбранную страницу из футера")
   public void gotoStaticPage(String pageName) {
      $(By.xpath(String.format("//footer//a[contains(text(),'%s')]", pageName))).click();
   }
}
