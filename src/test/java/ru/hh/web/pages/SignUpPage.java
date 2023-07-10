package ru.hh.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;

public class SignUpPage {

    private final SelenideElement signupWrapper = $(".signup-wrapper");

    @Step("Проверить открытие страницы регистрации")
    public SignUpPage checkOpeningSignupPage() {
        signupWrapper.shouldBe(appear );
        return this;
    }
}