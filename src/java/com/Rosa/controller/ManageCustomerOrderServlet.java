package com.Rosa.controller;

import com.Rosa.bean.Customer;
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

public class ManageCustomerOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String useremail = (String) request.getSession().getAttribute("useremail");	
//	if(useremail == null) {
//            System.out.println("Session Expired....please login");
//            request.getRequestDispatcher("SessionExpired.jsp").forward(request, response);
//	}  
//        else
//        {
//            Customer c = new Customer();
//            c.setC_emailid(useremail);
//            Order order = new Order();
//            
//            RequestDispatcher dispatcher;
//        }
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
        RequestDispatcher dispatcher;
        int payment_id = Integer.parseInt(request.getParameter("payid"));
        //int order_id = Integer.parseInt(request.getParameter("orderid"));
        String action = request.getParameter("action");
        String order_status = request.getParameter("r1");
        int result = 0;
        System.out.println(payment_id + " " +action+ " " +order_status);
        if(action.equals("Delete"))
        {
            result = PaymentService.deleteOrder(payment_id);
        }
        if(result == 1 && action.equals("Delete") && !order_status.equals("Completed") || !order_status.equals("Prepared"))
        {
            request.setAttribute("message", "Order deleted successfully");
            dispatcher = request.getRequestDispatcher("CustOrderStatus.jsp");
            dispatcher.forward(request, response);
        }

        else
        {
            request.setAttribute("message", "Order completed or prepared so no deletion of order");
            dispatcher = request.getRequestDispatcher("CustOrderStatus.jsp");
            dispatcher.forward(request, response);
        }
        }
    }
    @Override
    public void destroy()
    {
        
    }
}