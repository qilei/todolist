package com.voy.todolist.repository;

import java.io.ByteArrayOutputStream;
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
	public List<Task> findAll() {
		List<Task> result=null;
		Session session = currentSession();
		try {
			session.beginTransaction();
			result = session.createCriteria(Task.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		return result;
	}

	public void add(Task task) {
		Session session = currentSession();
		try {
			session.beginTransaction();
			session.save(task);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
}
