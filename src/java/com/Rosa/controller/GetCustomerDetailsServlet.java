package com.Rosa.controller;

import com.Rosa.bean.Customer;
import com.Rosa.service.OrderService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetCustomerDetailsServlet extends HttpServlet {
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
            RequestDispatcher dispatcher;
            int order_id = Integer.parseInt(request.getParameter("order_id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            int pin = Integer.parseInt(request.getParameter("pin"));
            Long mobile = Long.parseLong(request.getParameter("mobile"));
            Customer c;
            c = new Customer(name, email, address, pin, mobile);
            int result = OrderService.addC_id(c, order_id);
            if(result != 0)
            {
                request.setAttribute("order_id", result);
                dispatcher = request.getRequestDispatcher("payment.jsp");
                dispatcher.forward(request, response); 
            }
            else
            {
                request.setAttribute("message", "Customer not added");
                dispatcher = request.getRequestDispatcher("CustomerDetails.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
    @Override
    public void destroy()
    {
    }
}
