package com.servlet.student_to_do_web_app.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.student_to_do_web_app.dao.TaskDao;
import com.servlet.student_to_do_web_app.dto.Student;
import com.servlet.student_to_do_web_app.dto.Task;
import com.servlet.student_to_do_web_app.service.TaskService;

@WebServlet(value = "/updateTask")
public class UpdateTaskController extends HttpServlet {

	TaskService taskService = new TaskService();
	TaskDao taskDao = new TaskDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		Student authenticatedUser = (Student) httpSession.getAttribute("userSession");
				
		if(authenticatedUser != null) {
			
			int taskId = Integer.parseInt(req.getParameter("taskId"));
			Task task = taskDao.getTaskByIdDao(taskId);
			
			if(task.getTaskName() != req.getParameter("taskName")) {
				task.setTaskName(req.getParameter("taskName"));
			}
			if(task.getTaskDate() != LocalDate.parse(req.getParameter("taskDate"))) {
				task.setTaskDate(LocalDate.parse(req.getParameter("taskDate")));
			}
			if(task.getTaskInfo() != req.getParameter("taskInfo")) {
				task.setTaskInfo(req.getParameter("taskInfo"));
			}
			
			int x = taskService.updateTaskService(task);
			if(x == 1) {
				req.setAttribute("message1", "Task Updated successfully");
	        	req.getRequestDispatcher("homeDisplayAllSession").forward(req, resp);
	        }else {
	        	req.setAttribute("message", "Can't Update Task");
	        	req.getRequestDispatcher("homeDisplayAllSession").forward(req, resp);
	        }
		}else {
			req.setAttribute("message3", "Please login again, your session has expired.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
