package appmanager.helpers;

import org.openqa.selenium.By;

public class CatalogHelper extends BaseHelper {

   public int getProductsCountInCategory() {
      waitLoader();
      return Integer.parseInt(getTextForElement(By.xpath("//span[contains(text(),'товар')]")).replaceAll("\\D", ""));
   }

   public void openFirstProductCard() {
      click(By.xpath("/html/body/div[2]/div[1]/div[4]/div[1]/div/div[6]/div[1]/div[1]/a"));
   }


}
