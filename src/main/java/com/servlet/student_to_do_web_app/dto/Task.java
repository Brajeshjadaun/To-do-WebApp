package com.servlet.student_to_do_web_app.dto;

import java.time.LocalDate;

public class Task {
	
	private int taskId;
	private String taskName;
	private LocalDate taskDate;
	private String taskInfo;
	private int stId;
	public Task(int taskId, String taskName, LocalDate taskDate, String taskInfo, int stId) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDate = taskDate;
		this.taskInfo = taskInfo;
		this.stId = stId;
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
	public Task(int taskId2, String taskName2, LocalDate taskDate2, String taskInfo2) {
		// TODO Auto-generated constructor stub
		this.taskId = taskId2;
		this.taskName = taskName2;
		this.taskDate = taskDate2;
		this.taskInfo = taskInfo2;
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
	public int getstId() {
		return stId;
	}
	public void setstId(int stId) {
		this.stId = stId;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", taskDate=" + taskDate + ", taskInfo=" + taskInfo
				+ "]";
	}
	
	

}
