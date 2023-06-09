package ru.hh.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.hh.pages.LoginPage;
import ru.hh.pages.PersonalInfoSettingPage;
import ru.hh.pages.components.NavigationComponent;
import ru.hh.pages.components.ProfileDropdownListComponent;

@Feature("Авторизация на hh.ru")
@DisplayName("Авторизация")
public class LoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();
    NavigationComponent navigationComponent = new NavigationComponent();
    ProfileDropdownListComponent profileDropdownListComponent = new ProfileDropdownListComponent();
    PersonalInfoSettingPage personalInfoSettingPage = new PersonalInfoSettingPage();

    String emailValue = "kihoyo8545@soremap.com";
    String passwordValue = "Test12345";

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