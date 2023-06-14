package ru.hh.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.hh.config.CredentialsConfig;
import ru.hh.pages.LoginPage;
import ru.hh.pages.PersonalInfoSettingPage;
import ru.hh.pages.components.NavigationComponent;
import ru.hh.pages.components.ProfileDropdownListComponent;

@Feature("Авторизация на hh.ru")
@DisplayName("Авторизация")
public class LoginTest extends TestBase {

    private static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class, System.getProperties());


    LoginPage loginPage = new LoginPage();
    NavigationComponent navigationComponent = new NavigationComponent();
    ProfileDropdownListComponent profileDropdownListComponent = new ProfileDropdownListComponent();
    PersonalInfoSettingPage personalInfoSettingPage = new PersonalInfoSettingPage();

    String emailValue = config.getLoginAccount();
    String passwordValue = config.getPasswordAccount();

    @Tag("smoke")
    @Story("Авторизация по почте")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @DisplayName("Авторизация по почте и паролю")
    void loginByEmailAndPasswordTest() {
        loginPage.loginByEmailAndPassword(emailValue, passwordValue);
        navigationComponent.clickProfileIcon();
        profileDropdownListComponent.clickSettingButton();
        personalInfoSettingPage.checkEmailInPersonalInfoSetting(emailValue);
    }
}