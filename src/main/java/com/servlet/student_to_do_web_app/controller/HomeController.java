package com.servlet.student_to_do_web_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.student_to_do_web_app.dto.Student;

@WebServlet(value = "/home")
public class HomeController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Check if the user is authenticated
        HttpSession httpSession = req.getSession();
        Student authenticatedUser = (Student) httpSession.getAttribute("userSession");
        
        if (authenticatedUser != null) {
            // If the user is authenticated, forward to the home page
            req.setAttribute("message2", authenticatedUser);
            RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
            dispatcher.forward(req, resp);
        } else {
            // If the user is not authenticated, redirect to the login page
            req.setAttribute("message3", "Please login again your session is out");
            RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
