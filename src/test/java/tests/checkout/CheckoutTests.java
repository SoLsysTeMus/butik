package tests.checkout;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;

@Features("Checkout")
public class CheckoutTests extends BaseTest {

   @BeforeMethod
   public void cleanUpSession() {
      app.navigation().openUrl(baseUrl);
   }

   @Severity(SeverityLevel.BLOCKER)
   @Title("Заказ на сохранённый адрес")
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

      Assert.assertEquals(app.checkout().isSuccessOrder(), true);
   }

   @Severity(SeverityLevel.BLOCKER)
   @Title("Заказ на новый адрес для клиента с сохранённым адресом")
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
      app.checkout().selectCityForDelivery("Москва");
      app.checkout().selectDeliveryService("Butik доставка");
      app.checkout().fillAddressForm("Смоленская наб", "д 44", "1");
      app.checkout().submitOrder();

      Assert.assertEquals(app.checkout().isSuccessOrder(), true);
   }

   @Severity(SeverityLevel.BLOCKER)
   @Title("Заказ с доставкой в регионы для неавторизованного пользователя")
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
      app.checkout().selectCityForDelivery("Анапа");
      app.checkout().selectDeliveryService("DPD курьерская доставка");
      app.checkout().fillAddressForm("ул Первомайская", "4", "1");
      app.checkout().fillCommentaryForm(commentText);
      app.checkout().submitOrder();

      Assert.assertEquals(app.checkout().isSuccessOrder(), true);
   }

   @Severity(SeverityLevel.BLOCKER)
   @Title("Заказ с доставкой в ПВЗ для неавторизованного пользователя")
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
      app.checkout().selectCityForDelivery("Москва");
      app.checkout().selectDeliveryService("Доставка до пункта выдачи");
      app.checkout().openDeliveryPointMap();
      app.checkout().selectDeliveryPoint(null, "Хабаровская", By.cssSelector("ymaps.ymaps-2-1-60-events-pane.ymaps-2-1-60-user-selection-none"));
      app.checkout().submitOrder();

      Assert.assertEquals(app.checkout().isSuccessOrder(), true);
   }

}
