package appmanager.helpers;

import model.ProductData;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
      WebElement table = wd.findElement(By.xpath("//div[contains(@data-bind,'foreach: items')]"));
      return table.findElements(By.xpath("//div[contains(@class,'cart__item')]"));
   }

   public void removeAllProducts() {
      int counter = getItemsInTheCartList().size();
      for (int i = 0; i < counter; i++) {
         waitLoadingElement(By.xpath("//p[contains(@class,'hidden-xs')]//span[contains(@data-bind,'removeProduct')]"), 5);
         wd.findElement(By.xpath("//p[contains(@class,'hidden-xs')]//span[contains(@data-bind,'removeProduct')]")).click();
         waitForElementInvisible(By.xpath("//div[contains(@data-bind,\"showLoader\")]"), 5);
      }
   }

   public boolean cartIsEmpty() {
      return wd.findElement(By.xpath("//div[contains(text(),'В корзину ничего не добавлено')]")).isDisplayed();
   }

   public String getSelectedSizeForProduct(WebElement product) {
      String size;
      try {
         wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
         size = product.findElement(By.xpath(".//div[contains(@class,'nowrp')]//span[contains(@data-bind,'text: ')]")).getText();
      } catch (NoSuchElementException e) {
         size = "б/р";
      } finally {
         wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      }

      return size;
   }

   public void selectCityForDilivery(String city) {
      type(By.id("citySuggester"), city);
      waitForElementInvisible(By.xpath("//div[contains(@data-bind,\"showLoader\")]"), 5);
      waitLoadingElement(By.xpath(String.format("//b[contains(text(),'%s')]", city)), 5);
      wd.findElement(By.xpath(String.format("//b[contains(text(),'%s')]", city))).click();
      waitForElementInvisible(By.xpath("//div[contains(@data-bind,\"showLoader\")]"), 5);

   }

   public void selectDeliveryService(String service) {
      waitLoadingElement(By.xpath(String.format("//span[contains(text(),'%s')]", service)),5);
      wd.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", service))).click();
   }

   public void submitOrder() {
      waitForElementInvisible(By.xpath("//div[contains(@data-bind,\"showLoader\")]"), 5);
      waitLoadingElement(By.xpath("//div[contains(@data-bind,'click: sendOrder')]"), 5);
      wd.findElement(By.xpath("//div[contains(@data-bind,'click: sendOrder')]")).click();
      waitForElementInvisible(By.xpath("//div[contains(@data-bind,\"showLoader\")]"), 10);
   }

   public boolean isSuccesOrder() {
      waitLoadingElement(By.xpath("//div[contains(@class,'hidden-xs') and text() = 'продолжить покупки']"), 5);
      System.out.println("Заказ № " + wd.findElement(By.xpath("//span[contains(@data-bind,'orderNumber')]")).getText());
      return wd.findElement(By.xpath("//div[contains(@class,'hidden-xs') and text() = 'продолжить покупки']")).isDisplayed();
   }

   public void addNewAddress() {
      wd.findElement(By.xpath("//span[contains(@data-bind,'html: selectedItem()')]")).click();
      wd.findElement(By.xpath("//li[contains(@data-bind,'newAddressItem')]")).click();
      waitForElementInvisible(By.xpath("//div[contains(@data-bind,\"showLoader\")]"), 5);
   }

   public void fillAddressForm(String street, String house, String flat) {
      type(By.id("streetSuggester"), street);
      waitLoadingElement(By.xpath(String.format("//b[contains(text(),'%s')]", street)),5);
      click(By.xpath(String.format("//b[contains(text(),'%s')]", street)));
      waitLoadingElement(By.id("houseSuggester"),5);
      type(By.id("houseSuggester"), house);
   }

   public void fillBuyerFrom(String testName, String phone, String testEmail) {
      type(By.name("name"), testName);
      type(By.name("phone"), phone);
      type(By.name("email"), testEmail);
   }

   public void openDeliveryPointMap() {
      wd.findElement(By.xpath("//span[contains(@class,'hidden-xs') and text() = 'Выбрать']")).click();
      waitLoadingElement(By.xpath("//td[contains(@class,'arcticmodal-container_i2')]"), 5);
      waitLoadingElement(By.xpath("//ymaps[contains(@class,'places-pane')]"),5);
      waitLoadingElement(By.cssSelector("div.arcticmodal-container"), 5);

   }

   public void selectDeliveryPoint(String subway, String street, By point) {
      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      waitLoadingElement(By.xpath("//ymaps[contains(@class,'places-pane')]"),5);
      waitLoadingElement(By.cssSelector("div.arcticmodal-container"), 5);
      waitLoadingElement(By.id("map"), 5);

      if (subway != null) {
         waitLoadingElement(By.id("subwaySuggester"), 5);
         type(By.id("subwaySuggester"), subway);
         waitLoadingElement(By.xpath(String.format("//b[contains(text(),'%s')]", subway)), 5);
         click(By.xpath(String.format("//b[contains(text(),'%s')]", subway)));
      }
      if (street != null) {
         waitLoadingElement(By.id("addressSuggester"), 5);
         type(By.id("addressSuggester"), street);
         waitLoadingElement(By.xpath(String.format("//b[contains(text(),'%s')]", street)), 5);
         click(By.xpath(String.format("//b[contains(text(),'%s')]", street)));
      }
      waitLoadingElement(By.cssSelector("div.arcticmodal-container"), 5);
      moveTo(By.cssSelector("div.arcticmodal-container"));
      moveTo(point);
      waitLoadingElement(point, 5);
      click(point);
      moveTo(By.xpath("//div[@id='map']//button[.='Выбрать']"));
      click(By.xpath("//div[@id='map']//button[.='Выбрать']"));
      waitForElementInvisible(By.cssSelector("div.arcticmodal-container"), 5);

   }

   public void selectPaymentMethod(String paymentMethod) {
      waitLoadingElement(By.xpath(String.format("//div[contains(text(),'%s')]", paymentMethod)), 5);
      click(By.xpath(paymentMethod));
   }
}
