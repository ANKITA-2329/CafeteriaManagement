package com.Rosa.controller;

import com.Rosa.bean.Customer;
import com.Rosa.bean.Employee;
import com.Rosa.service.CustomerService;
import com.Rosa.service.EmployeeService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomerProfileController extends HttpServlet {
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
                Customer e = new Customer();
                e.setC_emailid(useremail);
                String name = request.getParameter("cname");
                String address = request.getParameter("address");
                int pin = Integer.parseInt(request.getParameter("pin"));
                Long mobile = Long.parseLong(request.getParameter("mobile"));
                e.setC_name(name);
                e.setAddress(address);
                e.setPin(pin);
                e.setMobile_no(mobile);
                int res = CustomerService.updateEmployeeProfile(e);
                if(res == 1)
                {
                    request.setAttribute("message", "Record updated successfully.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("customerPage.jsp");
                    dispatcher.forward(request, response);
                }
                else
                {
                    request.setAttribute("message", "Record not updated successfully.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerProfile.jsp");
                    dispatcher.forward(request, response);
                }
        }
    }
}
