package tests.productCard;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static org.testng.Assert.assertTrue;

@Features("Карточка товара")
public class ProductCardTests extends BaseTest {

   @BeforeMethod
   public void cleanUpSession() {
      clearBrowserCookies();
      clearBrowserCache();
      app.navigation().openUrl(baseUrl);
   }

   @Title("Добавление б/р товара в корзину для неавторизованного пользователя")
   @Severity(SeverityLevel.CRITICAL)
   @Test
   public void testAddItemWithOutSizesToNotAuthCart() {
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-colorit-tube-gold-krem/");
      app.productCard().addToCart();
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-sumki-sumki-malenkie-sumki-i-klatchi-fornarina-ae17be207p094-klatch/");
      app.productCard().addToCart();
      app.productCard().pressCheckoutButtonOnPopUp();

      Assert.assertEquals(app.checkout().getCartItemsCount().size(), 2);
   }

   @Title("Добавление размерного товара в корзину для неавторизованного пользователя")
   @Severity(SeverityLevel.CRITICAL)
   @Test
   public void testAddItemWithSizesToNotAuthCart() {
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-odezhda-dzhinsy-skinni-alcott-5t2952dw649-grey-dzhinsy/");
      app.productCard().selectSize(1);
      app.productCard().addToCart();
      app.productCard().pressCheckoutButtonOnPopUp();

      Assert.assertEquals(app.checkout().getCartItemsCount().size(), 1);
   }

   @Title("Добавление б/р товара в корзину для авторизованного пользователя")
   @Severity(SeverityLevel.CRITICAL)
   @Test
   public void testAddItemWithOutSizesToAuthCart() {
      String testLoginEmail = "auth_test2@auth.test";
      String testPassword = "12345";

      app.navigation().openAuthorizationPopUp();
      app.authorization().fillPopUpAuthorizationForm(testLoginEmail, testPassword);
      app.authorization().submitPopUpLoginData();
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-obuv-sredstva-po-ukhodu-za-obuvyu-collonil-colorit-tube-gold-krem/");
      app.productCard().addToCart();
      app.navigation().openUrl(baseUrl + "products/zhenshchinam-sumki-sumki-malenkie-sumki-i-klatchi-fornarina-ae17be207p094-klatch/");
      app.productCard().addToCart();
      app.productCard().pressCheckoutButtonOnPopUp();

      Assert.assertEquals(app.checkout().getCartItemsCount().size(), 2);

      app.checkout().removeAllProducts();
      assertTrue(app.checkout().isCartEmpty());
   }

   @Title("Добавление размерного товара в корзину для авторизованного пользователя")
   @Severity(SeverityLevel.CRITICAL)
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

      Assert.assertEquals(app.checkout().getCartItemsCount().size(), 1);
      app.checkout().removeAllProducts();

      Assert.assertTrue(app.checkout().isCartEmpty());
   }
}
