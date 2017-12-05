package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CatalogHelper extends BaseHelper {

   public CatalogHelper(ChromeDriver wd) {
      super(wd);
   }

   public int getProductsCountInCategory(){
      waitLoadingElement(By.xpath("//span[contains(text(),'товар')]"), 5);
      return Integer.parseInt(getTextForElement(By.xpath("//span[contains(text(),'товар')]")).replaceAll("\\D",""));
   }


}
