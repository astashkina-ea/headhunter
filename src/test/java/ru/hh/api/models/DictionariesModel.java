package ru.hh.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DictionariesModel {

	private List<EmploymentModel> employment;
	private List<ScheduleModel> schedule;
}