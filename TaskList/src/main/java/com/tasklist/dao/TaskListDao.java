package com.tasklist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * Add task to the task list.
	 * @param task
	 * @throws Exception
	 */
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
	
	
	/**
	 * Marks a task as complete given a task id
	 * @param taskId
	 * @throws Exception
	 */
	public void markTaskComplete(Integer taskId) throws Exception{
		Connection conn = dataSource.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(COMPLETE_TASK);
		preparedStatement.setInt(1, taskId);
		preparedStatement.executeUpdate();
	}
	
	
	private static String DELETE_TASK = "delete from tasklist where taskid = ?";
	
	/**
	 * Deletes a task give task id.
	 * @param taskId
	 * @throws Exception
	 */
	public void deleteTask(Integer taskId) throws Exception {
		Connection conn = dataSource.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(DELETE_TASK);
		preparedStatement.setInt(1, taskId);
		preparedStatement.executeUpdate();
	}
	
	private static String GET_TASKS = "select *"
			  + "from tasklist where userid in (select userid from userlist where username=?)";
	
	/**
	 * Returns a list of tasks for a given user.
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public List<Task> getTasks(String userName) throws Exception{
		Connection conn = dataSource.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(GET_TASKS);
		preparedStatement.setString(1, userName);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Task> tasks = new ArrayList<>();
		while (resultSet.next()) {
			Task tasktest = new Task();
			tasktest.setTaskId(resultSet.getInt("taskid"));
			tasktest.setTaskDescription(resultSet.getString("taskdescription"));
			tasktest.setTaskStatus(resultSet.getString("taskcompletionstatus"));
			tasktest.setUserName(userName);
			tasks.add(tasktest);
		}
		
		return tasks;
	}
			
 }
