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

public class EmpChangePassword extends HttpServlet {
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
            Employee emp = new Employee();
            emp.setPassword(password);
            emp.setEmp_emailid(useremail);
            if(password.equals(cpassword))
            {
                
                int result = EmployeeService.changePassword(emp);
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
