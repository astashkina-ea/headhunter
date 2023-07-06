package ru.hh.web.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class NavigationComponent {

    private SelenideElement profileIcon = $("[data-qa='mainmenu_applicantProfile']");

    @Step("Нажать на икону профиля")
    public NavigationComponent clickProfileIcon() {
        profileIcon.click();
        return this;
    }
}