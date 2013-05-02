package test.support.com.voy.todolist.db;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface UnitOfWork {

    void work(Session session) throws HibernateException;
}
