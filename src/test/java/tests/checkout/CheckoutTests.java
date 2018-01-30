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
import static ru.yandex.qatools.allure.model.SeverityLevel.*;

@Features("Checkout")
public class CheckoutTests extends BaseTest {

   @BeforeMethod
   public void cleanUpSession() {
      app.navigation().openUrl(baseUrl);
   }

   @Severity(BLOCKER)
   @Title("Заказ на сохранённый адрес")
   @Test
   public void testOrderByAuthUserWithSavedAddress() {
      String login = testDataProperties.getProperty("checkoutLogin");
      String password = testDataProperties.getProperty("checkoutPassword");

      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(login, password);
      app.authorization().submitPopUpLoginData();
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-gubka/");
      app.productCard().addToCart();
      app.header().pressCheckoutButtonOnPopUp();
      app.checkout().submitOrder();

      Assert.assertTrue(app.checkout().isSuccessOrder());
   }

   @Severity(BLOCKER)
   @Title("Заказ на новый адрес для клиента с сохранённым адресом")
   @Test
   public void testOrderByAuthUserWithSavedAddressWithNewAddress() {
      String login = testDataProperties.getProperty("checkoutLogin");
      String password = testDataProperties.getProperty("checkoutPassword");

      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(login, password);
      app.authorization().submitPopUpLoginData();
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-gubka/");
      app.productCard().addToCart();
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-odezhda-dzhinsy-skinni-alcott-5t2952dw649-grey-dzhinsy/");
      app.productCard().selectSize(1);
      app.productCard().addToCart();
      app.header().pressCheckoutButtonOnPopUp();
      app.checkout().addNewAddress();
      app.checkout().selectCityForDelivery("Москва");
      app.checkout().selectDeliveryService("Butik доставка");
      app.checkout().fillAddressForm("Смоленская наб", "д 44", "1");
      app.checkout().submitOrder();

      Assert.assertTrue(app.checkout().isSuccessOrder());
   }

   @Severity(BLOCKER)
   @Title("Заказ с доставкой в регионы для неавторизованного пользователя")
   @Test
   public void testOrderByNotAuthUserWithRegionalDelivery() {
      String name = testDataProperties.getProperty("checkoutName");
      String email = testDataProperties.getProperty("checkoutLogin");
      String phone = testDataProperties.getProperty("checkoutPhone");

      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-gubka/");
      app.productCard().addToCart();
      app.header().pressCheckoutButtonOnPopUp();
      app.checkout().fillBuyerFrom(name, phone, email);
      app.checkout().selectCityForDelivery("Анапа");
      app.checkout().selectDeliveryService("DPD курьерская доставка");
      app.checkout().fillAddressForm("ул Первомайская", "4", "1");
      app.checkout().fillCommentaryForm("Test Order Commentary");
      app.checkout().submitOrder();

      Assert.assertTrue(app.checkout().isSuccessOrder());
   }

   @Severity(BLOCKER)
   @Title("Заказ с доставкой в ПВЗ для неавторизованного пользователя")
   @Test
   public void testOrderByNotAuthUserWithPickPointService() {
      String name = testDataProperties.getProperty("checkoutName");
      String email = testDataProperties.getProperty("checkoutLogin");
      String phone = testDataProperties.getProperty("checkoutPhone");

      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-mobil-gubka/");
      app.productCard().addToCart();
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-odezhda-dzhinsy-skinni-alcott-5t2952dw649-grey-dzhinsy/");
      app.productCard().selectSize(1);
      app.productCard().addToCart();
      app.header().pressCheckoutButtonOnPopUp();
      app.checkout().fillBuyerFrom(name, phone, email);
      app.checkout().selectCityForDelivery("Москва");
      app.checkout().selectDeliveryService("Доставка до пункта выдачи");
      app.checkout().openDeliveryPointMap();
      app.checkout().selectDeliveryPoint(null, "Хабаровская", By.cssSelector("ymaps.ymaps-2-1-60-events-pane.ymaps-2-1-60-user-selection-none"));
      app.checkout().submitOrder();

      Assert.assertTrue(app.checkout().isSuccessOrder());
   }

}
