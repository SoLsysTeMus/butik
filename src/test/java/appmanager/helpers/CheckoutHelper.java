package appmanager.helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import model.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static tests.BaseTest.baseTimeout;

public class CheckoutHelper extends BaseHelper {

   @Step("Удаление товара из WishList")
   public void deleteItemFromWishList() {
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

   private List<WebElement> getAllItemsFromCart() {
      WebElement table = $(By.xpath("//div[contains(@data-bind,'foreach: items')]"));
      return table.findElements(By.xpath("//div[contains(@class,'cart__item')]"));
   }

   @Step("Удаление всех товаров из корзины")
   public void removeAllProducts() {
      int counter = getItemsInTheCartList().size();
      for (int i = 0; i < counter; i++) {
         $(By.xpath("//p[contains(@class,'hidden-xs')]//span[contains(@data-bind,'removeProduct')]")).click();
         waitLoader();
      }
   }

   @Step("Проверка на отсутствие товаров в корзине")
   public boolean cartIsEmpty() {
      return $(By.xpath("//div[contains(text(),'В корзину ничего не добавлено')]")).shouldBe(Condition.visible).isDisplayed();
   }

   private String getSelectedSizeForProduct(WebElement product) {
      String size;
      Configuration.timeout = 2500;
      try {
         size = product.findElement(By.xpath(".//div[contains(@class,'nowrp')]//span[contains(@data-bind,'text: ')]")).getText();
      } catch (NoSuchElementException e) {
         size = "б/р";
      } finally {
         Configuration.timeout = baseTimeout;
      }

      return size;
   }

   @Step("Выбор города доставки")
   public void selectCityForDelivery(String city) {
      waitLoader();
      $(By.id("citySuggester")).setValue(city);
      sleep(2000);
      $(By.id("citySuggester")).pressEnter();
      waitLoader();
   }

   @Step("Выбор способа доставки")
   public void selectDeliveryService(String service) {
      $(By.xpath(String.format("//span[contains(text(),'%s')]", service))).click();
   }

   @Step("Нажатие кнопки \"Отправить заказ\"")
   public void submitOrder() {
      waitLoader();
      $(By.xpath("//div[contains(@data-bind,'click: sendOrder')]")).click();
      waitLoader();

   }

   @Step("Заказ успешно сохранён в базе")
   public boolean isSuccessOrder() {
      System.out.println("Заказ № " + getTextForElement(By.xpath("//span[contains(@data-bind,'orderNumber')]")));
      return $(By.xpath("//div[contains(@class,'hidden-xs') and text() = 'продолжить покупки']")).isDisplayed();
   }

   @Step("Выбор добавления нового адреса")
   public void addNewAddress() {
      waitLoader();
      click(By.xpath("//span[contains(@data-bind,'html: selectedItem()')]"));
      click(By.xpath("//li[contains(@data-bind,'newAddressItem')]"));
      waitLoader();
   }

   @Step("Заполнение адреса")
   public void fillAddressForm(String street, String house, String flat) {
      waitLoader();
      type(By.id("streetSuggester"), street);
      sleep(1000);
      $(By.id("streetSuggester")).pressEnter();
      type(By.id("houseSuggester"), house);
      sleep(1000);
      $(By.id("houseSuggester")).pressEnter();
      type(By.name("flat"), flat);
   }

   @Step("Заполнение данных покупателя")
   public void fillBuyerFrom(String testName, String phone, String testEmail) {
      type(By.name("name"), testName);
      type(By.name("phone"), phone);
      type(By.name("email"), testEmail);
   }

   @Step("Открытие карты ПВЗ")
   public void openDeliveryPointMap() {
      waitLoader();
      sleep(1000);
      $(By.xpath("//span[contains(@class,'hidden-xs') and text() = 'Выбрать']")).click();
      $(By.xpath("//div[contains(@class,'arcticmodal-container')]//ymaps[contains(@class,'ymaps-2-1-60-places-pane')]")).should(Condition.visible);
   }

   @Step("Выбор пункта выдачи на карте ПВЗ")
   public void selectDeliveryPoint(String subway, String street, By point) {

      if (subway != null) {
         type(By.id("subwaySuggester"), subway);
         sleep(500);
         click(By.xpath(String.format("//b[contains(text(),'%s')]", subway)));
      }
      if (street != null) {
         type(By.id("addressSuggester"), street);
         sleep(500);
         click(By.xpath(String.format("//b[contains(text(),'%s')]", street)));
      }
      sleep(500);
      $(point).shouldBe(Condition.visible);
      $(point).hover();
      moveTo(point);
      $(point).click();


      $(By.xpath("//div[@id='map']//button[.='Выбрать']")).hover().click();
      $(By.xpath("//div[contains(@class,'arcticmodal-container')]")).shouldNotBe(Condition.visible);
   }

   public void selectPaymentMethod(String paymentMethod) {
      click(By.xpath(paymentMethod));
   }

   @Step("Заполнение комментария к заказу")
   public void fillCommentaryForm(String commentText) {
      click(By.xpath("//span[contains(@data-bind,'OrderDescription')]"));
      type(By.id("order-description"), commentText);
   }
}
