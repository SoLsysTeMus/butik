package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class ProductCardHelpers extends BaseHelper {

   public void addToWishlist() {
      click(By.xpath("//button[contains(@data-bind,'toggleWishlist')]"));
   }

   public void removeFromlist() {
      click(By.xpath("//button[contains(@data-bind,'toggleWishlist')]"));
   }

   public void addToCart() {
      click(By.xpath("//button[contains(@data-bind,'addToCart')]"));
   }

   public void pressCheckoutButtonOnPopUp() {
      click(By.xpath("//a[contains(text(),'Оформить заказ')]"));
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
      click(By.xpath("//span[contains(text(), \"Выберите размер\")]"));
      WebElement table = $(By.xpath("//div[contains(@class,'custom-select__list')]"));
      return table.findElements(By.xpath("//div[contains(@class,'custom-select__row clear-cln')]"));
   }

   public void selectSize(int i) {
      List sizes = getProductRusSizes();
      $(By.xpath(String.format(".//div[contains(@data-bind,'rus_size') and contains(text(),'%s')]", sizes.get(i)))).click();
   }
}
