package com.Rosa.controller;

import com.Rosa.bean.Admin;
import com.Rosa.bean.Customer;
import com.Rosa.bean.Employee;
import com.Rosa.service.AdminService;
import com.Rosa.service.CustomerService;
import com.Rosa.service.EmployeeService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ForgetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String cpass = request.getParameter("cpass");
        if(pass.equals(cpass))
        {
            Customer cust = new Customer();
            cust.setC_password(pass);
            cust.setC_emailid(email);
            int result = CustomerService.changePassword(cust);
                if(result == 1)
                {
                    request.setAttribute("message", "Password changed.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                }
                else
                {
                    request.setAttribute("message", "Password not changed.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("UserEmailId.jsp");
                    dispatcher.forward(request, response);
                }
        }
    }
    
    @Override
    public void destroy()
    {
        
    }
}
