package ru.hh.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement regionLink = $("[data-page-analytics-event='vacancy_search_region']"),
            signUbButton = $("[data-qa='signup']");

    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("");
        return this;
    }

    @Step("Нажать на регион")
    public MainPage clickRegionLink() {
        regionLink.click();
        return this;
    }

    @Step("Нажать на кнопку \"Созадать резюме\"")
    public MainPage clickSignUbButton() {
        signUbButton.click();
        return this;
    }
}