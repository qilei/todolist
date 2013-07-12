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
	public List<Task> findAll() {
		Session session=currentSession();
		try {
			session.beginTransaction();
			List<Task> result= session.createCriteria(Task.class).list();
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return currentSession().createCriteria(Task.class).list();
	}

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

}
