package appmanager.helpers;

import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

public class SearchHelper extends BaseHelper {

   @Step("Получение количества товара на странице")
   public Object getItemsCount() {
      waitLoader();
      return Integer.parseInt(getTextForElement(By.xpath("//div[contains(@class,'hidden-xs') and contains(@data-bind, 'getGoodsCountText')]")).replaceAll("\\D", ""));
   }
}
