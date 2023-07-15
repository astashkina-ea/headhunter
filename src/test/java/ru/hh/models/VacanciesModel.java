package ru.hh.models;

import java.util.List;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VacanciesModel {

    private List<ItemsVacanciesModel> items;
}