package com.servlet.student_to_do_web_app.controller;

import java.awt.Color;
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

@WebServlet(value = "/signupStudent")
public class SignupController extends HttpServlet{
	
	StudentService studentService = new StudentService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int stId = Integer.parseInt(req.getParameter("stId"));
		
		String stName = req.getParameter("stName");
		
		String stEmail = req.getParameter("stEmail");
		
		String password = req.getParameter("password");
		
		String gender = req.getParameter("gender");
		
		Student student = new Student(stId, stName, stEmail, password, gender);
		Student student2 = studentService.saveStudentService(student);
		
		PrintWriter printWriter = resp.getWriter();
		
		if(student2 != null) {
			printWriter.write("<html><body><h1 style='color:green; background-color:white;display:flex; align-items:center;justify-content:center;'>Signup-Successfull</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}else {
			printWriter.write("<html><body><h1 style='color:red;background-color:white;display:flex; align-items:center;justify-content:center;'>Can not signup(Id already used)</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("signup.jsp");
			dispatcher.include(req, resp);
		}
		
		
	}
	
	
}
