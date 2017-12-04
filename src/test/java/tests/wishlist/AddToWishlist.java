package tests.wishlist;

import org.testng.annotations.Test;
import tests.BaseTest;

public class AddToWishlist extends BaseTest{

    @Test
    public void testAddToWishlistFromProductCard(){

       String testLoginEmail = "testwishlist@testwishlist.ru";
       String testPassword = "12345";

       app.getNavigationHelper().openAuthorizationPopUp();
       app.getAuthorizationHelper().fillPopUpAuthorizationForm(testLoginEmail,testPassword);
       app.getAuthorizationHelper().submitPopUpLoginData();
       app.getHeaderHelper().gotoWishlist();


    }

}
