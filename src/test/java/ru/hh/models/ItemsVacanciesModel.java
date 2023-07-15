package ru.hh.models;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsVacanciesModel {

    private AreaModel area;
    private EmploymentModel employment;
}