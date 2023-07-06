package ru.hh.api.service;

import ru.hh.api.models.DictionariesModel;

import static io.restassured.RestAssured.given;
import static ru.hh.api.specs.Specs.requestSpec;
import static ru.hh.api.specs.Specs.response200Spec;

public class GetDictionariesApi {

    public static DictionariesModel getDictionaries() {
        return given(requestSpec)
                .when()
                .get("/dictionaries")
                .then()
                .spec(response200Spec)
                .extract()
                .as(DictionariesModel.class);
    }
}