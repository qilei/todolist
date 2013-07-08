package test.integration.com.voy.todolist.repository;

import java.util.List;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.voy.todolist.domain.Task;
import com.voy.todolist.repository.TaskRepository;

import test.support.com.voy.todolist.TestEnvironment;
import test.support.com.voy.todolist.db.Database;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.iterableWithSize;
import static test.support.com.voy.todolist.builders.TaskBuilder.aTask;

public class TaskRepositoryImplTest {
	TestEnvironment environment=TestEnvironment.load();
	Database database=Database.in(environment);
	
	TaskRepository taskRepository=environment.get(TaskRepository.class);
	
	@Test 
	public void findAll(){
		database.given(aTask().withItem("task 1"));
		
		List<Task> taskes=taskRepository.findAll();
		
        assertThat("matching products", taskes, hasSize(equalTo(1)));
	}

    private Matcher<Iterable<Task>> hasSize(Matcher<? super Integer> sizeMatcher) {
        return iterableWithSize(sizeMatcher);
    }

    @Before public void
    cleanDatabase() {
        database.clean();
    }

    @After public void
    closeDatabase() {
        database.close();
    }
}
