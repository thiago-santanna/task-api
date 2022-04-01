package com.tsswebapps.taskapi.repository;

import java.time.LocalDate;
import java.util.List;

import com.tsswebapps.taskapi.entities.Task;

public interface ReportRepository {

	public List<Task> getTasksByDate(LocalDate dateInit, LocalDate dateEnd);
	public List<Task> getTasksPartialDescription(String partialDescription);
}
