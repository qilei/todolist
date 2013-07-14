package test.support.com.voy.todolist.builders;

import java.util.Date;

import com.voy.todolist.domain.Task;


public class TaskBuilder extends AbstractBuilder<TaskBuilder, Task> {
	private String item ="item text";
	private String duration="1h";
	private String priority="B";
	private Date dueDate=new Date();
	
    public static TaskBuilder aTask() {
        return new TaskBuilder();
    }
	
	public TaskBuilder withItem(String item){
		TaskBuilder other=this.clone();
		other.item=item;
		return other;
	}
	
	public TaskBuilder withDueDate(Date date){
		TaskBuilder other=this.clone();
		other.dueDate=date;
		return other;
	}

	public Task build() {
		return new Task(item,duration,priority,dueDate);
	}
}
