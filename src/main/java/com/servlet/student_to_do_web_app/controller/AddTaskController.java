package com.servlet.student_to_do_web_app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.student_to_do_web_app.dto.Task;
import com.servlet.student_to_do_web_app.service.TaskService;

@WebServlet(value = "/taskInformation")
public class AddTaskController extends HttpServlet {
	
	TaskService taskService = new TaskService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		int taskId = Integer.parseInt(req.getParameter("taskId"));
		String taskName = req.getParameter("taskName");
		LocalDate taskDate = LocalDate.parse(req.getParameter("taskDate"));
		String taskInfo = req.getParameter("taskInfo");
		
		Task task = new Task(taskName, taskDate, taskInfo);
		Task task2 = taskService.saveTaskService(task);
		
		PrintWriter printWriter = resp.getWriter();
		
		if(task2 != null) {
			printWriter.write("<html><body><h1 style='color:green; background-color:white;display:flex; align-items:center;justify-content:center;'>Task added successfully</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("addTask.jsp");
			dispatcher.include(req, resp);
		}else {
			printWriter.write("<html><body><h1 style='color:red;background-color:white;display:flex; align-items:center;justify-content:center;'>Can't add Task</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.include(req, resp);
		}
		
		
	}

}
