package tests.wishlist;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import tests.BaseTest;

import static appmanager.ApplicationManager.baseUrl;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

@Features("WishList")
public class WishlistTests extends BaseTest {

   @BeforeMethod
   public void cleanUpSession() {
      clearBrowserCookies();
      clearBrowserCache();
      app.navigation().openUrl(Configuration.baseUrl);
   }

   @Test
   public void testWishlistCounterVisibleInHeader() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";

      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.navigation().openWishlistPage();

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
      app.navigation().openWishlistPage();

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
      app.productCard().removeFromList();
      app.navigation().openWishlistPage();

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
      app.navigation().openCheckoutPage();
      app.checkout().deleteItemFromWishlist();
      app.checkout().removeAllProducts();
      app.navigation().openWishlistPage();

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
      app.navigation().openCheckoutPage();
      app.checkout().selectCityForDelivery("Москва");
      app.checkout().selectDeliveryService("Butik самовывоз");
      app.checkout().submitOrder();
      app.navigation().openUrl(baseUrl);

      Assert.assertEquals(app.header().getWishlistItemscount(), itemsCount);
   }

}
