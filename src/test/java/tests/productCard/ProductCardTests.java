package tests.productCard;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

import static appmanager.ApplicationManager.baseUrl;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class ProductCardTests extends BaseTest {

   @BeforeMethod
   public void cleanUpSession() {
      clearBrowserCookies();
      clearBrowserCache();
      app.navigation().openUrl(baseUrl);
   }

   @Test
   public void testAddItemWithOutSizesToNotAuthCart() {
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-colorit-tube-gold-krem/");
      app.productCard().addToCart();
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-sumki-sumki-malenkie-sumki-i-klatchi-fornarina-ae17be207p094-klatch/");
      app.productCard().addToCart();
      app.productCard().pressCheckoutButtonOnPopUp();

      System.out.println(app.checkout().getItemsInTheCartList());

      Assert.assertEquals(app.checkout().getItemsInTheCartList().size(), 2);
   }

   @Test
   public void testAddItemWithSizesToNotAuthCart() {
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-odezhda-dzhinsy-skinni-alcott-5t2952dw649-grey-dzhinsy/");
      app.productCard().selectSize(1);
      app.productCard().addToCart();
      app.productCard().pressCheckoutButtonOnPopUp();

      System.out.println(app.checkout().getItemsInTheCartList());

      Assert.assertEquals(app.checkout().getItemsInTheCartList().size(), 1);
   }


   @Test
   public void testAddItemWithOutSizesToAuthCart() {
      String testLoginEmail = "auth_test@auth.test";
      String testPassword = "12345";

      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-colorit-tube-gold-krem/");
      app.productCard().addToCart();
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-sumki-sumki-malenkie-sumki-i-klatchi-fornarina-ae17be207p094-klatch/");
      app.productCard().addToCart();
      app.productCard().pressCheckoutButtonOnPopUp();

      System.out.println(app.checkout().getItemsInTheCartList());

      Assert.assertEquals(app.checkout().getItemsInTheCartList().size(), 2);

      app.checkout().removeAllProducts();

      Assert.assertEquals(app.checkout().cartIsEmpty(), true);


   }

   @Test
   public void testAddItemWithSizesToAuthCart() {
      String testLoginEmail = "auth_test@auth.test";
      String testPassword = "12345";

      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-odezhda-dzhinsy-skinni-alcott-5t2952dw649-grey-dzhinsy/");
      app.productCard().selectSize(1);
      app.productCard().addToCart();
      app.productCard().pressCheckoutButtonOnPopUp();

      System.out.println(app.checkout().getItemsInTheCartList());

      Assert.assertEquals(app.checkout().getItemsInTheCartList().size(), 1);

      app.checkout().removeAllProducts();

      Assert.assertEquals(app.checkout().cartIsEmpty(), true);
   }
}
