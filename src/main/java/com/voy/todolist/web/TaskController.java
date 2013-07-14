package com.voy.todolist.web;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.voy.todolist.domain.Task;
import com.voy.todolist.repository.TaskRepository;
@Controller
public class TaskController {
	private TaskRepository taskRepository;

	@Autowired
	public TaskController(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}

	@RequestMapping(value="/")
	public String index(Model model){
		List<Task> items=taskRepository.findAll();
		model.addAttribute("items", items);
		return "index";
	}
	
	@RequestMapping(value="/task/add",method=RequestMethod.POST)
	public String add(@RequestParam(value="task") String taskInfo){
		Task task =new Task();
		task.setInfo(taskInfo);
		task.setPriority("B");
		task.setDuration("1h");
		task.setDueDate(Calendar.getInstance().getTime());
		taskRepository.add(task);
		return "redirect:/";
	}

}
