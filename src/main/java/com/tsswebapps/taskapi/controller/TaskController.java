package com.tsswebapps.taskapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tsswebapps.taskapi.service.TaskService;

@Controller
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	
}
