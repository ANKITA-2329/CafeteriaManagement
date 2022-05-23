package com.Rosa.controller;

import com.Rosa.service.EmpAdminService;
import com.Rosa.service.LoginService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EmpAdminController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String type = request.getParameter("r1");
        RequestDispatcher dispatcher;
        Boolean result = EmpAdminService.verifyCredentials(email, password, type);
        if(result && type.equals("admin"))
        {
            HttpSession session = request.getSession();
            session.setAttribute("useremail", email);
            dispatcher = request.getRequestDispatcher("adminPage.jsp");
            dispatcher.forward(request, response);
        }
        
        else if(result && type.equals("employee"))
        {
            HttpSession session = request.getSession();
            session.setAttribute("useremail", email);
            dispatcher = request.getRequestDispatcher("empPage.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            dispatcher = request.getRequestDispatcher("adminEmpLogin.jsp");
            dispatcher.forward(request, response);
        }
    }
    public void destroy()
    {
        
    }
}
