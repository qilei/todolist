package com.voy.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.voy.todolist.domain.Task;
import com.voy.todolist.repository.TaskRepository;

@Service("taskService")
@Repository
public class TaskServiceImpl implements TaskService {

	private TaskRepository taskRepository;

	@Autowired
	public TaskServiceImpl(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}

	public List<Task> findAll() {
		return Lists.newArrayList(taskRepository.findAll());
	}

}
