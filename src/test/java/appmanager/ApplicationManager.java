package appmanager;

import appmanager.helpers.*;
import appmanager.helpers.header.HeaderHelper;
import appmanager.helpers.header.MainMenuHelper;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ApplicationManager {

   public static String baseUrl = "https://stage.butik.ru/";
   protected WebDriver wd;
   private String browser = BrowserType.CHROME;
   private boolean useSelenoid = false;


   private NavigationHelper navigationHelper;
   private RegistrationHelper registrationHelper;
   private AuthorizationHelper authorizationHelper;
   private UserProfileHelper userProfileHelper;
   private PersonalMenuHelper personalMenuHelper;
   private HeaderHelper headerHelper;
   private MainMenuHelper mainMenuHelper;
   private CatalogHelper catalogHelper;
   private ProductCardHelpers productCardHelpers;
   private CheckoutHelper checkoutHelper;
   private FooterHelper footerHelper;
   private PageHelper pageHelper;

   public static String getBaseUrl() {
      return baseUrl;
   }

 public void init() {
//
//      if (useSelenoid) {
//         initSelenoidDriver();
//      } else {
//         initLocalDriver();
//      }
//      wd.manage().window().setSize(new Dimension(1920, 1080));
//      wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         open(baseUrl);
//
         initHelpers();
  }

   private void initLocalDriver() {

      switch (browser) {
         case BrowserType.FIREFOX:
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
            wd = new FirefoxDriver();
            break;
         case BrowserType.CHROME:
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            wd = new ChromeDriver();
            break;
         case BrowserType.IE:
            System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
            wd = new InternetExplorerDriver();
            break;
      }


   }

   private void initSelenoidDriver() {

      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setBrowserName("chrome");
      capabilities.setVersion("63.0");
      //capabilities.setCapability("enableVNC",true);
      //capabilities.setCapability("enableVideo",true);

      try {
         wd = new RemoteWebDriver(
                 URI.create("http://172.16.83.128:4444/wd/hub").toURL(),
                 capabilities
         );
      } catch (MalformedURLException e) {
         e.printStackTrace();
      }
   }

   private void initHelpers() {
      navigationHelper = new NavigationHelper(wd);
      mainMenuHelper = new MainMenuHelper(wd);
      registrationHelper = new RegistrationHelper(wd);
      authorizationHelper = new AuthorizationHelper(wd);
      userProfileHelper = new UserProfileHelper(wd);
      personalMenuHelper = new PersonalMenuHelper(wd);
      headerHelper = new HeaderHelper(wd);
      catalogHelper = new CatalogHelper(wd);
      productCardHelpers = new ProductCardHelpers(wd);
      checkoutHelper = new CheckoutHelper(wd);
      footerHelper = new FooterHelper(wd);
      pageHelper = new PageHelper(wd);
   }

   public NavigationHelper navigation() {
      return navigationHelper;
   }

   public AuthorizationHelper authorization() {
      return authorizationHelper;
   }

   public UserProfileHelper userProfile() {
      return userProfileHelper;
   }

   public RegistrationHelper registration() {
      return registrationHelper;
   }

   public PersonalMenuHelper personalMenu() {
      return personalMenuHelper;
   }

   public HeaderHelper header() {
      return headerHelper;
   }

   public MainMenuHelper mainMenu() {
      return mainMenuHelper;
   }

   public CatalogHelper catalog() {
      return catalogHelper;
   }

   public ProductCardHelpers productCard() {
      return productCardHelpers;
   }

   public CheckoutHelper checkout() {
      return checkoutHelper;
   }

   public FooterHelper footer() {
      return footerHelper;
   }

   public PageHelper page() {
      return pageHelper;
   }
}

