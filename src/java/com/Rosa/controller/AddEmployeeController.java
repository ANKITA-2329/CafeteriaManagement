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

public class AddEmployeeController extends HttpServlet {

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
            Employee emp = new Employee();
            RequestDispatcher dispatcher;
            int id = Integer.parseInt(request.getParameter("eid"));
            String name = request.getParameter("ename");
            String email = request.getParameter("eemail");
            String workplace = request.getParameter("workplace");
            Long mobile = Long.parseLong(request.getParameter("mobile"));
            String password = request.getParameter("epassword");
            emp.setEmp_id(id);
            emp.setEmp_name(name);
            emp.setEmp_emailid(email);
            emp.setWorkplace(workplace);
            emp.setMobile_no(mobile);
            emp.setPassword(password);
            int result = EmployeeService.addEmployee(emp);
            if(result == 1)
            {
                request.setAttribute("message", "Employee Added Successfully");
                dispatcher = request.getRequestDispatcher("addEmployee.jsp");
                dispatcher.forward(request, response); 
            }
            else
            {
                request.setAttribute("message", "Employee was not added. Maybe already exist");
                dispatcher = request.getRequestDispatcher("addEmployee.jsp");
                dispatcher.forward(request, response);
            }   
        }
    }
    public void destroy()
    {
        
    }
}
