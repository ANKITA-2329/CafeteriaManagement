package com.Rosa.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CustomerLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.removeAttribute("useremail");
			session.invalidate();
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.removeAttribute("useremail");
			session.invalidate();
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}