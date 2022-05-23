package com.Rosa.controller;

import com.Rosa.bean.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import com.Rosa.service.EmployeeService;
import jakarta.servlet.RequestDispatcher;

public class DeleteEmployeeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String useremail = (String) request.getSession(false).getAttribute("useremail");	
	if(useremail == null) {
            System.out.println("Session Expired....please login");
            request.getRequestDispatcher("SessionExpired.jsp").forward(request, response);
	}
        else
        {
            RequestDispatcher dispatcher;
            int emp_id = Integer.parseInt(request.getParameter("eid"));
            Employee emp = new Employee();
            emp.setEmp_id(emp_id);
            int result = EmployeeService.deleteEmployee(emp);
            if(result == 1)
            {
                request.setAttribute("message", "Record deleted successfully.");
                dispatcher = request.getRequestDispatcher("deleteEmployee.jsp");
                dispatcher.forward(request, response);
            }
            else
            {
                request.setAttribute("message", "Record deletion was unsuccessfully.");
                dispatcher = request.getRequestDispatcher("deleteEmployee.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    public void destroy()
    {
        
    }
}
