package appmanager.helpers;

import model.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckoutHelper extends BaseHelper {

   public CheckoutHelper(WebDriver wd) {
      super(wd);
   }

   public void deleteItemFromWishlist() {
      click(By.xpath("//button[contains(@class,'heart')]"));
   }

   public List getItemsInTheCartList() {

      List<ProductData> products = new ArrayList<>();

      List<WebElement> allItemsFromCart = getAllItemsFromCart();

      for (WebElement row : allItemsFromCart) {

         String brandName = row.findElement(By.xpath(".//p[contains(@class,'hidden-xs')]//span[contains(@data-bind,'brand_name')]")).getText();
         String name = row.findElement(By.xpath(".//p[contains(@data-bind,'name')]")).getText();
         String sku = row.findElement(By.xpath(".//p[contains(@data-bind,'sku')]")).getText();
         String label = row.findElement(By.xpath(".//span[contains(@data-bind,'sticker')]")).getText();
         Integer priceMultiplyCount = Integer.valueOf(row.findElement(By.xpath(".//span[contains(@data-bind,'price')]")).getText().replaceAll("\\D", ""));

         products.add(new ProductData(name, brandName, sku, label, priceMultiplyCount));

      }
      return products;
   }

   public List<WebElement> getAllItemsFromCart() {
      WebElement table = wd.findElement(By.xpath("//div[contains(@data-bind,'foreach: items')]"));
      return table.findElements(By.xpath("//div[contains(@class,'cart__item')]"));
   }

   public void removeAllProducts() {
      int counter = getItemsInTheCartList().size();
      for(int i = 0; i < counter; i++){
         waitLoadingElement(By.xpath("//p[contains(@class,'hidden-xs')]//span[contains(@data-bind,'removeProduct')]"), 5);
         wd.findElement(By.xpath("//p[contains(@class,'hidden-xs')]//span[contains(@data-bind,'removeProduct')]")).click();
         waitForElementInvisible(By.xpath("//div[contains(@data-bind,\"showLoader\")]"), 5);
      }
   }

   public boolean cartIsEmpty(){
      return wd.findElement(By.xpath("//div[contains(text(),'В корзину ничего не добавлено')]")).isDisplayed();
   }
}
