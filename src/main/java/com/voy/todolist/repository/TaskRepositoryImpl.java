package com.voy.todolist.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.voy.todolist.domain.Task;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public TaskRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Task> findAll() {
		return currentSession().createCriteria(Task.class).list();
	}

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

}
