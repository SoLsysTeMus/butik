package appmanager.helpers;

import org.openqa.selenium.By;

public class SearchHelper extends BaseHelper {

   public Object getItemsCount() {
      waitLoader();
      return Integer.parseInt(getTextForElement(By.xpath("//div[contains(@class,'hidden-xs') and contains(@data-bind, 'getGoodsCountText')]")).replaceAll("\\D", ""));
   }
}
