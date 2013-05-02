package test.integration.com.voy.todolist.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static test.support.com.voy.todolist.builders.TaskBuilder.aTask;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.support.com.voy.todolist.db.Database;
import test.support.com.voy.todolist.db.TestEnvironment;

import com.voy.todolist.domain.Task;
import com.voy.todolist.service.TaskService;

public class TaskServiceTest {

    TestEnvironment environment = TestEnvironment.load();

    Database database = Database.in(environment);
    TaskService taskService = environment.get(TaskService.class);

    @Before public void
    cleanDatabase() {
        database.clean();
    }

    @After public void
    closeDatabase() {
        database.close();
    }
    
	@Test
	public void testSth(){
        database.given(aTask().withItem("task 1"));
        
        List<Task> tasks=taskService.findAll();
        assertThat("no match", tasks.size()==1);
	}
}
