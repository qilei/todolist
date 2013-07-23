package test.com.voy.todolist.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;

import com.voy.todolist.domain.Task;
import com.voy.todolist.domain.TaskResolver;

public class TaskResolverTest {
	@Test
	public void resolve_complex_task(){
		String taskInfo="task item 1 @30 !A";
		Task task=TaskResolver.resolve(taskInfo);
		assertThat(task.getInfo(),equalTo("task item 1"));
		assertThat(task.getDuration(),equalTo("30"));
		assertThat(task.getPriority(),equalTo("A"));
	}
}
