package ru.hh.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final SelenideElement loginByPasswordButton = $("[data-qa='expand-login-by-password']"),
            emailField = $("[data-qa='login-input-username']"),
            passwordField = $("[data-qa='login-input-password']"),
            loginButton = $("[data-qa='account-login-submit']");

    @Step("Открыть страницу авторизации")
    public LoginPage openPage() {
        open("/account/login");
        return this;
    }

    @Step("Нажать на кнопку \"Войти по почте\"")
    public LoginPage clickLoginByPasswordButton() {
        loginByPasswordButton.click();
        return this;
    }

    @Step("Ввести почту")
    public LoginPage enterEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage enterPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Нажать на кнопку \"Войти\"")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Авторизоваться по почте и паролю")
    public LoginPage loginByEmailAndPassword(String email, String password) {
        openPage()
                .clickLoginByPasswordButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickLoginButton();
        return this;
    }
}