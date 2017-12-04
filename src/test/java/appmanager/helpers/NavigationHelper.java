package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NavigationHelper extends BaseHelper {

   public NavigationHelper(ChromeDriver wd) {
      super(wd);
   }


   public void openAuthorizationPopUp() {
      click(By.xpath("//div[5]/div[3]/div/div/div"));
   }

   public void openLoginPage() {
      wd.get("http://butik.ru/login");
   }

   public void gotoProfile()  {
      Actions action = new Actions(wd);
      WebElement we = wd.findElement(By.xpath("/html/body/header/div[2]/div[5]/div[4]/div/div[1]/span"));
      action.moveToElement(we).moveToElement(wd.findElement(By.xpath("/html/body/header/div[2]/div[5]/div[4]/div/div[1]/span"))).build().perform();
      click(By.xpath("(//a[contains(text(),'Персональные данные')])[2]"));
   }
}
