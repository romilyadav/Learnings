package com.tasklist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasklist.bean.Task;
import com.tasklist.service.TaskListService;



@RestController
public class TaskListController {
	
	@Autowired
	TaskListService taskListService;
	
	@RequestMapping(value="/addTask", method=RequestMethod.POST)
	public void addTask(@RequestBody Task task) throws Exception{
		taskListService.addTask(task);
	}
	
	
	@RequestMapping(value="/markTaskComplete/{taskId}", method=RequestMethod.POST)
	public void markTaskComplete(@PathVariable Integer taskId) throws Exception{
		taskListService.markTaskComplete(taskId);
	}
	
	
	@RequestMapping(value="/deleteTask/{taskId}", method=RequestMethod.POST)
	public void deleteTask(@PathVariable Integer taskId) throws Exception {
		taskListService.deleteTask(taskId);
	}
	
	@RequestMapping(value="/getTasks", method=RequestMethod.GET)
	public void getTasks(@RequestParam String userName) throws Exception{
		taskListService.getTasks(userName);
	}

}
