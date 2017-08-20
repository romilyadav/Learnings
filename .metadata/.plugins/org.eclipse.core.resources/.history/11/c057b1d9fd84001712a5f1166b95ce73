package com.tasklist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.tasklist.bean.Task;

@Component
public class TaskListDao {
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	private static String ADD_TASK = "insert into tasklist"
			+ "(taskid, taskdescription, taskcompletionstatus,userid)"
			+ "values(nextval('taskid'),?,?,"
			+ "(select userid from userlist where username=?))";
	
		
	public void addTask(Task task) throws Exception {
		Connection conn = dataSource.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(ADD_TASK);
		preparedStatement.setString(1, task.getTaskDescription());
		preparedStatement.setString(2, task.getTaskStatus());
		preparedStatement.setString(3, task.getUserName());
		preparedStatement.executeUpdate();
	}
	
	
	private static String COMPLETE_TASK = "update tasklist set taskcompletionstatus = 'Y'"
			+ "where taskid = ?";
	public void completeTask(int taskId) throws Exception{
		Connection conn = dataSource.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(COMPLETE_TASK);
		preparedStatement.setInt(1, taskId);
		preparedStatement.executeUpdate();
	}

}
