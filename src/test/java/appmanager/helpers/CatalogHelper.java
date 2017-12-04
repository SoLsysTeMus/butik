package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CatalogHelper extends BaseHelper {

   public CatalogHelper(ChromeDriver wd) {
      super(wd);
   }

   public int getProductsCountInCategory(){
      waitLoadingElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div/span[2]"), 5);
      return Integer.parseInt(getTextForElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div/span[2]")).replaceAll("\\D",""));
   }


}
