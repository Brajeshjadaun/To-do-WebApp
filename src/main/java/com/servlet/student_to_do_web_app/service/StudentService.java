package com.servlet.student_to_do_web_app.service;

import com.servlet.student_to_do_web_app.dao.StudentDao;
import com.servlet.student_to_do_web_app.dto.Student;

public class StudentService {
	
	StudentDao studentDao = new StudentDao();

	public Student saveStudentService(Student student) {
		return studentDao.saveStudentDao(student);
	}
	
	public Student getStudentService(String userName, String password) {
		return studentDao.getStudentDao(userName, password);
	}
	
}
