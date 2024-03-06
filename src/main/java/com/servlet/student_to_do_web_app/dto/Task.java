package com.servlet.student_to_do_web_app.dto;

import java.time.LocalDate;

public class Task {
	
	private int taskId;
	private String taskName;
	private LocalDate taskDate;
	private String taskInfo;
	public Task(int taskId, String taskName, LocalDate taskDate, String taskInfo) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDate = taskDate;
		this.taskInfo = taskInfo;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(String taskName, LocalDate taskDate, String taskInfo) {
		// TODO Auto-generated constructor stub
		this.taskName = taskName;
		this.taskDate = taskDate;
		this.taskInfo = taskInfo;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public LocalDate getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}
	public String getTaskInfo() {
		return taskInfo;
	}
	public void setTaskInfo(String taskInfo) {
		this.taskInfo = taskInfo;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", taskDate=" + taskDate + ", taskInfo=" + taskInfo
				+ "]";
	}
	
	

}
