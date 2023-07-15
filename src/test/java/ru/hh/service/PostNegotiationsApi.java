package ru.hh.service;

import ru.hh.models.ForbbidenErrorModel;
import ru.hh.models.NegotiationModel;

import static io.restassured.RestAssured.given;
import static ru.hh.specs.Specs.*;

public class PostNegotiationsApi {

    public static ForbbidenErrorModel postNegotiationsWithForbbidenError(NegotiationModel negotiation) {
        return given(requestSpec)
                .body(negotiation)
                .when()
                .post("/negotiations")
                .then()
                .spec(response403Spec)
                .extract()
                .as(ForbbidenErrorModel.class);
    }
}