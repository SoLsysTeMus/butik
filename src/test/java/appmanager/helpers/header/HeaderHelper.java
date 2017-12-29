package appmanager.helpers.header;

import appmanager.helpers.BaseHelper;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class HeaderHelper extends BaseHelper {

   public void openPersonalMenu() {
      $(By.xpath("//header/div[2]/div[5]/div[4]/div/div[1]/span")).waitUntil(Condition.visible, 7);
      moveTo(By.xpath("//header/div[2]/div[5]/div[4]/div/div[1]/span"));
      //$(By.xpath("//header/div[2]/div[5]/div[4]/div/div[1]/span")).shouldBe(Condition.visible).hover();
   }

   public void gotoWishlist() {
      click(By.xpath("//header/div[2]/div[5]/div[3]/a"));
   }

   public Integer getWishlistItemscount() {
      return Integer.parseInt(getTextForElement(By.xpath("//header/div[2]/div[5]/div[3]/a/span")));
   }

   public void checkUserName(String name){
      $(By.xpath("//header/div[2]/div[5]/div[4]/div/div[1]/span")).shouldBe(Condition.text(name));
   }


}
