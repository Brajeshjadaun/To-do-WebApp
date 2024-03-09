package com.servlet.student_to_do_web_app.service;

import java.time.LocalDate;
import java.util.List;

import com.servlet.student_to_do_web_app.dao.TaskDao;
import com.servlet.student_to_do_web_app.dto.Task;

public class TaskService {
	
	TaskDao taskDao = new TaskDao();
	
	public Task saveTaskService(Task task, int stId) {
		return taskDao.saveTaskDao(task, stId);
	}
	
	public Task getTaskByIdService(int taskId) {
		return taskDao.getTaskByIdDao(taskId);
	}

	public List<Task> getAllTaskService(int stId){
		return taskDao.getAllTaskDao(stId);	
	}
	
	public List<Task> getTasksByDateService(int stId, LocalDate taskDate){
		return taskDao.getTasksByDateDao(stId, taskDate);
	}
	
	public int deleteTaskService(int taskId) {
		return taskDao.deleteTaskDao(taskId);
	}
	
	public int updateTaskService(Task task) {
		return taskDao.updateTaskDao(task);
	}
	
}
