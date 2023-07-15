package ru.hh.service;

import ru.hh.models.ForbbidenErrorModel;

import static io.restassured.RestAssured.given;
import static ru.hh.specs.Specs.*;

public class DeleteFavoritedVacancyApi {

    public static ForbbidenErrorModel deleteFavoritedVacancyWithForbbidenError(String idVacancy) {
        return given(requestSpec)
                .when()
                .delete(String.format("/vacancies/favorited/%s",idVacancy))
                .then()
                .spec(response403Spec)
                .extract()
                .as(ForbbidenErrorModel.class);
    }
}