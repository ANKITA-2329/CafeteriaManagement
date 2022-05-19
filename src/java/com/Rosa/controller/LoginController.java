package com.Rosa.controller;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html");  
        String user_email = request.getParameter("email");
        String password = request.getParameter("password");
        //PrintWriter out = response.getWriter();
        //out.write(user_email+ " "+password);
        
    }
    
    @Override
    public void destroy()
    {
        
    }
}
