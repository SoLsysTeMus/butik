package appmanager.helpers.header;

import appmanager.helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends BaseHelper {

   public HeaderHelper(WebDriver wd) {
      super(wd);
   }

   public void openPersonalMenu() {
      waitLoadingElement(By.xpath("//header/div[2]/div[5]/div[4]/div/div[1]/span"), 5);
      moveTo(By.xpath("//header/div[2]/div[5]/div[4]/div/div[1]/span"));
   }

   public void gotoWishlist() {
      click(By.xpath("//header/div[2]/div[5]/div[3]/a"));
   }

   public Integer getWishlistItemscount() {
      waitLoadingElement(By.xpath("//header/div[2]/div[5]/div[3]/a/span"), 5);
      return Integer.parseInt(getTextForElement(By.xpath("//header/div[2]/div[5]/div[3]/a/span")));
   }


}
