package ru.hh.api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NegotiationModel {

    @JsonProperty("vacancy_id")
    String idVacancy;
    @JsonProperty("resume_id")
    String idResume;
    String message;
}