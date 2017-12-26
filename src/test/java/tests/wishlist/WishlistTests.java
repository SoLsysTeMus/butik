package tests.wishlist;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import static appmanager.ApplicationManager.baseUrl;

public class WishlistTests extends BaseTest {

   @Test
   public void testWishlistCounterVisibleInHeader() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";

      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.header().gotoWishlist();

      Assert.assertNotEquals(app.header().getWishlistItemscount(), 0);
   }

   @Test
   public void testAddtoWishlistCounterIncrementFromProductCard() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";
      Integer itemsCount;


      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-black-gubka/");
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      itemsCount = app.header().getWishlistItemscount();
      app.productCard().addToWishlist();
      app.header().gotoWishlist();

      Assert.assertEquals(app.header().getWishlistItemscount(), ++itemsCount);
   }

   @Test
   public void testDeleteWishlistCounterDecrementFromProductCard() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";
      Integer itemsCount;

      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-black-gubka/");
      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      itemsCount = app.header().getWishlistItemscount();
      app.productCard().removeFromlist();
      app.header().gotoWishlist();

      Assert.assertEquals(app.header().getWishlistItemscount(), --itemsCount);
   }

   @Test
   public void testWishlistDeleteItemFromCheckout() {

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
      app.navigation().gotoCheckout();
      app.checkout().deleteItemFromWishlist();
      app.checkout().removeAllProducts();
      app.navigation().openUrl(baseUrl);
      app.header().gotoWishlist();

      Assert.assertEquals(app.header().getWishlistItemscount(), itemsCount);

   }

   @Test
   public void testWishlistDeleteItemFromCheckoutByOrder() {

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
      app.navigation().gotoCheckout();
      app.checkout().selectCityForDilivery("Москва");
      app.checkout().selectDeliveryService("Butik самовывоз");
      app.checkout().submitOrder();
      app.navigation().openUrl(baseUrl);
      app.header().gotoWishlist();

      Assert.assertEquals(app.header().getWishlistItemscount(), itemsCount);
   }

}
