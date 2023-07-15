package ru.hh.service;

import ru.hh.models.VacanciesModel;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static ru.hh.specs.Specs.requestSpec;
import static ru.hh.specs.Specs.response200Spec;

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