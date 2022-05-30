package com.Rosa.controller;

import com.Rosa.bean.Admin;
import com.Rosa.service.AdminService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class changePasswordController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String useremail = (String) request.getSession().getAttribute("useremail");	
	if(useremail == null) {
            System.out.println("Session Expired....please login");
            request.getRequestDispatcher("SessionExpired.jsp").forward(request, response);
	}
        else
        {
            String password = request.getParameter("password");
            String cpassword = request.getParameter("cpassword");
            Admin admin = new Admin();
            admin.setA_password(password);
            admin.setAdmin_emailid(useremail);
            if(password.equals(cpassword))
            {
                
                int result = AdminService.changePassword(admin);
                if(result == 1)
                {
                    request.setAttribute("message", "Password changed.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("LogoutServlet");
                    dispatcher.forward(request, response);
                }
            }
            else
            {
                request.setAttribute("message", "Password not changed.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("changePassword.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

}
