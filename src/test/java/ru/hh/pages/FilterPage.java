package ru.hh.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.ofSeconds;

public class FilterPage {

    private SelenideElement regionFilterField = $("[data-qa='advanced-search-region-add']"),
            regionSelectedList = $("[data-qa='advanced-search__selected-regions'] .bloko-tag-list"),
            regionRemoveButton = $("[data-qa='advanced-search__selected-regions'] .bloko-tag-list [data-qa='bloko-tag__cross']"),
            specializationsLink = $("[data-qa='resumesearch__profroles-switcher']"),
            searchSubmitButton = $("[data-qa='advanced-search-submit-button']");

    @Step("Открыть страницу фильтрации")
    public FilterPage openPage() {
        open("/search/vacancy/advanced");
        return this;
    }

    @Step("Установить фильтр по региону")
    public FilterPage setRegionFilter(String region) {
        regionRemoveButton.click();
        regionFilterField.setValue(region);
        regionSelectedList.shouldHave(Condition.text(region), ofSeconds(5));
        return this;
    }

    @Step("Нажать на кнопку \"Указать специализацию\"")
    public FilterPage clickSpecializationsLink() {
        specializationsLink.click();
        return this;
    }

    @Step("Нажать на кнопку \"Найти\"")
    public FilterPage clickSearchSubmitButton() {
        searchSubmitButton.click();
        return this;
    }

    @Step("Установить чекбокс графика работы")
    public FilterPage setWorkScheduleCheckbox(String value) {
        String selector = String.format("[data-qa='advanced-search__schedule-item-label_%s']", value);
        $(selector).scrollTo();
        $(selector).click();
        return this;
    }
}