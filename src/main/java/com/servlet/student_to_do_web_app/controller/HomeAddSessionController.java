package com.servlet.student_to_do_web_app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/homeAddSession")
public class HomeAddSessionController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		if(httpSession.getAttribute("userSession") != null) {
			req.getRequestDispatcher("addTask.jsp").include(req, resp);
		}else {
			req.setAttribute("message3", "Please login again your session is out");
			req.getRequestDispatcher("login.jsp").include(req, resp);
		}
		
	}
	
}
