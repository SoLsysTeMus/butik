package appmanager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationHelper extends BaseHelper{

    public RegistrationHelper(ChromeDriver wd) {
        super(wd);
    }


    public void fillPopUpRegistrationForm(String name, String randomEmail, String password) {
        waitLoadingElement(By.xpath("//*[@id=\"js-registration-name\"]"),5);
        type(By.xpath("//*[@id=\"js-registration-name\"]"), name);
        type(By.xpath("//*[@id=\"authPopup\"]/div[2]/div[2]/div/div[2]/form/div[2]/input"), randomEmail);
        type(By.xpath("//*[@id=\"authPopup\"]/div[2]/div[2]/div/div[2]/form/div[5]/input"), password);
    }

    public void fillRegistrationForm(String name, String randomEmail, String password) {
        type(By.xpath("//*[@id=\"js-registration-name\"]"), name);
        type(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/form/div[2]/input"), randomEmail);
        type(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/form/div[5]/input"), password);
    }

    public void submitPopUpRegistrationData() {
        click(By.xpath("//*[@id=\"authPopup\"]/div[2]/div[2]/div/div[2]/form/button"));
    }

    public void submitRegistrationData() {
        click(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/form/button"));
    }
}
