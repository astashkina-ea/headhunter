package ru.hh.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmployersModel {

    @JsonProperty("per_page")
    private int perPage;
    private int found;
    private int pages;
    private int page;
    private List<ItemsEmployersModel> items;
}