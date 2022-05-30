/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.Rosa.controller;

import com.Rosa.bean.Employee;
import com.Rosa.service.EmployeeService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class UpdateEmployeeProfileController extends HttpServlet {
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
                Employee e = new Employee();
                e.setEmp_emailid(useremail);
                String name = request.getParameter("ename");
                Long mobile = Long.parseLong(request.getParameter("mobile"));
                e.setEmp_name(name);
                e.setMobile_no(mobile);
                int res = EmployeeService.updateEmployeeProfile(e);
                if(res == 1)
                {
                    request.setAttribute("message", "Record updated successfully.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("empPage.jsp");
                    dispatcher.forward(request, response);
                }
                else
                {
                    request.setAttribute("message", "Record not updated successfully.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("updateProfileDetailsEmp.jsp");
                    dispatcher.forward(request, response);
                }
        }
    }
}
