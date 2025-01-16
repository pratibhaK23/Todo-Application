package com.pkslearning.todo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.pkslearning.todo.model.Task;

public interface TaskService {

	public List<Task> getAllTasks();
	public void createTask(String title);
	public void deleteTask(Long id);
	public void toggleTask(Long id);
;

}
