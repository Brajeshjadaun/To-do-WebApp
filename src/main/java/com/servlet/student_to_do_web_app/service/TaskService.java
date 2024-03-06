package com.servlet.student_to_do_web_app.service;

import com.servlet.student_to_do_web_app.dao.TaskDao;
import com.servlet.student_to_do_web_app.dto.Task;

public class TaskService {
	
	TaskDao taskDao = new TaskDao();
	
	public Task saveTaskService(Task task) {
		return taskDao.saveTaskDao(task);
	}

}
