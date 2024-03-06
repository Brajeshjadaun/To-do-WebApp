package com.servlet.student_to_do_web_app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.servlet.student_to_do_web_app.connection.StudentConnection;
import com.servlet.student_to_do_web_app.dto.Task;

public class TaskDao {
	
	Connection connection = StudentConnection.getConnection();
	
	public Task saveTaskDao(Task task) {
		
		String insertTaskQuery = "insert into task values(?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertTaskQuery);
			preparedStatement.setInt(1, task.getTaskId());
			preparedStatement.setString(2, task.getTaskName());
			preparedStatement.setObject(3, task.getTaskDate());
			preparedStatement.setString(4, task.getTaskInfo());
			
			preparedStatement.execute();
			return task;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}return null;
		
	}

}
