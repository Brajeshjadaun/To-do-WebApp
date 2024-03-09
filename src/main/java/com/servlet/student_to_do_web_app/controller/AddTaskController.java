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
import javax.servlet.http.HttpSession;

import com.servlet.student_to_do_web_app.dto.Student;
import com.servlet.student_to_do_web_app.dto.Task;
import com.servlet.student_to_do_web_app.service.TaskService;

@WebServlet(value = "/addTask")
public class AddTaskController extends HttpServlet {
	
	TaskService taskService = new TaskService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Retrieve stId from session
	    Integer stId = (Integer) req.getSession().getAttribute("stId");
		
		HttpSession session = req.getSession();
        Student authenticatedUser = (Student) session.getAttribute("userSession");
        
        if (authenticatedUser == null) {
        	req.setAttribute("message3", "Please login again your session is out");
        	RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
        }
		
        
		String taskName = req.getParameter("taskName");
		LocalDate taskDate = LocalDate.parse(req.getParameter("taskDate"));
		String taskInfo = req.getParameter("taskInfo");
		
		
		Task task = new Task(taskName, taskDate, taskInfo);
		task.setstId(authenticatedUser.getStId());
		Task task2 = taskService.saveTaskService(task, stId);
		
		if(task2 != null) {
			req.setAttribute("message", "Task added successfully");
			RequestDispatcher dispatcher = req.getRequestDispatcher("addTask.jsp");
			dispatcher.forward(req, resp);
		}else {
			req.setAttribute("message", "Can't add Task");
			RequestDispatcher dispatcher = req.getRequestDispatcher("home");
			dispatcher.forward(req, resp);
		}
		
		
	}

}
