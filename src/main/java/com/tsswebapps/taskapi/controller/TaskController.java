package com.tsswebapps.taskapi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<TaskDto> saveTask(@RequestBody TaskFormDto taskDto){
		TaskDto task = taskService.salvarTask(taskDto);
		
		return new ResponseEntity<TaskDto>(task, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TaskDto> findOneTask(@PathVariable UUID id){
		TaskDto task = taskService.findOne(id);
		
		return new ResponseEntity<TaskDto>(task, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<TaskDto>> findAllTasks(){
		List<TaskDto> tasks = taskService.findAll();
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	
	@GetMapping("/part")
	public ResponseEntity<List<TaskDto>> findTaskPartialDescription(@RequestParam(required = true, name = "part") String part){
		List<TaskDto> tasks = taskService.tasksPartialDescription(part);
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	
	@GetMapping("/period")
	public ResponseEntity<List<TaskDto>> findTaskPeriod(
			@RequestParam(required = true, name = "dateInit") String dateInit,
			@RequestParam(required = true, name = "dateEnd") String dateEnd
			){
		List<TaskDto> tasks = taskService.tasksPeriod(dateInit, dateEnd);
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable UUID id){
		taskService.deleteTask(id);
		return ResponseEntity.noContent().build();
	}
}
