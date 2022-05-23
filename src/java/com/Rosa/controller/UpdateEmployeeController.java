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


public class UpdateEmployeeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Employee emp = new Employee();
        int emp_id = Integer.parseInt(request.getParameter("eid"));
        String workplace = request.getParameter("workplace");
        emp.setEmp_id(emp_id);
        emp.setWorkplace(workplace);
        int result = EmployeeService.updateEmployee(emp);
        if(result == 1)
        {
            request.setAttribute("message", "Record updated successfully.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateEmployee.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            request.setAttribute("message", "Record was not updated.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateEmployee.jsp");
            dispatcher.forward(request, response);
        }
        
    }

}
