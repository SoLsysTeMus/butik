package appmanager.helpers.header;

import appmanager.helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeaderHelper extends BaseHelper{

    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public void openPersonalMenu(){
        moveTo(By.xpath("/html/body/header/div[2]/div[5]/div[4]/div/div[1]/span"));
    }

    public void gotoWishlist(){
        click(By.xpath("/html/body/header/div[2]/div[5]/div[3]/a/div"));
    }

    public int getWishlistItemscount(){
       return Integer.parseInt(getTextForElement(By.xpath("/html/body/header/div[2]/div[5]/div[3]/a/div/span")));
    }


}
