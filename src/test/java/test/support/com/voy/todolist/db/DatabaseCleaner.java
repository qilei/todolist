package test.support.com.voy.todolist.db;

import com.voy.todolist.domain.Task;

import org.hibernate.Session;

public class DatabaseCleaner {

    private static final Class<?>[] ENTITY_TYPES = {
            Task.class
    };
    private static final String[] SEQUENCE_NAMES = {
            "order_number_sequence"
    };

    private final Database database;

    public DatabaseCleaner(Database database) {
        this.database = database;
    }

    public void clean() {
        database.perform(new UnitOfWork() {
            public void work(Session session) {
                clear(session);
                deleteEntities(session);
//                resetSequences(session);
            }
        });
    }

    private void clear(Session session) {
        session.clear();
    }

    private void resetSequences(Session session) {
        for (String sequenceName : SEQUENCE_NAMES) {
            session.createSQLQuery("truncate " + sequenceName).executeUpdate();
        }
    }

    private void deleteEntities(Session session) {
        for (Class<?> entityType : ENTITY_TYPES) {
            session.createQuery("delete from " + entityNameOf(entityType)).executeUpdate();
        }
    }

    private String entityNameOf(Class<?> entityType) {
        return entityType.getName();
    }
}
