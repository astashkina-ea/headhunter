package ru.hh.tests.web;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.hh.pages.MainPage;
import ru.hh.pages.SignUpPage;

@Owner("Асташкина Екатерина")
@Feature("Главная страница")
@DisplayName("Главная страница")
public class MainPageTests extends TestBase{

    MainPage mainPage = new MainPage();
    SignUpPage signUpPage = new SignUpPage();

    @Test
    @Tag("web")
    @Story("Регистрация")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Переход на страницу регистрации")
    void loginByEmailAndPasswordTest() {
        mainPage.openPage()
                .clickSignUbButton();
        signUpPage.checkOpeningSignupPage();
    }
}