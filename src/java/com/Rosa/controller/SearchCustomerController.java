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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchCustomerController extends HttpServlet {

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
            
            Customer cust = new Customer();
            cust.setC_emailid(useremail);
        try{   
            
                List <Customer> c = CustomerService.searchCustomerEmail(cust);
                request.setAttribute("result", c);
            }
            catch (SQLException ex) {
                Logger.getLogger(SearchAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
                //request.setAttribute("message", "Record found successfully.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerProfile.jsp");
                dispatcher.forward(request, response);
        }
    }

}
