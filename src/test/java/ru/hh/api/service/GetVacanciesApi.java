package ru.hh.api.service;

import ru.hh.api.models.VacanciesModel;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static ru.hh.api.specs.Specs.requestSpec;
import static ru.hh.api.specs.Specs.response200Spec;

public class GetVacanciesApi {

    public static VacanciesModel getVacancies(Map<String, String> queryParams) {
        return given(requestSpec)
                .queryParams(queryParams)
                .when()
                .get("/vacancies")
                .then()
                .spec(response200Spec)
                .extract()
                .as(VacanciesModel.class);
    }
}