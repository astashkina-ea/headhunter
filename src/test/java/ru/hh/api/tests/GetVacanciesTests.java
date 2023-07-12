package ru.hh.api.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.hh.api.data.enums.Areas;
import ru.hh.api.models.DictionariesModel;
import ru.hh.api.models.VacanciesModel;
import ru.hh.api.models.ItemsVacanciesModel;
import ru.hh.api.models.EmploymentModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.hh.api.service.GetDictionariesApi.getDictionaries;
import static ru.hh.api.service.GetVacanciesApi.getVacancies;
import static ru.hh.api.utils.RandomUtils.getRandomElementFromList;

@Owner("Асташкина Екатерина")
@DisplayName("Метод получения вакансий")
public class GetVacanciesTests {

    @Tag("api")
    @EnumSource(value = Areas.class)
    @DisplayName("Поиск вакансий по региону")
    @ParameterizedTest(name = "\"{0}\"")
    void getVacanciesByAreaTest(Areas area) {
        Map<String, String> queryParam = new HashMap<>();
        queryParam.put("area", area.getId());

        VacanciesModel vacanciesModel = step("Выполнить вызов метода на получение вакансий по региону " + area.getName(), () ->
                getVacancies(queryParam));

        List<ItemsVacanciesModel> vacancies = vacanciesModel.getItems();
        step("Проверить, что в каждой вакансии отображается возвращается переданный регион " + area.getName(), () -> {
            for (ItemsVacanciesModel vacancy : vacancies) {
                assertAll(
                        () -> assertEquals(area.getId(), vacancy.getArea().getId()),
                        () -> assertEquals(area.getName(), vacancy.getArea().getName()),
                        () -> assertEquals(area.getUrl(), vacancy.getArea().getUrl())
                );
            }
        });
    }

    @Tag("api")
    @Test
    @DisplayName("Поиск вакансий по рандомной занятости")
    void getVacanciesByScheduleTest() {
        DictionariesModel dictionariesModel = getDictionaries();
        List<EmploymentModel> employments = dictionariesModel.getEmployment();
        EmploymentModel employment = getRandomElementFromList(employments);

        Map<String, String> queryParam = new HashMap<>();
        queryParam.put("employment", employment.getId());

        VacanciesModel vacanciesModel = step("Выполнить вызов метода на получение вакансий по занятости " + employment.getName(), () ->
                getVacancies(queryParam));

        List<ItemsVacanciesModel> vacancies = vacanciesModel.getItems();
        step("Проверить, что в каждой вакансии отображается возвращается переданная занятость " + employment.getName(), () -> {
            for (ItemsVacanciesModel vacancy : vacancies) {
                assertAll(
                        () -> assertEquals(employment.getId(), vacancy.getEmployment().getId()),
                        () -> assertEquals(employment.getName(), vacancy.getEmployment().getName())
                );
            }
        });
    }
}