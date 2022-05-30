package com.Rosa.controller;

import com.Rosa.bean.Admin;
import com.Rosa.bean.Employee;
import com.Rosa.service.AdminService;
import com.Rosa.service.EmployeeService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ForgetEAPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String type = request.getParameter("r1");
        String pass = request.getParameter("pass");
        String cpass = request.getParameter("cpass");
        if(type.equals("admin") && pass.equals(cpass))
        {
            Admin admin = new Admin();
            admin.setA_password(pass);
            admin.setAdmin_emailid(email);
            int result = AdminService.changePassword(admin);
                if(result == 1)
                {
                    request.setAttribute("message", "Password changed.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("adminEmpLogin.jsp");
                    dispatcher.forward(request, response);
                }
                else
                {
                    request.setAttribute("message", "Password not changed.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("AdminEmpEmailId.jsp");
                    dispatcher.forward(request, response);
                }
        }
        if(type.equals("employee") && pass.equals(cpass))
        {
            Employee emp = new Employee();
            emp.setPassword(pass);
            emp.setEmp_emailid(email);
            int result = EmployeeService.changePassword(emp);
            if(result == 1)
            {
                request.setAttribute("message", "Password changed.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("adminEmpLogin.jsp");
                dispatcher.forward(request, response);
            }
            else
                {
                    request.setAttribute("message", "Password not changed.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("AdminEmpEmailId.jsp");
                    dispatcher.forward(request, response);
                }
        }
    }
    
    @Override
    public void destroy()
    {
        
    }
}
