package appmanager;

import appmanager.helpers.*;
import appmanager.helpers.header.HeaderHelper;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    ChromeDriver wd;
    public static String baseUrl = "https://stage.butik.ru/";

    private NavigationHelper navigationHelper;
    private RegistrationHelper registrationHelper;
    private AuthorizationHelper authorizationHelper;
    private UserProfileHelper userProfileHelper;
    private PersonalMenuHelper personalMenuHelper;
    private HeaderHelper headerHelper;

    public void init() {

        System.setProperty("webdriver.chrome.driver", "/home/sol/drivers/chromedriver");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get(baseUrl);

        navigationHelper = new NavigationHelper(wd);
        registrationHelper = new RegistrationHelper(wd);
        authorizationHelper = new AuthorizationHelper(wd);
        userProfileHelper = new UserProfileHelper(wd);
        personalMenuHelper = new PersonalMenuHelper(wd);
        headerHelper = new HeaderHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public AuthorizationHelper getAuthorizationHelper() {
        return authorizationHelper;
    }

    public UserProfileHelper getUserProfileHelper() {
        return userProfileHelper;
    }

    public RegistrationHelper getRegistrationHelper() {
        return registrationHelper;
    }

    public PersonalMenuHelper getPersonalMenuHelper() {
        return personalMenuHelper;
    }

    public HeaderHelper getHeaderHelper() {
        return headerHelper;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }
}

