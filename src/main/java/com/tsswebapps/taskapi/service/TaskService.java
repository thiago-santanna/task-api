package com.tsswebapps.taskapi.service;

import java.util.Optional;
import java.util.UUID;

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

}
