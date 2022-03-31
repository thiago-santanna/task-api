package com.tsswebapps.taskapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.taskapi.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository repository;

}
