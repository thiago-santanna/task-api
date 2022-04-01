package com.tsswebapps.taskapi.dto;

import com.tsswebapps.taskapi.entities.Task;

public class TaskFormDto {

	private String description;

	public String getDescription() {
		return description;
	}

	public TaskFormDto(String description) {
		this.description = description;
	}

	public Task toTask() {
		return new Task(null, description);
	}

	public TaskFormDto() {}
	
}
