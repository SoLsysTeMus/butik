package tests.productCard;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import static appmanager.ApplicationManager.baseUrl;

public class ProductCardTests extends BaseTest {

   @Test
   public void testAddItemWithOutSizesToNotAuthCart() {
      app.getNavigationHelper().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-colorit-tube-gold-krem/");
      app.getProductCardHelpers().addToCart();
      app.getNavigationHelper().openUrl(baseUrl + "products/zhenshchinam-sumki-sumki-malenkie-sumki-i-klatchi-fornarina-ae17be207p094-klatch/");
      app.getProductCardHelpers().addToCart();
      app.getProductCardHelpers().pressCheckoutButtonOnPopUp();

      Assert.assertEquals(app.getCheckoutHelper().getItemsInTheCartList().size(), 2);
   }

   @Test
   public void testAddItemWithSizesToNotAuthCart() {
      app.getNavigationHelper().openUrl(baseUrl + "products/zhenshchinam-odezhda-dzhinsy-skinni-alcott-5t2952dw649-grey-dzhinsy/");
      app.getProductCardHelpers().selectSize(1);
      app.getProductCardHelpers().addToCart();
      app.getProductCardHelpers().pressCheckoutButtonOnPopUp();

      Assert.assertEquals(app.getCheckoutHelper().getItemsInTheCartList().size(), 1);
   }


   @Test
   public void testAddItemWithOutSizesToAuthCart() {
      String testLoginEmail = "auth_test@auth.test";
      String testPassword = "12345";

      app.getNavigationHelper().openAuthorizationPopUp();
      app.getAuthorizationHelper().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.getAuthorizationHelper().submitPopUpLoginData();
      app.getNavigationHelper().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-colorit-tube-gold-krem/");
      app.getProductCardHelpers().addToCart();
      app.getNavigationHelper().openUrl(baseUrl + "products/zhenshchinam-sumki-sumki-malenkie-sumki-i-klatchi-fornarina-ae17be207p094-klatch/");
      app.getProductCardHelpers().addToCart();
      app.getProductCardHelpers().pressCheckoutButtonOnPopUp();

      Assert.assertEquals(app.getCheckoutHelper().getItemsInTheCartList().size(), 2);

      app.getCheckoutHelper().removeAllProducts();

      Assert.assertEquals(app.getCheckoutHelper().cartIsEmpty(),true);


   }

   @Test
   public void testAddItemWithSizesToAuthCart() {
      String testLoginEmail = "auth_test@auth.test";
      String testPassword = "12345";

      app.getNavigationHelper().openAuthorizationPopUp();
      app.getAuthorizationHelper().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.getAuthorizationHelper().submitPopUpLoginData();
      app.getNavigationHelper().openUrl(baseUrl + "products/zhenshchinam-odezhda-dzhinsy-skinni-alcott-5t2952dw649-grey-dzhinsy/");
      app.getProductCardHelpers().selectSize(1);
      app.getProductCardHelpers().addToCart();
      app.getProductCardHelpers().pressCheckoutButtonOnPopUp();

      Assert.assertEquals(app.getCheckoutHelper().getItemsInTheCartList().size(), 1);

      app.getCheckoutHelper().removeAllProducts();

      Assert.assertEquals(app.getCheckoutHelper().cartIsEmpty(),true);
   }
}
