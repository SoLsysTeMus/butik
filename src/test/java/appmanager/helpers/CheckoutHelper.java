package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutHelper extends BaseHelper{

   public CheckoutHelper(WebDriver wd) {
      super(wd);
   }

   public void deleteItemFromWishlist(){
      click(By.cssSelector(".btn.bg-white.fa.c-bth.fr.p-y-xs_0-6875.p-x-xs_0-75.br-rnd.br-lgr.cur-ptr.fw-l.fs-xs_1.w-xs-3.h-xs_2-5.fa-heart"));
   }

}
