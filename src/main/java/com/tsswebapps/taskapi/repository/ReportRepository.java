package com.tsswebapps.taskapi.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.tsswebapps.taskapi.entities.Task;

public interface ReportRepository {

	public List<Task> getTasksByDate(LocalDateTime dateInit, LocalDateTime dateEnd);
	public List<Task> getTasksPartialDescription(String partialDescription);
}
