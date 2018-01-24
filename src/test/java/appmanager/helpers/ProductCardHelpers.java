package appmanager.helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ex.ElementNotFound;
import model.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static tests.BaseTest.baseTimeout;

public class ProductCardHelpers extends BaseHelper {

   @Step("Добавление товара в WishList из карточки товара")
   public void addToWishlist() {
      if (!$x("//button[contains(@class, 'm-wished')]").is(Condition.visible)) {
         click(By.xpath("//button[contains(@data-bind,'toggleWishlist')]"));
         $(By.xpath("//button[contains(@class, 'm-wished')]")).shouldBe(Condition.visible);
      }
   }

   @Step("Удаление товара в WishList из карточки товара")
   public void removeFromList() {
      if ($x("//button[contains(@class, 'm-wished')]").is(Condition.visible)) {
         click(By.xpath("//button[contains(@data-bind,'toggleWishlist')]"));
         $(By.xpath("//button[contains(@class, 'm-wished')]")).shouldNotBe(Condition.visible);
      }
   }

   @Step("Удаление товара в корзину из карточки товара")
   public void addToCart() {
      click(By.xpath("//button[contains(@data-bind,'addToCart')]"));
   }

   @Step("Нажатие кнопки \"Оформить заказ\" на PopUp")
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

   @Step("Выбор размера в картчоке товара")
   public void selectSize(int i) {
      List sizes = getProductRusSizes();
      $(By.xpath(String.format(".//div[contains(@data-bind,'rus_size') and contains(text(),'%s')]", sizes.get(i)))).click();
   }

   public ProductData getProductData() {

      return new ProductData()
              .withBrandName(getTextForElement(By.xpath("//a[contains(@class, 'product-description__brand')]")))
              .withName(getTextForElement(By.xpath("//div[contains(@class,'hidden-xs')]//div[contains(@class, 'product-description__name')]")))
              .withPrice(Integer.valueOf(getTextForElement(By.cssSelector(".i-rub.i-xs-b")).replaceAll("\\D", "")))
              .withLabel(getLabelForProduct())
              .withSku(getSKUFromDescription());
   }

   public String getLabelForProduct() {
      Configuration.timeout = 1000;
      Configuration.screenshots = false;
      String label;
      try {
         label = getTextForElement(By.xpath("//div[contains(@class,'product-description__slider-wrap')]//div[contains(@class, 'sticker sticker-discount')]"));
      } catch (ElementNotFound e) {
         label = null;
      } finally {
         Configuration.timeout = baseTimeout;
         Configuration.screenshots = true;
      }
      return label;
   }

   public String getSKUFromDescription() {
      String sku;
      String description = getTextForElement(By.cssSelector(".product-description__params-info"));

      int index = description.indexOf("Артикул:");
      sku = description.substring(index).replace("Артикул:", "").trim();
      return sku;
   }
}
