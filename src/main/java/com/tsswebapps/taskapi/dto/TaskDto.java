package com.tsswebapps.taskapi.dto;

import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TaskDto {
	
	private UUID id;
	
	@NotBlank
	@NotNull
	private String description;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public TaskDto() {
		// TODO Auto-generated constructor stub
	}

	public TaskDto(UUID id, @NotBlank @NotNull String description) {
		super();
		this.id = id;
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskDto other = (TaskDto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "TaskDto [id=" + id + ", description=" + description + "]";
	}
	
	
}
