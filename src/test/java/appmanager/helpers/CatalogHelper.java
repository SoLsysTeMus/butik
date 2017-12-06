package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogHelper extends BaseHelper {

   public CatalogHelper(WebDriver wd) {
      super(wd);
   }

   public int getProductsCountInCategory() {
      waitLoadingElement(By.className("f-clr-dkgr"), 5);
      return Integer.parseInt(getTextForElement(By.xpath("//span[contains(text(),'товар')]")).replaceAll("\\D", ""));
   }

   public void openFirstProductCard() {
      click(By.xpath("/html/body/div[2]/div[1]/div[4]/div[1]/div/div[6]/div[1]/div[1]/a"));
   }


}
