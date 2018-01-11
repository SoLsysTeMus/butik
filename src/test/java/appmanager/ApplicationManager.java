package appmanager;

import appmanager.helpers.*;
import appmanager.helpers.header.HeaderHelper;
import appmanager.helpers.header.MainMenuHelper;

public class ApplicationManager {

   public static String baseUrl = "https://stage.butik.ru/";


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
   private BannerHelper bannerHelper;
   private SearchHelper searchHelper;
   private WishListHelper wishListHelper;

   public static String getBaseUrl() {
      return baseUrl;
   }

   public void init() {

//      if (useSelenoid) {
//         initSelenoidDriver();
//      } else {
//         initLocalDriver();
//      }

      initHelpers();
   }


   private void initHelpers() {
      navigationHelper = new NavigationHelper();
      mainMenuHelper = new MainMenuHelper();
      registrationHelper = new RegistrationHelper();
      authorizationHelper = new AuthorizationHelper();
      userProfileHelper = new UserProfileHelper();
      personalMenuHelper = new PersonalMenuHelper();
      headerHelper = new HeaderHelper();
      catalogHelper = new CatalogHelper();
      productCardHelpers = new ProductCardHelpers();
      checkoutHelper = new CheckoutHelper();
      footerHelper = new FooterHelper();
      pageHelper = new PageHelper();
      bannerHelper = new BannerHelper();
      searchHelper = new SearchHelper();
      wishListHelper = new WishListHelper();
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

   public BannerHelper banner() {
      return bannerHelper;
   }

   public SearchHelper search() {
      return searchHelper;
   }

   public WishListHelper wishList() {
      return wishListHelper;
   }
}

