package com.tasklist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tasklist.bean.Task;
import com.tasklist.dao.TaskListDao;

@Component
public class TaskListService {
	
	@Autowired
	TaskListDao taskListDao;
	
	public void addTask(Task task) throws Exception {
		taskListDao.addTask(task);
	}
	
	public void markTaskComplete(Integer taskId) throws Exception {
		taskListDao.markTaskComplete(taskId);
	}
	
	public void deleteTask(Integer taskId) throws Exception{
		taskListDao.deleteTask(taskId);
	}
	
	public void getTasks(String userName) throws Exception{
		taskListDao.getTasks(userName);
	}

}
