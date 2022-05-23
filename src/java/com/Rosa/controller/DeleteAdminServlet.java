package com.Rosa.controller;

import com.Rosa.bean.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import com.Rosa.service.AdminService;
import jakarta.servlet.RequestDispatcher;

public class DeleteAdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher;
        int admin_id = Integer.parseInt(request.getParameter("aid"));
        Admin admin = new Admin();
        admin.setAdmin_id(admin_id);
        int result = AdminService.deleteAdmin(admin);
        if(result == 1)
        {
            request.setAttribute("message", "Record deleted successfully.");
            dispatcher = request.getRequestDispatcher("deleteAdmin.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            request.setAttribute("message", "Record deletion was unsuccessfully.");
            dispatcher = request.getRequestDispatcher("deleteAdmin.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public void destroy()
    {
        
    }
}
