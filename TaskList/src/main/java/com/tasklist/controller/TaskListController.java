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


/**
 *  REST api end point
 *
 */
@RestController
public class TaskListController {
	
	@Autowired
	TaskListService taskListService;
	
	/**
	 * This method is used to add new task to the task list. The
	 * task is made up of task description and the name of the user
	 * adding the task.
	 * @param task
	 * @throws Exception
	 */
	@RequestMapping(value="/addTask", method=RequestMethod.POST)
	public void addTask(@RequestBody Task task) throws Exception{
		taskListService.addTask(task);
	}
	
	
	/**
	 * This method is used to mark a task as complete. The method needs the
	 * task id that needs to be marked as complete.
	 * @param taskId
	 * @throws Exception
	 */
	@RequestMapping(value="/markTaskComplete/{taskId}", method=RequestMethod.POST)
	public void markTaskComplete(@PathVariable Integer taskId) throws Exception{
		taskListService.markTaskComplete(taskId);
	}
	
	
	/**
	 * This method is used to delete a task from the database. The method needs
	 * task id of the task that needs to be deleted.
	 * @param taskId
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteTask/{taskId}", method=RequestMethod.POST)
	public void deleteTask(@PathVariable Integer taskId) throws Exception {
		taskListService.deleteTask(taskId);
	}
	
	/**
	 * This method returns the list of tasks given a user name
	 * @param userName
	 * @throws Exception
	 */
	
	@RequestMapping(value="/getTasks", method=RequestMethod.GET)
	public void getTasks(@RequestParam String userName) throws Exception{
		taskListService.getTasks(userName);
	}

}
