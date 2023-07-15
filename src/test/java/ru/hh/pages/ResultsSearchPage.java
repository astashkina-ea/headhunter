package ru.hh.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultsSearchPage {

    private final ElementsCollection regionVacancies = $$("[data-qa='vacancy-serp__vacancy-address']");

    @Step("Проверить выбранный регион")
    public ResultsSearchPage checkSelectedRegionsInResults(String region) {
        for (SelenideElement regionVacancy : regionVacancies) {
            regionVacancy.shouldHave(text(region));
        }
        return this;
    }

    @Step("Проверить выбранный график работы")
    public ResultsSearchPage checkSelectedWorkScheduleCheckbox(String value) {
        String selector = String.format("[data-qa='serp__novafilter-schedule-%s']", value);
        $(selector).shouldBe(checked);
        return this;
    }

    @Step("Проверить выбранный тип занятости")
    public ResultsSearchPage checkSelectedTypeOfEmploymentCheckbox(String value) {
        String selector = String.format("[data-qa='serp__novafilter-employment-%s']", value);
        $(selector).shouldBe(checked);
        return this;
    }
}