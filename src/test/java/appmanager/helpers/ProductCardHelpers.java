package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCardHelpers extends BaseHelper {

   public ProductCardHelpers(WebDriver wd) {
      super(wd);
   }


   public void addToWishlist() {
      waitLoadingElement(By.xpath("//button[contains(@data-bind,'toggleWishlist')]"),5);
      click(By.xpath("//button[contains(@data-bind,'toggleWishlist')]"));
   }

   public void removeFromlist() {
      waitLoadingElement(By.xpath("//button[contains(@data-bind,'toggleWishlist')]"),5);
      click(By.xpath("//button[contains(@data-bind,'toggleWishlist')]"));
   }

   public void addToCart() {
      waitLoadingElement(By.xpath("//button[contains(@data-bind,'addToCart')]"),5);
      click(By.xpath("//button[contains(@data-bind,'addToCart')]"));
   }
}
