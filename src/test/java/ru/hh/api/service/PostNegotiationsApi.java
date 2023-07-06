package ru.hh.api.service;

import ru.hh.api.models.ForbbidenErrorModel;
import ru.hh.api.models.NegotiationModel;

import static io.restassured.RestAssured.given;
import static ru.hh.api.specs.Specs.*;

public class PostNegotiationsApi {

    public static ForbbidenErrorModel postNegotiationsWithForbbidenError(NegotiationModel negotiation) {
        return given(requestSpec)
                .body(negotiation)
                .when()
                .get("/negotiations")
                .then()
                .spec(response403Spec)
                .extract()
                .as(ForbbidenErrorModel.class);
    }
}