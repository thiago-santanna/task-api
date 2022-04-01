package com.tsswebapps.taskapi.entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.tsswebapps.taskapi.dto.TaskDto;

@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue
	private UUID id;

	@Column(nullable = false)
	private String description;

	@CreationTimestamp
	private LocalDate createdAt;

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

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

	public Task(UUID id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public Task() {
	}

	public TaskDto toTaskDto() {
		return new TaskDto(this.id, this.description);
	}

}
