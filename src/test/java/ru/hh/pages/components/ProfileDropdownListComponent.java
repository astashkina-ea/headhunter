package ru.hh.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ProfileDropdownListComponent {

    private SelenideElement settingButton = $("[data-qa='mainmenu_applicantSettings']");

    @Step("Выбрать раздел \"Настройки\"")
    public ProfileDropdownListComponent clickSettingButton() {
        settingButton.click();
        return this;
    }
}