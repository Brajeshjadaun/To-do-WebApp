package com.servlet.student_to_do_web_app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.student_to_do_web_app.dto.Student;

@WebServlet(value = "/logout")
public class LogoutStudentController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		Student authenticatedUser = (Student) httpSession.getAttribute("userSession");
		
		if(authenticatedUser != null) {
			httpSession.invalidate();
			req.setAttribute("message3", "LogOut successfull");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
	}
}
