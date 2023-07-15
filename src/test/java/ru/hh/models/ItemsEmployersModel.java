package ru.hh.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemsEmployersModel {

    @JsonProperty("logo_urls")
    private Object logoUrls;
    @JsonProperty("open_vacancies")
    private Integer openVacancies;
    @JsonProperty("vacancies_url")
    private String vacanciesUrl;
    private String name;
    private String id;
    @JsonProperty("alternate_url")
    private String alternateUrl;
    private String url;

    public String toStringLogoUrl(Object o) {
        if (o == null) {
            return "object is null";
        } else {
            return getLogoUrls().toString();
        }
    }
}