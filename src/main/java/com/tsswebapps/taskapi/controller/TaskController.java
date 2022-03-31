package com.tsswebapps.taskapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsswebapps.taskapi.dto.TaskDto;
import com.tsswebapps.taskapi.dto.TaskFormDto;
import com.tsswebapps.taskapi.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@PostMapping
	public ResponseEntity<TaskDto> salvarTask(@RequestBody TaskFormDto taskDto){
		TaskDto task = taskService.salvarTask(taskDto);
		
		return new ResponseEntity<TaskDto>(task, HttpStatus.CREATED);
	}
}
