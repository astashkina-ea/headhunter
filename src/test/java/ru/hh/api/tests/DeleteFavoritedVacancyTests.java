package ru.hh.api.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.hh.api.data.enums.TypeErrors;
import ru.hh.api.models.ForbbidenErrorModel;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;
import static ru.hh.api.service.DeleteFavoritedVacancyApi.deleteFavoritedVacancyWithForbbidenError;
import static ru.hh.api.utils.RandomUtils.getRandomBetweenNumber;

@Owner("Асташкина Екатерина")
@DisplayName("Метод удаления вакансий")
public class DeleteFavoritedVacancyTests {

    @Test
    @Tag("api")
    @DisplayName("Отсутствие доступа на удаление вакансии из списка отобранных неавторизованным пользователем")
    void deleteFavoritedVacancyWithForbbidenErrorTest() {
        String idVacancy = String.format("%d", getRandomBetweenNumber(1, 100000));

        ForbbidenErrorModel forbbidenErrorModel = step("Выполнить вызов метода на удаление вакансии", () ->
                deleteFavoritedVacancyWithForbbidenError(idVacancy));
        step("Проверить, что возвращается тело ответа с ошибкой типа forbidden", () -> {
            assertAll(
                    () -> assertEquals(TypeErrors.FORBIDDEN.getText(),
                            forbbidenErrorModel.getErrors().get(0).getType()),
                    () -> assertTrue(!forbbidenErrorModel.getIdRequest().isEmpty())
            );
        });
    }
}