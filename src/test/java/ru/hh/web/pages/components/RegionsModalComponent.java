package ru.hh.web.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class RegionsModalComponent {

    private final SelenideElement regionsModal = $(".supernova-overlay__content"),
            closeButton = $(".supernova-overlay-closer");

    @Step("Проверить открытие модалки выбора региона")
    public RegionsModalComponent checkOpeningRegionsModal() {
        regionsModal.shouldBe(appear);
        return this;
    }

    @Step("Проверить отсутствие модалки выбора региона")
    public RegionsModalComponent checkClosingRegionsModal() {
        regionsModal.shouldBe(disappear);
        return this;
    }

    @Step("Закрыть модалку выбора региона")
    public RegionsModalComponent closeRegionsModal() {
        closeButton.click();
        return this;
    }
}