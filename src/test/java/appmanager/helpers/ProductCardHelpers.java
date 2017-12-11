package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductCardHelpers extends BaseHelper {

   public ProductCardHelpers(WebDriver wd) {
      super(wd);
   }


   public void addToWishlist() {
      waitLoadingElement(By.xpath("html/body/div[2]/div[1]/div[3]/div[1]/div[4]/div[2]/button"),5);
      click(By.xpath("html/body/div[2]/div[1]/div[3]/div[1]/div[4]/div[2]/button"));
   }

   public void removeFromlist() {
      waitLoadingElement(By.xpath("html/body/div[2]/div[1]/div[3]/div[1]/div[4]/div[2]/button"),5);
      click(By.xpath("html/body/div[2]/div[1]/div[3]/div[1]/div[4]/div[2]/button"));
   }

   public void addToCart() {
      waitLoadingElement(By.cssSelector(".col-xs-12.col-sm-9.col-lg-6.m-b-xs_1.m-b-sm_0.butn-black-s.br-rnd"),5);
      click(By.cssSelector(".col-xs-12.col-sm-9.col-lg-6.m-b-xs_1.m-b-sm_0.butn-black-s.br-rnd"));
   }
}
