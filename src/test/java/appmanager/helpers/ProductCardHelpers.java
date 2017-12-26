package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductCardHelpers extends BaseHelper {

   public ProductCardHelpers(WebDriver wd) {
      super(wd);
   }


   public void addToWishlist() {
      waitLoadingElement(By.xpath("//button[contains(@data-bind,'toggleWishlist')]"), 5);
      click(By.xpath("//button[contains(@data-bind,'toggleWishlist')]"));
   }

   public void removeFromlist() {
      waitLoadingElement(By.xpath("//button[contains(@data-bind,'toggleWishlist')]"), 5);
      click(By.xpath("//button[contains(@data-bind,'toggleWishlist')]"));
   }

   public void addToCart() {
      waitLoadingElement(By.xpath("//button[contains(@data-bind,'addToCart')]"), 5);
      click(By.xpath("//button[contains(@data-bind,'addToCart')]"));
   }

   public void pressCheckoutButtonOnPopUp() {
      waitLoadingElement(By.xpath("//a[contains(text(),'Оформить заказ')]"), 5);
      click(By.xpath("//a[contains(text(),'Оформить заказ')]"));
      waitForElementInvisible(By.xpath("//div[contains(@data-bind,\"showLoader\")]"), 5);
   }

   public List getProductRusSizes() {

      List<String> sizes = new ArrayList<>();

      List<WebElement> allSizes = getAllSizes();

      for (WebElement row : allSizes) {

         String rusSize = row.findElement(By.xpath(".//div[contains(@data-bind,'rus_size')]")).getText();
         sizes.add(rusSize);
      }
      return sizes;
   }

   public List<WebElement> getAllSizes() {
      wd.findElement(By.xpath("//span[contains(text(), \"Выберите размер\")]")).click();
      WebElement table = wd.findElement(By.xpath("//div[contains(@class,'custom-select__list')]"));
      return table.findElements(By.xpath("//div[contains(@class,'custom-select__row clear-cln')]"));
   }


   public void selectSize(int i) {
      List sizes = getProductRusSizes();
      wd.findElement(By.xpath(String.format(".//div[contains(@data-bind,'rus_size') and contains(text(),'%s')]", sizes.get(i)))).click();
   }
}
