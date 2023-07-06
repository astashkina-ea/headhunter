package ru.hh.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PersonalInfoSettingPage {

    private SelenideElement emailField = $("[data-template-name='email']");

    @Step("Проверить почту на странице настроек личных данных")
    public PersonalInfoSettingPage checkEmailInPersonalInfoSetting(String email) {
        emailField.shouldHave(text(email));
        return this;
    }
}