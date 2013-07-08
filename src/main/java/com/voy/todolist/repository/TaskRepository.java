package com.voy.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.voy.todolist.domain.Task;

public interface TaskRepository {
	public List<Task> findAll();
}
