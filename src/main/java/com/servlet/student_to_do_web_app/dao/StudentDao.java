package com.servlet.student_to_do_web_app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.servlet.student_to_do_web_app.dto.Student;
import com.servlet.student_to_do_web_app.connection.StudentConnection;

public class StudentDao {
	
	Connection connection = StudentConnection.getConnection();
	
	public Student saveStudentDao(Student student) {
		
		String insertStudentQuery = "insert into student values(?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertStudentQuery);
			preparedStatement.setInt(1, student.getStId());
			preparedStatement.setString(2, student.getStName());
			preparedStatement.setString(3, student.getStEmail());
			preparedStatement.setString(4, student.getPassword());
			preparedStatement.setString(5, student.getGender());
			
			preparedStatement.execute();
			return student;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}return null;	
	}
	
	
	public Student getStudentDao(String userName, String password) {
		
		String displayStudentQuery = "select * from student where stEmail=? and password=?";
		Student student = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(displayStudentQuery);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int stId = resultSet.getInt("stId");
				String stName = resultSet.getString("stName");
				String stEmail = resultSet.getString("stEmail");
				String stPassword = resultSet.getString("password");
				String stGender = resultSet.getString("gender");
				
				student = new Student(stId, stName, stEmail, stPassword, stGender);
				return student;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}return null;
		
	}

}
