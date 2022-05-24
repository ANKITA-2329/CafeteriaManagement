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


public class UpdateAdminController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String useremail = (String) request.getSession().getAttribute("useremail");	
	if(useremail == null) {
            System.out.println("Session Expired....please login");
            request.getRequestDispatcher("SessionExpired.jsp").forward(request, response);
	}
        else
        {
            Admin admin = new Admin();
            admin.setAdmin_emailid(useremail);
            String name = request.getParameter("aname");
            Long mobile = Long.parseLong(request.getParameter("mobile"));
            admin.setAdmin_name(name);
            admin.setMobile_no(mobile);
            int result = AdminService.updateAdmin(admin);
            if(result == 1)
            {
                request.setAttribute("message", "Record updated successfully.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("./SearchAdminController");
                dispatcher.forward(request, response);
            }
            else
            {
                request.setAttribute("message", "Record was not updated.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("updateAdmin.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

}
