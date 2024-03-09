package com.servlet.student_to_do_web_app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.student_to_do_web_app.dto.Student;
import com.servlet.student_to_do_web_app.service.StudentService;

@WebServlet(value = "/loginStudent")
public class LoginController extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StudentService studentService = new StudentService();
		
		//memory allocation for session
		HttpSession httpSession = req.getSession();

		String stEmail = req.getParameter("email");
		String password = req.getParameter("password");
		

		Student student = studentService.getStudentService(stEmail, password);
		


		if (student != null) {
			httpSession.setAttribute("userSession", student);
			httpSession.setAttribute("stId", student.getStId());//Set the stId in the session
			httpSession.setMaxInactiveInterval(40);
			req.setAttribute("message1", "Login-Successfull");
			req.setAttribute("message2", student);
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.include(req, resp);
		} else {
			req.setAttribute("message3", "Invalid UserName or Password");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}

	}

}
