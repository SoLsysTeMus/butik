package tests.wishlist;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CheckWishlistCounter extends BaseTest{

    @Test
    public void testWishlistCounter(){

       String testLoginEmail = "testwishlist@testwishlist.ru";
       String testPassword = "12345";

       app.getNavigationHelper().openAuthorizationPopUp();
       app.getAuthorizationHelper().fillPopUpAuthorizationForm(testLoginEmail,testPassword);
       app.getAuthorizationHelper().submitPopUpLoginData();
       app.getHeaderHelper().gotoWishlist();

       Assert.assertEquals(app.getHeaderHelper().getWishlistItemscount(),47);
    }

}
