package ru.hh.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NegotiationModel {

    @JsonProperty("vacancy_id")
    private String idVacancy;
    @JsonProperty("resume_id")
    private String idResume;
    private String message;
}