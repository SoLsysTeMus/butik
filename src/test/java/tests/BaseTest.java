package tests;

import appmanager.ApplicationManager;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

   protected final ApplicationManager app = new ApplicationManager();

   @BeforeMethod
   public void setUp() {
      Configuration.baseUrl = "https://stage.butik.ru";
      app.init();

   }

   @AfterMethod
   public void tearDown() {

   }


}
