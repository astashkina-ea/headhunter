package ru.hh.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForbbidenErrorModel {

    @JsonProperty("request_id")
    private String idRequest;
    private List<Errors> errors;
}