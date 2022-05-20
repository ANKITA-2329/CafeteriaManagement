package com.Rosa.controller;

import com.Rosa.bean.Customer;
import com.Rosa.service.CustRegisterService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class CustomerRegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int pin = Integer.parseInt(request.getParameter("pin"));
        Long mobile = Long.parseLong(request.getParameter("mobile"));
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        System.out.println(name + " " + email+ " " + address + " " + pin +" " + mobile + " " + password + " " +cpassword);
        Customer c;
        c = new Customer(name, email, address, pin, mobile, password);
        if(password.equals(cpassword))
        {
            int result = CustRegisterService.addCustomer(c);
            if(result == 1)
            {
                dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response); 
            }
        }
        else
        {
            dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);
        }
        
    }
    @Override
    public void destroy()
    {
    }

}
