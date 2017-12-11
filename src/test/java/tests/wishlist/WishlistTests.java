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

      app.getNavigationHelper().openAuthorizationPopUp();
      app.getAuthorizationHelper().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.getAuthorizationHelper().submitPopUpLoginData();
      app.getHeaderHelper().gotoWishlist();

      Assert.assertNotEquals(app.getHeaderHelper().getWishlistItemscount(), 0);
   }

   @Test
   public void testAddtoWishlistCounterIncrementFromProductCard() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";


      app.getNavigationHelper().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-black-gubka/");
      app.getNavigationHelper().openAuthorizationPopUp();
      app.getAuthorizationHelper().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.getAuthorizationHelper().submitPopUpLoginData();
      app.getProductCardHelpers().addToWishlist();
      app.getHeaderHelper().gotoWishlist();

      Assert.assertEquals(app.getHeaderHelper().getWishlistItemscount(), 48);
   }

   @Test
   public void testWishlistCounterDecrementFromProductCard() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";

      app.getNavigationHelper().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-black-gubka/");
      app.getNavigationHelper().openAuthorizationPopUp();
      app.getAuthorizationHelper().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.getAuthorizationHelper().submitPopUpLoginData();
      app.getProductCardHelpers().removeFromlist();
      app.getHeaderHelper().gotoWishlist();

      Assert.assertEquals(app.getHeaderHelper().getWishlistItemscount(), 47);
   }

   @Test
   public void testWishlistDeleteItemFromCheckout(){

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";

      app.getNavigationHelper().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-gubka/");
      app.getNavigationHelper().openAuthorizationPopUp();
      app.getAuthorizationHelper().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.getAuthorizationHelper().submitPopUpLoginData();
      app.getProductCardHelpers().addToWishlist();
      app.getProductCardHelpers().addToCart();
      app.getNavigationHelper().gotoCheckout();
      app.getCheckoutHelper().deleteItemFromWishlist();
      app.getNavigationHelper().openUrl(baseUrl);
      app.getHeaderHelper().gotoWishlist();

      Assert.assertEquals(app.getHeaderHelper().getWishlistItemscount(), 47);

   }


}
