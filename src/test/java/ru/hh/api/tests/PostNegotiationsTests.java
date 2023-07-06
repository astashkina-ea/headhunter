package ru.hh.api.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.hh.api.data.enums.TypeErrors;
import ru.hh.api.models.ForbbidenErrorModel;
import ru.hh.api.models.NegotiationModel;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;
import static ru.hh.api.service.PostNegotiationsApi.postNegotiationsWithForbbidenError;
import static ru.hh.api.utils.RandomUtils.getRandomBetweenNumber;
import static ru.hh.api.utils.RandomUtils.getRandomText;

@DisplayName("Метод отклика на вакансию")
public class PostNegotiationsTests {

    @Tag("api")
    @Test
    @DisplayName("Отсутствие доступа на отклик на определенную вакансию неавторизованным пользователем")
    void postNegotiationsWithForbbidenErrorTest() {
        NegotiationModel requestBody = new NegotiationModel();

        requestBody.setIdVacancy(String.format("%d", getRandomBetweenNumber(1, 100000)));
        requestBody.setIdResume(String.format("%d", getRandomBetweenNumber(1, 100000)));
        requestBody.setMessage(getRandomText());

        ForbbidenErrorModel forbbidenErrorModel = step("Выполнить вызов метода на отклик на определенную вакансию", () -> postNegotiationsWithForbbidenError(requestBody));
        step("Проверить, что возврращается тело ответа с ошибкой типа forbidden", () -> {
            assertAll(
                    () -> assertEquals(TypeErrors.FORBIDDEN.getText(), forbbidenErrorModel.getErrors().get(0).getType()),
                    () -> assertNotNull(forbbidenErrorModel.getIdRequest())
            );
        });
    }
}