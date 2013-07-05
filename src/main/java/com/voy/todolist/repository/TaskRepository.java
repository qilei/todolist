package com.voy.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.voy.todolist.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{
}
