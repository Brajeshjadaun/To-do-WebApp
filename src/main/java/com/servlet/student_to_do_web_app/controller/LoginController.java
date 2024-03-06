package com.servlet.student_to_do_web_app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.student_to_do_web_app.dto.Student;
import com.servlet.student_to_do_web_app.service.StudentService;

@WebServlet(value = "/loginStudent")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StudentService studentService = new StudentService();

		String stEmail = req.getParameter("email");
		String password = req.getParameter("password");

		Student student = studentService.getStudentService(stEmail, password);


		PrintWriter printWriter = resp.getWriter();

		if (student != null) {
			int stId = student.getStId();
			String stName = student.getStName();
			String Email = student.getStEmail();
			String gender = student.getGender();
			
			printWriter.write(
					"<html><body><div style='display:flex; align-items:center; justify-content:center;position:relative;top:160px;z-index:2;'><div style='color:green;'>Login-Successfull</div></div></body></html>");
			printWriter.write(
					"<html><body><div style='display:flex; align-items:center; justify-content:center;position:relative;top:220px;right:10px;z-index:2;'><div style='color:brown; font-size:20px;'>Student-Id: "+stId+"  ,  Name: "+stName+"  ,  Email: "+Email+"  ,  Gender: "+gender+"</div></div></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.include(req, resp);
		} else {
			printWriter.write("<html><body><div style='display:flex; align-items:center; justify-content:center;position:relative;top:140px;z-index:2;'><div style='color:red;'>Invalid UserName or Password</div></div></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}

	}

}
