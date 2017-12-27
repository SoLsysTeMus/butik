package tests.checkout;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import static appmanager.ApplicationManager.baseUrl;

public class CheckoutTests extends BaseTest {

   @Test
   public void testOrderByAuthUserWithSavedAddress() {
      String testLoginEmail = "checkoutaddress@test.ru";
      String testPassword = "12345";

      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-gubka/");
      app.productCard().addToCart();
      app.productCard().pressCheckoutButtonOnPopUp();
      app.checkout().submitOrder();

      Assert.assertEquals(app.checkout().isSuccesOrder(), true);
   }

   @Test
   public void testOrderByAuthUserWithSavedAddressWithNewAddress() {
      String testLoginEmail = "checkoutaddress@test.ru";
      String testPassword = "12345";

      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-gubka/");
      app.productCard().addToCart();
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-odezhda-dzhinsy-skinni-alcott-5t2952dw649-grey-dzhinsy/");
      app.productCard().selectSize(1);
      app.productCard().addToCart();
      app.productCard().pressCheckoutButtonOnPopUp();
      app.checkout().addNewAddress();
      app.checkout().selectCityForDilivery("Москва");
      app.checkout().selectDeliveryService("Butik доставка");
      app.checkout().fillAddressForm("Смоленская наб", "44", "1");
      app.checkout().submitOrder();

      Assert.assertEquals(app.checkout().isSuccesOrder(), true);
   }

   @Test
   public void testOrderByNotAuthUserWithRegionalDelivery() {
      String testName = "test";
      String testEmail = "checkoutaddress@test.ru";
      String phone = "+7(964)538-80-80";
      String commentText = "Test Order Commentary";

      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-gubka/");
      app.productCard().addToCart();
      app.productCard().pressCheckoutButtonOnPopUp();
      app.checkout().fillBuyerFrom(testName, phone, testEmail);
      app.checkout().selectCityForDilivery("Уфа");
      app.checkout().selectDeliveryService("DPD курьерская доставка");
      app.checkout().fillAddressForm("Смоленская", "34", "1");
      app.checkout().fillCommentaryForm(commentText);
      app.checkout().submitOrder();

      Assert.assertEquals(app.checkout().isSuccesOrder(), true);
   }

   @Test
   public void testOrderByNotAuthUserWithPickPointService() {
      String testName = "test";
      String testEmail = "checkoutaddress@test.ru";
      String phone = "+7(964)538-80-80";

      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-gubka/");
      app.productCard().addToCart();
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-odezhda-dzhinsy-skinni-alcott-5t2952dw649-grey-dzhinsy/");
      app.productCard().selectSize(1);
      app.productCard().addToCart();
      app.productCard().pressCheckoutButtonOnPopUp();
      app.checkout().fillBuyerFrom(testName, phone, testEmail);
      app.checkout().selectCityForDilivery("Москва");
      app.checkout().selectDeliveryService("Доставка до пункта выдачи");
      app.checkout().openDeliveryPointMap();
      app.checkout().selectDeliveryPoint(null, "Хабаровская", By.cssSelector("ymaps.ymaps-2-1-59-events-pane.ymaps-2-1-59-user-selection-none"));
      app.checkout().submitOrder();

      Assert.assertEquals(app.checkout().isSuccesOrder(), true);
   }

}
