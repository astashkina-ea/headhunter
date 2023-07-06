package ru.hh.web.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.hh.web.data.CategorySpecializations;
import ru.hh.web.data.TypeOfEmployment;
import ru.hh.web.data.WorkSchedule;
import ru.hh.web.pages.FilterPage;
import ru.hh.web.pages.ResultsSearchPage;
import ru.hh.web.pages.components.SpecializationsModalComponent;

@Feature("Поиск вакансий")
@DisplayName("Фильтрация при поиске вакансий")
public class FilterTests extends TestBase {

    FilterPage filterPage = new FilterPage();
    ResultsSearchPage resultsSearchPage = new ResultsSearchPage();
    SpecializationsModalComponent specializationsModalComponent = new SpecializationsModalComponent();

    @Story("Регионы в фильтрах")
    @Severity(SeverityLevel.NORMAL)
    @ValueSource(strings = {
            "Пенза",
            "Самара"
    })
    @DisplayName("Отображение региона в результатах поиска вакансий при фильтрации по региону ")
    @ParameterizedTest(name = "\"{0}\"")
    void searchByRegionsTest(String region) {
        filterPage.openPage()
                .setRegionFilter(region)
                .clickSearchSubmitButton();
        resultsSearchPage.checkSelectedRegionsInResults(region);
    }

    @Story("Специализации в фильтрах")
    @Severity(SeverityLevel.NORMAL)
    @EnumSource(value = CategorySpecializations.class)
    @DisplayName("Отображение специализаций ")
    @ParameterizedTest(name = "для категории \"{0}\"")
    void checkSpecializationsModalTest(CategorySpecializations category) {
        filterPage.openPage()
                .clickSpecializationsLink();
        specializationsModalComponent.clickCategory(CategorySpecializations.getId(category.getCategory()))
                .checkSpecializationsList(category.getCategory());
    }

    @Story("Чекбокс график работы")
    @Severity(SeverityLevel.NORMAL)
    @EnumSource(value = WorkSchedule.class)
    @DisplayName("Проверка на странице результов поиска установленного чекбокса")
    @ParameterizedTest(name = "\"{0}\" в блоке \"График работы\"")
    void checkSelectedWorkScheduleCheckboxTest(WorkSchedule workSchedule) {
        filterPage.openPage()
                .setWorkScheduleCheckbox(workSchedule.getSelector())
                .clickSearchSubmitButton();
        resultsSearchPage.checkSelectedWorkScheduleCheckbox(workSchedule.getSelector());
    }

    @Story("Чекбокс тип занятости")
    @Severity(SeverityLevel.NORMAL)
    @EnumSource(value = TypeOfEmployment.class)
    @DisplayName("Проверка на странице результов поиска установленного чекбокса")
    @ParameterizedTest(name = "\"{0}\" в блоке \"Тип занятости\"")
    void checkSelectedTypeOfEmploymentCheckboxTest(TypeOfEmployment typeOfEmployment) {
        filterPage.openPage()
                .setTypeOfEmploymentCheckbox(typeOfEmployment.getSelector())
                .clickSearchSubmitButton();
        resultsSearchPage.checkSelectedTypeOfEmploymentCheckbox(typeOfEmployment.getSelector());
    }
}