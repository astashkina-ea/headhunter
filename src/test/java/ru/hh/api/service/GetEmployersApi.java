package ru.hh.api.service;

import ru.hh.api.models.EmployersModel;

import static io.restassured.RestAssured.given;
import static ru.hh.api.specs.Specs.requestSpec;
import static ru.hh.api.specs.Specs.response200Spec;

public class GetEmployersApi {

    public static EmployersModel getEmployers() {
        return given(requestSpec)
                .when()
                .get("/employers")
                .then()
                .spec(response200Spec)
                .extract()
                .as(EmployersModel.class);
    }
}