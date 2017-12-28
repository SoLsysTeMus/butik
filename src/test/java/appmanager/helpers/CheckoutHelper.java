package appmanager.helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementNotFound;
import model.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutHelper extends BaseHelper {

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
         Integer quantity = Integer.valueOf(row.findElement(By.xpath(".//span[contains(@data-bind,'text: quantity')]")).getText());
         Integer price = priceMultiplyCount / quantity;
         String rusSize = getSelectedSizeForProduct(row);

         products.add(new ProductData()
                 .withName(name)
                 .withBrandName(brandName)
                 .withSku(sku)
                 .withLabel(label)
                 .withPriceMultiplyCount(priceMultiplyCount)
                 .withPrice(price)
                 .withQuantity(quantity)
                 .withRusSize(rusSize));

      }
      return products;
   }

   public List<WebElement> getAllItemsFromCart() {
      WebElement table = $(By.xpath("//div[contains(@data-bind,'foreach: items')]"));
      return table.findElements(By.xpath("//div[contains(@class,'cart__item')]"));
   }

   public void removeAllProducts() {
      int counter = getItemsInTheCartList().size();
      for (int i = 0; i < counter; i++) {
         $(By.xpath("//p[contains(@class,'hidden-xs')]//span[contains(@data-bind,'removeProduct')]")).click();
         waitLoader();
      }
   }

   public boolean cartIsEmpty() {
      return $(By.xpath("//div[contains(text(),'В корзину ничего не добавлено')]")).isDisplayed();
   }

   public String getSelectedSizeForProduct(WebElement product) {
      String size;
      try {
         size = product.findElement(By.xpath(".//div[contains(@class,'nowrp')]//span[contains(@data-bind,'text: ')]")).getText();
      } catch (NoSuchElementException e) {
         size = "б/р";
      }

      return size;
   }

   public void selectCityForDilivery(String city) {
      $(By.id("citySuggester")).setValue(city);
      $(By.xpath(String.format("//b[contains(text(),'%s')]", city))).click();

   }

   public void selectDeliveryService(String service) {
      $(By.xpath(String.format("//span[contains(text(),'%s')]", service))).click();
   }

   public void submitOrder() {
      $(By.xpath("//div[contains(@data-bind,'click: sendOrder')]")).click();
      waitLoader();

   }

   public boolean isSuccesOrder() {
      System.out.println("Заказ № " + getTextForElement(By.xpath("//span[contains(@data-bind,'orderNumber')]")));
      return $(By.xpath("//div[contains(@class,'hidden-xs') and text() = 'продолжить покупки']")).isDisplayed();
   }

   public void addNewAddress() {
      click(By.xpath("//span[contains(@data-bind,'html: selectedItem()')]"));
      click(By.xpath("//li[contains(@data-bind,'newAddressItem')]"));
      waitLoader();
   }

   public void fillAddressForm(String street, String house, String flat) {
      type(By.id("streetSuggester"), street);
      click(By.xpath(String.format("//b[contains(text(),'%s')]", street)));
      type(By.id("houseSuggester"), house);
   }

   public void fillBuyerFrom(String testName, String phone, String testEmail) {
      type(By.name("name"), testName);
      type(By.name("phone"), phone);
      type(By.name("email"), testEmail);
   }

   public void openDeliveryPointMap() {
      $(By.xpath("//span[contains(@class,'hidden-xs') and text() = 'Выбрать']")).click();
      $(By.xpath("//div[contains(@class,'arcticmodal-container')]//ymaps[contains(@class,'ymaps-2-1-59-places-pane')]")).should(Condition.visible);
   }


   public void selectDeliveryPoint(String subway, String street, By point) {

      if (subway != null) {
         type(By.id("subwaySuggester"), subway);
         click(By.xpath(String.format("//b[contains(text(),'%s')]", subway)));
      }
      if (street != null) {
         type(By.id("addressSuggester"), street);
         click(By.xpath(String.format("//b[contains(text(),'%s')]", street)));
      }

      $(point).shouldBe(Condition.visible);
      $(point).hover();
      moveTo(point);
      $(point).click();


      $(By.xpath("//div[@id='map']//button[.='Выбрать']")).hover().click();

   }

   public void selectPaymentMethod(String paymentMethod) {
      click(By.xpath(paymentMethod));
   }

   public void fillCommentaryForm(String commentText) {
      click(By.xpath("//span[contains(@data-bind,'OrderDescription')]"));
      type(By.id("order-description"), commentText);
   }
}
