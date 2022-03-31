package com.tsswebapps.taskapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsswebapps.taskapi.entities.Task;

public interface TaskRepository extends JpaRepository<Task, UUID> {

}
