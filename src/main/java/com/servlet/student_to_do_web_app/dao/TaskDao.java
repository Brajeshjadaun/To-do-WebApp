package com.servlet.student_to_do_web_app.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.servlet.student_to_do_web_app.connection.StudentConnection;
import com.servlet.student_to_do_web_app.dto.Task;

public class TaskDao {
	
	static Connection connection = StudentConnection.getConnection();
	
	public Task saveTaskDao(Task task, int stId) {
		
		String insertTaskQuery = "insert into task values(?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertTaskQuery);
			preparedStatement.setInt(1, task.getTaskId());
			preparedStatement.setString(2, task.getTaskName());
			preparedStatement.setObject(3, task.getTaskDate());
			preparedStatement.setString(4, task.getTaskInfo());
			preparedStatement.setInt(5, stId);
			
			preparedStatement.execute();
			return task;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}return null;
	}
	
	public List<Task> getAllTaskDao(int stId){
		String displayAllTaskQuery = "select * from task where stId=?";
		Task task = null;
		
		try {
			List<Task> tasks = new ArrayList<>();
			PreparedStatement preparedStatement = connection.prepareStatement(displayAllTaskQuery);
			preparedStatement.setInt(1, stId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int taskId = resultSet.getInt("taskId");
				String taskName = resultSet.getString("taskName");
				LocalDate taskDate = resultSet.getDate("taskDate").toLocalDate();
				String taskInfo = resultSet.getString("taskInfo");
				
				task = new Task(taskId, taskName, taskDate, taskInfo, stId);
				tasks.add(task);
			}
			return tasks;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}return null;
	}

	public List<Task> getTasksByDateDao(int stId, LocalDate taskDate) {
		String displayByDateQuery = "select * from task where stId = ? and taskDate = ?";
        List<Task> tasks = new ArrayList<>();

        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(displayByDateQuery);
        	preparedStatement.setInt(1, stId);
        	preparedStatement.setDate(2, Date.valueOf(taskDate));
            ResultSet resultSet = preparedStatement.executeQuery();
            
                while (resultSet.next()) {
                    int taskId = resultSet.getInt("taskId");
                    String taskName = resultSet.getString("taskName");
                    LocalDate date = resultSet.getDate("taskDate").toLocalDate();
                    String taskInfo = resultSet.getString("taskInfo");

                    Task task = new Task(taskId, taskName, date, taskInfo);
                    tasks.add(task);
                }
                return tasks;
                
        } catch (SQLException e) {
            e.printStackTrace();
        }return null;

	}
	
	public int deleteTaskDao(int taskId) {
		String deleteTaskQuery = "delete from task where taskId=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteTaskQuery);
			preparedStatement.setInt(1, taskId);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}return 0;
	}

}
