package ru.hh.web.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.hh.api.models.DictionariesModel;
import ru.hh.api.models.ScheduleModel;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;
import static ru.hh.api.service.GetDictionariesApi.getDictionaries;

public class FilterPage {

    private final SelenideElement regionFilterField = $("[data-qa='advanced-search-region-add']"),
            regionSelectedList = $("[data-qa='advanced-search__selected-regions'] .bloko-tag-list"),
            regionRemoveButton = $("[data-qa='advanced-search__selected-regions'] .bloko-tag-list [data-qa='bloko-tag__cross']"),
            specializationsLink = $("[data-qa='resumesearch__profroles-switcher']"),
            searchSubmitButton = $("[data-qa='advanced-search-submit-button']");

    private final ElementsCollection employmentCheckboxes = $$("[data-qa*='advanced-search__schedule-item-label_']");

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

    @Step("Установить чекбокс тип занятости")
    public FilterPage setTypeOfEmploymentCheckbox(String value) {
        String selector = String.format("[data-qa='advanced-search__employment-item-label_%s']", value);
        $(selector).scrollTo();
        $(selector).click();
        return this;
    }

    @Step("Проверить чекбоксы графика работы на странице фильтров")
    public FilterPage checkCheckboxesScheduleOnFilterPage() {
        DictionariesModel dictionariesModel = getDictionaries();
        List<ScheduleModel> schedules = dictionariesModel.getSchedule();

        for (ScheduleModel schedule : schedules) {
            String name = schedule.getName();
            employmentCheckboxes.shouldHave(CollectionCondition.itemWithText(name));
        }
        return this;
    }
}