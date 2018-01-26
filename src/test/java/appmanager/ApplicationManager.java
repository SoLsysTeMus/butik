package appmanager;

import appmanager.helpers.*;
import appmanager.helpers.header.HeaderHelper;
import appmanager.helpers.header.MainMenuHelper;

public class ApplicationManager {

   private NavigationHelper navigationHelper;
   private RegistrationHelper registrationHelper;
   private AuthorizationHelper authorizationHelper;
   private UserProfileHelper userProfileHelper;
   private PersonalMenuHelper personalMenuHelper;
   private HeaderHelper headerHelper;
   private MainMenuHelper mainMenuHelper;
   private CatalogHelper catalogHelper;
   private ProductCardHelper productCardHelper;
   private CheckoutHelper checkoutHelper;
   private FooterHelper footerHelper;
   private PageHelper pageHelper;
   private BannerHelper bannerHelper;
   private SearchHelper searchHelper;
   private WishListHelper wishListHelper;


   public NavigationHelper navigation() {
      if (navigationHelper == null) {
         navigationHelper = new NavigationHelper();
      }
      return navigationHelper;
   }

   public AuthorizationHelper authorization() {
      if (authorizationHelper == null) {
         authorizationHelper = new AuthorizationHelper();
      }
      return authorizationHelper;
   }

   public UserProfileHelper userProfile() {
      if (userProfileHelper == null) {
         userProfileHelper = new UserProfileHelper();
      }
      return userProfileHelper;
   }

   public RegistrationHelper registration() {
      if (registrationHelper == null) {
         registrationHelper = new RegistrationHelper();
      }
      return registrationHelper;
   }

   public PersonalMenuHelper personalMenu() {
      if (personalMenuHelper == null) {
         personalMenuHelper = new PersonalMenuHelper();
      }
      return personalMenuHelper;
   }

   public HeaderHelper header() {
      if (headerHelper == null) {
         headerHelper = new HeaderHelper();
      }
      return headerHelper;
   }

   public MainMenuHelper mainMenu() {
      if (mainMenuHelper == null) {
         mainMenuHelper = new MainMenuHelper();
      }
      return mainMenuHelper;
   }

   public CatalogHelper catalog() {
      if (catalogHelper == null) {
         catalogHelper = new CatalogHelper();
      }
      return catalogHelper;
   }

   public ProductCardHelper productCard() {
      if (productCardHelper == null) {
         productCardHelper = new ProductCardHelper();
      }
      return productCardHelper;
   }

   public CheckoutHelper checkout() {
      if (checkoutHelper == null) {
         checkoutHelper = new CheckoutHelper();
      }
      return checkoutHelper;
   }

   public FooterHelper footer() {
      if (footerHelper == null) {
         footerHelper = new FooterHelper();
      }
      return footerHelper;
   }

   public PageHelper page() {
      if (pageHelper == null) {
         pageHelper = new PageHelper();
      }
      return pageHelper;
   }

   public BannerHelper banner() {
      if (bannerHelper == null) {
         bannerHelper = new BannerHelper();
      }
      return bannerHelper;
   }

   public SearchHelper search() {
      if (searchHelper == null) {
         searchHelper = new SearchHelper();
      }
      return searchHelper;
   }

   public WishListHelper wishList() {
      if (wishListHelper == null) {
         wishListHelper = new WishListHelper();
      }
      return wishListHelper;
   }
}

