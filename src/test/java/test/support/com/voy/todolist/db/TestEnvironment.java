package test.support.com.voy.todolist.db;

import java.util.Properties;

import test.support.com.voy.todolist.PropertyFile;

public class TestEnvironment {

    private static final String INTEGRATION_TEST_PROPERTIES = "integration/test.properties";
    private static TestEnvironment environment;

    private Spring spring;

    public static TestEnvironment load() {
        if (environment == null) {
            environment = load(INTEGRATION_TEST_PROPERTIES);
        }
        return environment;
    }

    public static TestEnvironment load(final String name) {
        return new TestEnvironment(PropertyFile.load(name));
    }

    public TestEnvironment(Properties properties) {
        loadSpringContext(properties);
//        migrateDatabase();
    }

    private void loadSpringContext(Properties properties) {
        this.spring = new Spring(properties);
    }

    private void migrateDatabase() {
//        new DatabaseMigrator(spring.getDataSource()).migrate();
    }

    public <T> T get(Class<T> type) {
        return spring.getBean(type);
    }
}
