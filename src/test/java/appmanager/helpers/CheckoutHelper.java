package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutHelper extends BaseHelper{

   public CheckoutHelper(WebDriver wd) {
      super(wd);
   }

   public void deleteItemFromWishlist(){
      click(By.xpath("//button[contains(@class,'heart')]"));
   }

}
