package tests.wishlist;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CheckWishlistCounter extends BaseTest {


   @Test
   public void testWishlistCounter() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";

      app.getNavigationHelper().openAuthorizationPopUp();
      app.getAuthorizationHelper().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.getAuthorizationHelper().submitPopUpLoginData();
      app.getHeaderHelper().gotoWishlist();

      Assert.assertEquals(app.getHeaderHelper().getWishlistItemscount(), 48);
   }

   @Test
   public void testAddtoWishlistCounterIncrementFromProductCard() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";

      app.getMainMenuHelper().gotoCategory(By.xpath("//header/div[2]/div[4]/nav[1]/div[1]/span"));
      app.getNavigationHelper().openAuthorizationPopUp();
      app.getAuthorizationHelper().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.getAuthorizationHelper().submitPopUpLoginData();
      app.getCatalogHelper().openFirstProductCard();
      app.getProductCardHelpers().addToWishlist();
      app.getHeaderHelper().gotoWishlist();

      Assert.assertEquals(app.getHeaderHelper().getWishlistItemscount(), 48);
   }

   @Test
   public void testWishlistCounterDecrementFromProductCard() {

      String testLoginEmail = "testwishlist@testwishlist.ru";
      String testPassword = "12345";

      app.getMainMenuHelper().gotoCategory(By.xpath("//header/div[2]/div[4]/nav[1]/div[1]/span"));
      app.getNavigationHelper().openAuthorizationPopUp();
      app.getAuthorizationHelper().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.getAuthorizationHelper().submitPopUpLoginData();
      app.getCatalogHelper().openFirstProductCard();
      app.getProductCardHelpers().ramoveFromlist();
      app.getHeaderHelper().gotoWishlist();

      Assert.assertEquals(app.getHeaderHelper().getWishlistItemscount(), 47);
   }


}
