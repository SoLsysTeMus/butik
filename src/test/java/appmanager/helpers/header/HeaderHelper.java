package appmanager.helpers.header;

import appmanager.helpers.BaseHelper;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderHelper extends BaseHelper {

   public void openPersonalMenu() {
      $(By.xpath("//header/div[2]/div[5]/div[4]/div/div[1]/span")).waitUntil(Condition.visible, 7);
      moveTo(By.xpath("//header/div[2]/div[5]/div[4]/div/div[1]/span"));
   }

   public void gotoWishlist() {
      click(By.xpath("//header/div[2]/div[5]/div[3]/a"));
   }

   public Integer getWishlistItemscount() {
      return Integer.parseInt(getTextForElement(By.xpath("//header/div[2]/div[5]/div[3]/a/span")));
   }

   public void checkUserName(String name) {
      $(By.xpath("//header/div[2]/div[5]/div[4]/div/div[1]/span")).shouldBe(Condition.text(name));
   }

   public void openPopUpCart() {
      $(".header__cart").hover();
   }

   public String getActiveGender() {
      return $(By.xpath("//div[contains(@class,'cln-xs_12 top-line hidden-xs')]//a[contains(@class,'gender  active')]")).getText();
   }

   public void gotoAboutPage() {
      $(By.xpath("//div[contains(@class,'hidden-xs')]//a[contains(@href,'about')]")).click();
   }

   public void openSearchForm() {
      $(".header__search").click();
   }

   public void checkSearchFieldIsVisible() {
      $(By.xpath("//input[contains(@placeholder,'Что вы ищете?')]")).shouldBe(Condition.visible);
   }

   public void checkAboutLinkIsActive() {
      $(By.xpath("//div[contains(@class,'hidden-xs')]//a[contains(@class,'store  active')]")).shouldBe(Condition.visible);
   }

   public void checkSearchButtonIsVisible() {
      $(By.xpath("//div[contains(@data-bind,'sendQuery')]")).shouldBe(Condition.visible);
   }

   public void checkHintsIsVisible() {
      $$(By.xpath("//div[contains(@class,'hints')]//li")).shouldBe(CollectionCondition.sizeGreaterThan(0));
   }

   public void checkCartIsEmpty() {
      $(By.xpath("//div[contains(text(),'В корзину ничего не добавлено')]")).shouldBe(Condition.visible);
   }

   public void fillSearchField(String text) {
      $(By.xpath("//input[contains(@placeholder,'Что вы ищете?')]")).shouldBe(Condition.visible).setValue(text);
   }

   public void pressSearchButton() {
      $(By.xpath("//div[contains(@data-bind,'sendQuery')]")).shouldBe(Condition.visible).click();
   }
}
