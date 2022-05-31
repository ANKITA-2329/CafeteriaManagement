package com.Rosa.controller;

import com.Rosa.bean.Order;
import com.Rosa.bean.Payment;
import com.Rosa.service.OrderService;
import com.Rosa.service.PaymentService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class OrderServlet extends HttpServlet {

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
        List <Order> order = OrderService.getAllOrderDetails();
        System.out.println(order);
        for(Order o : order)
        {
            System.out.println(o.getOrder_id() + " " + o.getOrder_status());
        }
        if(order != null)
        {
            request.setAttribute("order", order);
            RequestDispatcher dispatcher = request.getRequestDispatcher("demoStatus.jsp");
            dispatcher.forward(request, response);
        }
        }
    }

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
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        String status = request.getParameter("r1");
        
        System.out.println(order_id + " " +status);
        int result = OrderService.updateStatus(order_id, status);
        if(result != 0)
        {
            List <Order> order = OrderService.getAllOrderDetails();
            request.setAttribute("message", "Order Updated!");
            request.setAttribute("order", order);
            RequestDispatcher dispatcher = request.getRequestDispatcher("demoStatus.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            List <Order> order = OrderService.getAllOrderDetails();
            request.setAttribute("order", order);
            request.setAttribute("message", "Order not Updated!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("demoStatus.jsp");
            dispatcher.forward(request, response);
        }
        }
    }

    @Override
    public void destroy()
    {
        
    }
}
