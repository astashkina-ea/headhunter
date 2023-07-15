package ru.hh.service;

import ru.hh.models.EmployersModel;

import static io.restassured.RestAssured.given;
import static ru.hh.specs.Specs.requestSpec;
import static ru.hh.specs.Specs.response200Spec;

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