package com.servlet.student_to_do_web_app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.student_to_do_web_app.dto.Student;
import com.servlet.student_to_do_web_app.dto.Task;
import com.servlet.student_to_do_web_app.service.TaskService;

@WebServlet(value = "/homeDisplayAllSession")
public class HomeDisplayAllSessionController extends HttpServlet {
	
	TaskService taskService = new TaskService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		
		if(httpSession.getAttribute("userSession") != null) {
			// Get stId of the logged-in user from session
            Student authenticatedUser = (Student) httpSession.getAttribute("userSession");
            int stId = authenticatedUser.getStId();
            List<Task> tasks = taskService.getAllTaskService(stId);
            req.setAttribute("tasks", tasks);
            req.setAttribute("stId", stId);
			req.getRequestDispatcher("displayTasks.jsp").forward(req, resp);
		}else {
			req.setAttribute("message3", "Please login again your session is out");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
