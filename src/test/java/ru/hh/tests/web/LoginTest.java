package ru.hh.tests.web;

import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.hh.config.CredentialsConfig;
import ru.hh.pages.LoginPage;
import ru.hh.pages.PersonalInfoSettingPage;
import ru.hh.pages.components.NavigationComponent;
import ru.hh.pages.components.ProfileDropdownListComponent;

@Owner("Асташкина Екатерина")
@Feature("Авторизация на hh.ru")
@DisplayName("Авторизация")
public class LoginTest extends TestBase {

    private static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class, System.getProperties());

    LoginPage loginPage = new LoginPage();
    NavigationComponent navigationComponent = new NavigationComponent();
    ProfileDropdownListComponent profileDropdownListComponent = new ProfileDropdownListComponent();
    PersonalInfoSettingPage personalInfoSettingPage = new PersonalInfoSettingPage();

    String emailValue = config.loginAccount();
    String passwordValue = config.passwordAccount();

    @Test
    @Tag("web")
    @Story("Авторизация по почте")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация по почте и паролю")
    void loginByEmailAndPasswordTest() {
        loginPage.loginByEmailAndPassword(emailValue, passwordValue);
        navigationComponent.clickProfileIcon();
        profileDropdownListComponent.clickSettingButton();
        personalInfoSettingPage.checkEmailInPersonalInfoSetting(emailValue);
    }
}