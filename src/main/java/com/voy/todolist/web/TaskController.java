package com.voy.todolist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.voy.todolist.domain.Task;
import com.voy.todolist.service.TaskService;
@Controller
public class TaskController {
	private TaskService taskService;

	@Autowired
	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}

	@RequestMapping(value="/")
	public String index(Model model){
//		List<Task> items=taskService.findAll();
//		model.addAttribute("items", items);
		return "index";
	}

}
