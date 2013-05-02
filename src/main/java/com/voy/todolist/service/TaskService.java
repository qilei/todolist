package com.voy.todolist.service;

import java.util.List;

import com.voy.todolist.domain.Task;

public interface TaskService {
	List<Task> findAll();
}
