package com.pkslearning.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkslearning.todo.model.Task;
import com.pkslearning.todo.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskRepository taskRepo;
	
	public List<Task> getAllTasks()
	{
		return taskRepo.findAll();
	}
	
	public void createTask(String title)
	{
		Task task=new Task();
		task.setTitle(title);
		task.setCompleted(false);
		
		taskRepo.save(task);
	}
	
	public void deleteTask(Long id)
	{
		taskRepo.deleteById(id);
		
		
	}

	@Override
	public void toggleTask(Long id) {
		Task task=taskRepo.findById(id)
				.orElseThrow(()->new IllegalArgumentException("Invalid task id"));
				task.setCompleted(!task.isCompleted());
		taskRepo.save(task);
	}
	

}
