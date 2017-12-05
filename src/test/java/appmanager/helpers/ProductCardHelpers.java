package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductCardHelpers extends BaseHelper{

   public ProductCardHelpers(ChromeDriver wd) {
      super(wd);
   }


   public void addToWishlist() {
      click(By.xpath("/html/body/div[2]/div[1]/div[3]/div[1]/div[4]/div[2]/button"));
   }

   public void ramoveFromlist() {
      click(By.xpath("/html/body/div[2]/div[1]/div[3]/div[1]/div[4]/div[2]/button/i"));
   }
}
