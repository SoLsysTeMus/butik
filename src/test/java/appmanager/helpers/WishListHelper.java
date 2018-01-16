package appmanager.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import model.ProductData;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static tests.BaseTest.baseTimeout;

public class WishListHelper extends BaseHelper {


   public ProductData getProductDataForItems(int i) {
      ElementsCollection products = getAllProductsInWishListFromPage();

      SelenideElement element = products.get(i);
      String label = getStickerForProduct(element);
      String brand = element.$x(".//div[contains(@class, 'brand-name p-brand')]").getText();
      String name = element.$x(".//div[contains(@class, 'summary p-name')]").getText();
      Integer price = getPriceForProduct(element);

      return new ProductData()
              .withLabel(label)
              .withBrandName(brand)
              .withName(name)
              .withPrice(price);
   }

   public Integer getPriceForProduct(SelenideElement element) {
      if (element.$x(".//div[contains(@class, 'price')]").getText().equals("РАСПРОДАНО")) {
         System.out.println(element.$x(".//div[contains(@class, 'price')]").getText());
         return -1;
      } else {
         return Integer.valueOf(element.$x(".//div[contains(@class, 'price')]").getText().replaceAll("\\D", ""));
      }
   }

   public String getStickerForProduct(SelenideElement element) {
      String sticker;
      Configuration.screenshots = false;
      Configuration.timeout = 2500;
      try {
         sticker = element.$x(".//div[contains(@class, 'sticker')]").getText();
      } catch (ElementNotFound e) {
         sticker = null;
      } finally {
         Configuration.screenshots = true;
         Configuration.timeout = baseTimeout;
      }
      return sticker;
   }

   public ElementsCollection getAllProductsInWishListFromPage() {
      return $$(".product-card.h-product");
   }

   public void removeItem(int i) {
      ElementsCollection products = getAllProductsInWishListFromPage();

      SelenideElement element = products.get(i);
      element.$x(".//span[contains(@class, 'wishlist__like')]").click();
      sleep(2000);
   }
}
