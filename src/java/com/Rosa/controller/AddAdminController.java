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

public class AddAdminController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String useremail = (String) request.getSession(false).getAttribute("useremail");
        System.out.println(useremail);
	if(useremail == null) {
            System.out.println("Session Expired....please login");
            request.getRequestDispatcher("SessionExpired.jsp").forward(request, response);
	}
        else
        {
            Admin admin = new Admin();
            RequestDispatcher dispatcher;
            int id = Integer.parseInt(request.getParameter("aid"));
            String name = request.getParameter("aname");
            String email = request.getParameter("aemail");
            Long mobile = Long.parseLong(request.getParameter("mobile"));
            String password = request.getParameter("apassword");
            admin.setAdmin_id(id);
            admin.setAdmin_name(name);
            admin.setAdmin_emailid(email);
            admin.setMobile_no(mobile);
            admin.setA_password(password);
            int result = AdminService.addAdmin(admin);
            if(result == 1)
            {
                request.setAttribute("message", "Admin Added Successfully");
                dispatcher = request.getRequestDispatcher("addAdmin.jsp");
                dispatcher.forward(request, response); 
            }
            else
            {
                request.setAttribute("message", "Admin was not added. Maybe already exist");
                dispatcher = request.getRequestDispatcher("addAdmin.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
    public void destroy()
    {
        
    }
}
