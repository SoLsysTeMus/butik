package tests.wishlist;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Features("WishList")
public class WishListTests extends BaseTest {

   @BeforeMethod
   public void cleanUpSession() {
      app.navigation().openUrl(baseUrl);
   }

   @Title("Добавление б/р товара в wishlist из Карточки товара")
   @Severity(SeverityLevel.CRITICAL)
   @Test
   public void testAddToWishListItemWithoutSizeFromProductCard() {
      String testLoginEmail = testDataProperties.getProperty("wishListLogin");
      String testPassword = testDataProperties.getProperty("wishListPassword");
      String productUrl = "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-black-gubka/";

      app.navigation().openUrl(baseUrl + productUrl);
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.productCard().addToWishlist();
      app.navigation().openWishListPage();

      assertTrue(app.wishList().isContainsProductWithUrl(productUrl));
   }

   @Title("Добавление размерного товара в wishlist из Карточки товара")
   @Severity(SeverityLevel.CRITICAL)
   @Test
   public void testAddToWishListItemWithSizeFromProductCard() {
      String testLoginEmail = testDataProperties.getProperty("wishListLogin");
      String testPassword = testDataProperties.getProperty("wishListPassword");
      String productUrl = "products/muzhchinam-obuv-botinki-nizkie-nobrand-92213-black-botinki/";

      app.navigation().openUrl(baseUrl + productUrl);
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.productCard().addToWishlist();
      app.navigation().openWishListPage();

      assertTrue(app.wishList().isContainsProductWithUrl(productUrl));
   }


   @Title("Удаление б/р товара в wishlist из Карточки товара")
   @Severity(SeverityLevel.CRITICAL)
   @Test(dependsOnMethods = {"testAddToWishListItemWithoutSizeFromProductCard"})
   public void testDeleteWishListItemWithoutSizeFromProductCard() {
      String testLoginEmail = testDataProperties.getProperty("wishListLogin");
      String testPassword = testDataProperties.getProperty("wishListPassword");
      String productUrl = "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-black-gubka/";

      app.navigation().openUrl(baseUrl + productUrl);
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.productCard().removeFromList();
      app.navigation().openWishListPage();

      assertFalse(app.wishList().isContainsProductWithUrl(productUrl));
   }

   @Title("Удаление размерного товара в wishlist из Карточки товара")
   @Severity(SeverityLevel.CRITICAL)
   @Test(dependsOnMethods = {"testAddToWishListItemWithSizeFromProductCard"})
   public void testDeleteWishListItemWithSizeFromProductCard() {
      String testLoginEmail = testDataProperties.getProperty("wishListLogin");
      String testPassword = testDataProperties.getProperty("wishListPassword");
      String productUrl = "products/muzhchinam-obuv-botinki-nizkie-nobrand-92213-black-botinki/";

      app.navigation().openUrl(baseUrl + productUrl);
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.productCard().removeFromList();
      app.navigation().openWishListPage();

      assertFalse(app.wishList().isContainsProductWithUrl(productUrl));
   }

   @Title("Удаление товара в wishlist со страницы /checkout")
   @Severity(SeverityLevel.CRITICAL)
   @Test
   public void testWishListDeleteItemFromCheckout() {
      String testLoginEmail = testDataProperties.getProperty("wishListLogin");
      String testPassword = testDataProperties.getProperty("wishListPassword");
      String productUrl = "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-gubka/";

      app.navigation().openUrl(baseUrl + productUrl);
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.productCard().addToWishlist();
      app.productCard().addToCart();
      app.navigation().openCheckoutPage();
      app.checkout().deleteItemFromWishList();
      app.checkout().removeAllProducts();
      app.navigation().openWishListPage();

      assertFalse(app.wishList().isContainsProductWithUrl(productUrl));
   }

   @Title("Удаление товара в wishlist при оформлении заказа")
   @Severity(SeverityLevel.NORMAL)
   @Test(dependsOnMethods = {"testWishListDeleteItemFromCheckout"})
   public void testWishListDeleteItemFromCheckoutByOrder() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";
      String productUrl = "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-gubka/";

      app.navigation().openUrl(baseUrl + productUrl);
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.productCard().addToWishlist();
      app.productCard().addToCart();
      app.navigation().openCheckoutPage();
      app.checkout().selectCityForDelivery("Москва");
      app.checkout().selectDeliveryService("Butik самовывоз");
      app.checkout().submitOrder();
      app.navigation().openWishListPage();

      assertFalse(app.wishList().isContainsProductWithUrl(productUrl));
   }

   @Title("Удаление товара из Избранного со страницы /wishlist")
   @Severity(SeverityLevel.CRITICAL)
   @Test
   public void testDeleteWishListItemFromWishListPage() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";
      String productUrl = "products/zhenshchinam-sumki-sumki-srednie-coach-11854-dkpbu-sumka/";

      app.navigation().openUrl(baseUrl + productUrl);
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.productCard().addToWishlist();
      app.navigation().openWishListPage();
      app.wishList().removeItem(0);

      assertFalse(app.wishList().isContainsProductWithUrl(productUrl));
   }
}
