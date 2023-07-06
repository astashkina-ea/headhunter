package ru.hh.api.service;

import ru.hh.api.models.ForbbidenErrorModel;

import static io.restassured.RestAssured.given;
import static ru.hh.api.specs.Specs.*;

public class DeleteFavoritedVacancyApi {

    public static ForbbidenErrorModel deleteFavoritedVacancyWithForbbidenError(String idVacancy) {
        return given(requestSpec)
                .when()
                .delete("/vacancies/favorited/" + idVacancy)
                .then()
                .spec(response403Spec)
                .extract()
                .as(ForbbidenErrorModel.class);
    }
}