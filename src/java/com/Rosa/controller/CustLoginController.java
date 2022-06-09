package com.Rosa.controller;

import com.Rosa.service.LoginService;
import jakarta.servlet.RequestDispatcher;
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CustLoginController")
public class CustLoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher;
        String user_email = request.getParameter("email");
        String password = request.getParameter("password");
        //String type = request.getParameter("r1");
        Boolean result = LoginService.verifyCredentials(user_email, password);
//        PrintWriter out = response.getWriter();
//        out.println(result);
        if(result)
        {
            HttpSession session = request.getSession();
            session.setAttribute("useremail", user_email);
            request.setAttribute("message", "Login successfully");
            dispatcher = request.getRequestDispatcher("customerPage.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            request.setAttribute("message", "Login unsuccessfully");
            dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
        
    }
    
    @Override
    public void destroy()
    {
        
    }
}
