package com.tasklist.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tasklist.bean.Task;



@RestController
public class TaskListController {
	
	@RequestMapping(value="/addTask", method=RequestMethod.POST)
	public void addTask(@RequestBody Task task) throws Exception{
		System.out.println("Hello World");
	}
	

}
