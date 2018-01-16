package tests.wishlist;

import com.codeborne.selenide.Configuration;
import model.ProductData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.BaseTest;

import static appmanager.ApplicationManager.baseUrl;

@Features("WishList")
public class WishListTests extends BaseTest {

   @BeforeMethod
   public void cleanUpSession() {
      app.navigation().openUrl(Configuration.baseUrl);
   }

   @Title("Добавление б/р товара в wishlist из Карточки товара")
   @Severity(SeverityLevel.CRITICAL)
   @Test
   public void testAddToWishListItemWithoutSizeFromProductCard() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";

      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-black-gubka/");
      ProductData productInCard = app.productCard().getProductData();
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.productCard().addToWishlist();
      app.navigation().openWishlistPage();
      ProductData productInWishList = app.wishList().getProductDataForItems(0);

      Assert.assertEquals(productInCard.getBrandName(), productInWishList.getBrandName());
   }

   @Title("Добавление размерного товара в wishlist из Карточки товара")
   @Severity(SeverityLevel.CRITICAL)
   @Test
   public void testAddToWishListItemWithSizeFromProductCard() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";

      app.navigation().openUrl(baseUrl + "products/muzhchinam-obuv-botinki-nizkie-nobrand-92213-black-botinki/");
      ProductData productInCard = app.productCard().getProductData();
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.productCard().addToWishlist();
      app.navigation().openWishlistPage();
      ProductData productInWishList = app.wishList().getProductDataForItems(0);

      Assert.assertEquals(productInCard.getBrandName(), productInWishList.getBrandName());
   }


   @Title("Удаление б/р товара в wishlist из Карточки товара")
   @Severity(SeverityLevel.CRITICAL)
   @Test(dependsOnMethods = {"testAddToWishListItemWithoutSizeFromProductCard"})
   public void testDeleteWishListItemWithoutSizeFromProductCard() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";

      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-black-gubka/");
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      ProductData productInCard = app.productCard().getProductData();
      app.productCard().removeFromList();
      app.navigation().openWishlistPage();
      ProductData productInWishList = app.wishList().getProductDataForItems(0);

      Assert.assertNotEquals(productInCard.getBrandName(), productInWishList.getBrandName());
   }

   @Title("Удаление размерного товара в wishlist из Карточки товара")
   @Severity(SeverityLevel.CRITICAL)
   @Test(dependsOnMethods = {"testAddToWishListItemWithSizeFromProductCard"})
   public void testDeleteWishListItemWithSizeFromProductCard() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";

      app.navigation().openUrl(baseUrl + "products/muzhchinam-obuv-botinki-nizkie-nobrand-92213-black-botinki/");
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      ProductData productInCard = app.productCard().getProductData();
      app.productCard().removeFromList();
      app.navigation().openWishlistPage();
      ProductData productInWishList = app.wishList().getProductDataForItems(0);

      Assert.assertNotEquals(productInCard.getBrandName(), productInWishList.getBrandName());
   }

   @Title("Удаление товара в wishlist со страницы /checkout")
   @Severity(SeverityLevel.CRITICAL)
   @Test
   public void testWishListDeleteItemFromCheckout() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";
      Integer itemsCount;

      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-gubka/");
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      itemsCount = app.header().getWishlistItemscount();
      app.productCard().addToWishlist();
      app.productCard().addToCart();
      app.navigation().openCheckoutPage();
      app.checkout().deleteItemFromWishList();
      app.checkout().removeAllProducts();
      app.navigation().openWishlistPage();

      Assert.assertEquals(app.header().getWishlistItemscount(), itemsCount);
   }

   @Title("Удаление товара в wishlist при оформлении заказа")
   @Severity(SeverityLevel.NORMAL)
   @Test(dependsOnMethods = {"testWishListDeleteItemFromCheckout"})
   public void testWishListDeleteItemFromCheckoutByOrder() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";
      Integer itemsCount;

      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-gubka/");
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      itemsCount = app.header().getWishlistItemscount();
      app.productCard().addToWishlist();
      app.productCard().addToCart();
      app.navigation().openCheckoutPage();
      app.checkout().selectCityForDelivery("Москва");
      app.checkout().selectDeliveryService("Butik самовывоз");
      app.checkout().submitOrder();
      app.navigation().openUrl(baseUrl);

      Assert.assertEquals(app.header().getWishlistItemscount(), itemsCount);
   }

   @Title("Удаление товара из Избранного со страницы /wishlist")
   @Severity(SeverityLevel.CRITICAL)
   @Test
   public void testDeleteWishListItemFromWishListPage() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";

      app.navigation().openUrl(baseUrl + "products/zhenshchinam-sumki-sumki-srednie-coach-11854-dkpbu-sumka/");
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.productCard().addToWishlist();
      app.navigation().openWishlistPage();
      ProductData productInWishListBefore = app.wishList().getProductDataForItems(0);
      app.wishList().removeItem(0);
      ProductData productInWishListAfter = app.wishList().getProductDataForItems(0);


      Assert.assertNotEquals(productInWishListBefore.getBrandName(), productInWishListAfter.getBrandName());
   }
}
