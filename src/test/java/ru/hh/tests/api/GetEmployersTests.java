package ru.hh.tests.api;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.hh.models.EmployersModel;
import ru.hh.models.ItemsEmployersModel;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;
import static ru.hh.service.GetEmployersApi.getEmployers;

@Owner("Асташкина Екатерина")
@DisplayName("Метод получения работодателей")
public class GetEmployersTests {

    @Test
    @Tag("api")
    @DisplayName("Проверка возвращаемых параметров в методе GET /employers")
    void getEmployersByDifferentParams() {

        EmployersModel employersModel = step("Выполнить вызов метода на получение работодателей " , () ->
                getEmployers());

        List<ItemsEmployersModel> employers = employersModel.getItems();
        step("Проверить, что  возвращаются все необходимые параметры" , () -> {
            for (ItemsEmployersModel employer : employers) {
                String urlObject = employer.toStringLogoUrl(employer.getLogoUrls());
                assertAll(
                        () -> assertNotNull(employer.getId()),
                        () -> assertNotNull(employer.getName()),
                        () -> assertNotNull(employer.getUrl()),
                        () -> assertNotNull(employer.getAlternateUrl()),
                        () -> assertNotNull(urlObject),
                        () -> assertNotNull(employer.getVacanciesUrl()),
                        () -> assertNotNull(employer.getOpenVacancies())
                );
            }
        });
    }
}