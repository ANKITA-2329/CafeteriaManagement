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

public class CustomerPaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher;
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        System.out.println(order_id);
        String method = request.getParameter("r1");
        System.out.println(order_id);
        Payment payment = new Payment();
        payment.setOrder_id(order_id);
        payment.setPayment_mode(method);
        int result = PaymentService.addPayment(payment);
        System.out.println(result);
        if(result != 0)
        {
            Payment pay = PaymentService.getPaymentDetails(result);
            System.out.println(pay);
            Order order = OrderService.getOrderDetails(order_id);
            System.out.println(order);
            request.setAttribute("pay", pay);
            request.setAttribute("order", order);
            request.setAttribute("payment_id", result);
            dispatcher = request.getRequestDispatcher("CustOrderStatus.jsp");
            dispatcher.forward(request, response);
        }
        
        
    }

    @Override
    public void destroy()
    {
        
    }
}
