package com.voy.todolist.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.voy.todolist.domain.Task;

public interface TaskRepository extends PagingAndSortingRepository<Task, Integer>{
}
