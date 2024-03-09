package com.servlet.student_to_do_web_app.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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

@WebServlet(value = "/homeDisplayDateSession")
public class HomeDisplayDateSessionController extends HttpServlet {
	
	TaskService taskService = new TaskService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		Student authenticatedUser = (Student) httpSession.getAttribute("userSession");
		
		if (authenticatedUser != null) {
            String taskDateStr = req.getParameter("taskDate");
            LocalDate taskDate = null;

            try {
                taskDate = LocalDate.parse(taskDateStr);
            } catch (DateTimeParseException e) {
                // Handle invalid date format
                req.setAttribute("message", "Invalid date format. Please enter date in yyyy-MM-dd format.");
                req.getRequestDispatcher("home").forward(req, resp);
            }

            int stId = authenticatedUser.getStId();
            List<Task> tasks = taskService.getTasksByDateService(stId, taskDate);
            req.setAttribute("tasks", tasks);
            req.setAttribute("taskDate", taskDate);
            req.setAttribute("stId", stId);
            req.setAttribute("message", "No task found for this date");
            req.getRequestDispatcher("displayTasks.jsp").forward(req, resp);
        } else {
            req.setAttribute("message3", "Please login again, your session has expired.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
	}
}
