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

public class ManageOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher;
        Order order [];
        Payment payment [];
        order = OrderService.getAllOrderDetails();
        payment = PaymentService.getAllPaymentDetails();
        System.out.println(order);
        System.out.println(payment);
        dispatcher = request.getRequestDispatcher("orderStatus.jsp");
        dispatcher.forward(request, response);
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
        else if(action.equals("Update"))
        {
            result = PaymentService.updateOrder(payment_id, order_status);
        }
        if(result == 1 && action.equals("Delete"))
        {
            request.setAttribute("message", "Order deleted successfully");
            dispatcher = request.getRequestDispatcher("orderStatus.jsp");
            dispatcher.forward(request, response);
        }
        if(result != 0 && action.equals("Update") && !order_status.equals("Completed"))
        {
            System.out.println(result);
            Payment pay = PaymentService.getPaymentDetails(payment_id);
            Order order = OrderService.getOrderDetails(result);
            System.out.println(pay + " " + order);
            request.setAttribute("pay", pay);
            request.setAttribute("order", order);
            request.setAttribute("message", "Order updated successfully");
            request.setAttribute("payment_id", payment_id);
            dispatcher = request.getRequestDispatcher("orderStatus.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            request.setAttribute("message", "Order updated to completed so no whether updation");
            dispatcher = request.getRequestDispatcher("orderStatus.jsp");
            dispatcher.forward(request, response);
        }
        }
    }
    @Override
    public void destroy()
    {
        
    }
}