package com.tsswebapps.taskapi.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.taskapi.dto.TaskDto;
import com.tsswebapps.taskapi.dto.TaskFormDto;
import com.tsswebapps.taskapi.entities.Task;
import com.tsswebapps.taskapi.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository repository;

	public TaskDto salvarTask(TaskFormDto taskDto) {
		Task savedTask = repository.save(taskDto.toTask());
		return savedTask.toTaskDto(); 
	}

	public TaskDto findOne(UUID id) {
		Optional<Task> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get().toTaskDto();
		}
		
		return null;
	}

	public void deleteTask(UUID id) {
		repository.deleteById(id);		
	}

	public List<TaskDto> findAll() {
		
		return repository.findAll()
				.stream()
				.map(Task::toTaskDto)
				.collect(Collectors.toList());
	}

	public List<TaskDto> tasksPartialDescription(String part) {
		
		System.out.println(part);
		List<Task> tasksPartialDescription = repository.getTasksPartialDescription(part);
		return tasksPartialDescription.stream()
				.map(Task::toTaskDto)
				.collect(Collectors.toList());
	}

	public List<TaskDto> tasksPeriod(String dateInit, String dateEnd) {
		LocalDate dateIni = LocalDate.parse(dateInit);
		LocalDate dateFin = LocalDate.parse(dateEnd);
		
		List<Task> tasksByDate = repository.getTasksByDate(dateIni, dateFin);
		
		return tasksByDate.stream()
				.map(Task::toTaskDto)
				.collect(Collectors.toList());
	}
}
