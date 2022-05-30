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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchEmployeeController extends HttpServlet {

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
            String source = request.getParameter("action");
            Employee emp = new Employee();
            int emp_id = Integer.parseInt(request.getParameter("eid"));
            emp.setEmp_id(emp_id);
            try {
                List <Employee> result = EmployeeService.searchEmployee(emp);
                request.setAttribute("result", result);
            } catch (SQLException ex) {
                Logger.getLogger(SearchEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(source.equals("delete"))
            {
                //request.setAttribute("message", "Record found successfully.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("deleteEmployee.jsp");
                dispatcher.forward(request, response);
            }


            if(source.equals("update"))
            {
                //request.setAttribute("message", "Record found successfully.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("updateEmployee.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String useremail = (String) request.getSession().getAttribute("useremail");	
	if(useremail == null) {
            System.out.println("Session Expired....please login");
            request.getRequestDispatcher("SessionExpired.jsp").forward(request, response);
	}
        else
        {
            
            Employee emp = new Employee();
            emp.setEmp_emailid(useremail);
        try{   
            
                List <Employee> e = EmployeeService.searchEmployeeEmail(emp);
                request.setAttribute("result", e);
            }
            catch (SQLException ex) {
                Logger.getLogger(SearchAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
                //request.setAttribute("message", "Record found successfully.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("updateProfileDetailsEmp.jsp");
                dispatcher.forward(request, response);
        }
    }

}
