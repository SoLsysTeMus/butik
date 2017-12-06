package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CatalogHelper extends BaseHelper {

   public CatalogHelper(WebDriver wd) {
      super(wd);
   }

   public int getProductsCountInCategory() {
      waitLoadingElement(By.xpath("//span[contains(text(),'товар')]"), 10);
      return Integer.parseInt(getTextForElement(By.xpath("//span[contains(text(),'товар')]")).replaceAll("\\D", ""));
   }

   public void openFirstProductCard() {
      click(By.xpath("/html/body/div[2]/div[1]/div[4]/div[1]/div/div[6]/div[1]/div[1]/a"));
   }


}
