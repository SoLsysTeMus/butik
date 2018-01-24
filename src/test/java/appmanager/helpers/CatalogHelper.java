package appmanager.helpers;

import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

public class CatalogHelper extends BaseHelper {

   @Step("Количество товаров в категории")
   public int getProductsCountInCategory() {
      waitLoader();
      return Integer.parseInt(getTextForElement(By.xpath("//span[contains(text(),'товар')]")).replaceAll("\\D", ""));
   }

   public void openFirstProductCard() {
      click(By.xpath("/html/body/div[2]/div[1]/div[4]/div[1]/div/div[6]/div[1]/div[1]/a"));
   }


}
