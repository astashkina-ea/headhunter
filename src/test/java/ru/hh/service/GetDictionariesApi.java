package ru.hh.service;

import ru.hh.models.DictionariesModel;

import static io.restassured.RestAssured.given;
import static ru.hh.specs.Specs.requestSpec;
import static ru.hh.specs.Specs.response200Spec;

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