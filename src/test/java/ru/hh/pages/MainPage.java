package ru.hh.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement regionLink = $("[data-page-analytics-event='vacancy_search_region']");

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
}