package ru.hh.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;
import ru.hh.config.ApiConfig;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.*;
import static ru.hh.helpers.CustomAllureListener.withCustomTemplates;

public class Specs {

    private static ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());

    public static RequestSpecification requestSpec = with()
            .log().uri()
            .log().body()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON)
            .baseUri(config.baseApiUrl());

    public static ResponseSpecification response200Spec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();

    public static ResponseSpecification response403Spec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(403)
            .build();
}