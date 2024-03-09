package com.servlet.student_to_do_web_app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.student_to_do_web_app.dto.Student;
import com.servlet.student_to_do_web_app.service.TaskService;

@WebServlet(value = "/deleteTask")
public class DeleteTaskController extends HttpServlet {
	
	TaskService taskService = new TaskService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Check if the user is authenticated
        HttpSession httpSession = req.getSession();
        Student authenticatedUser = (Student) httpSession.getAttribute("userSession");
        
        if (authenticatedUser != null) {
        	int stId = authenticatedUser.getStId();
           int taskId = Integer.parseInt(req.getParameter("taskId"));
           int x = taskService.deleteTaskService(taskId);
           if(x == 1) {
        	   req.setAttribute("message1", "Task Deleted successfully");
        	   req.getRequestDispatcher("homeDisplayAllSession").forward(req, resp);
           }else {
        	   req.setAttribute("message", "Can't delete Task");
        	   req.getRequestDispatcher("homeDisplayAllSession").forward(req, resp);
           }
        } else {
            req.setAttribute("message3", "Please login again, your session has expired.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
	}

}
