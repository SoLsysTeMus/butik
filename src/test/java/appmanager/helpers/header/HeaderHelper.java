package appmanager.helpers.header;

import appmanager.helpers.BaseHelper;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class HeaderHelper extends BaseHelper {

   public void openPersonalMenu() {
      $(By.xpath("//header/div[2]/div[5]/div[4]/div/div[1]/span")).hover();
   }

   public void gotoWishlist() {
      click(By.xpath("//header/div[2]/div[5]/div[3]/a"));
   }

   public Integer getWishlistItemscount() {
      return Integer.parseInt(getTextForElement(By.xpath("//header/div[2]/div[5]/div[3]/a/span")));
   }


}
