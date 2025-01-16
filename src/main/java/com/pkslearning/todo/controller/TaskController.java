package com.pkslearning.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pkslearning.todo.model.Task;
import com.pkslearning.todo.service.TaskService;

@Controller
//@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	
	@GetMapping
	public String getTasks(Model model)
	{
		List<Task> tasks=taskService.getAllTasks();
		model.addAttribute("tasks", tasks);
		
		return "tasks";
	}
	
	@PostMapping
	public String createTask(@RequestParam String title)
	{
		taskService.createTask(title);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteTask(@PathVariable Long id)
	{
		taskService.deleteTask(id);
		
		return "redirect:/";
	}
	
	@GetMapping("/{id}/toggle")
	public String toggleTask(@PathVariable Long id)
	{
		taskService.toggleTask(id);
		
		return "redirect:/";
	}
	
	
}
