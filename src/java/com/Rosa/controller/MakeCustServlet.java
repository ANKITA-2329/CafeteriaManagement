/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.Rosa.controller;

import com.Rosa.bean.Order;
import com.Rosa.service.OrderService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class MakeCustServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String useremail = (String) request.getSession().getAttribute("useremail");	
	if(useremail == null) {
            System.out.println("Session Expired....please login");
            request.getRequestDispatcher("SessionExpired.jsp").forward(request, response);
	}
        else
        {
            String item_name [] = request.getParameterValues("iname");
            String qty [] = request.getParameterValues("qty");
            int stotal = Integer.parseInt(request.getParameter("stotal"));
            double gst = Double.parseDouble(request.getParameter("gst"));
            double cgst = Double.parseDouble(request.getParameter("cgst"));
            double gtotal = Double.parseDouble(request.getParameter("gtotal"));
            String order_type = request.getParameter("r1");
            System.out.println(order_type);
            Order order = new Order();
            order.setCgst(cgst);
            order.setGst(gst);
            order.setGrandTotal(gtotal);
            order.setSubTotal(stotal);
            order.setOrder_type(order_type);
            int order_id = OrderService.AddCustomerOrder(order, item_name, qty, useremail);
            if(order_id != 0)
            {
                request.setAttribute("order_id", order_id);
                RequestDispatcher dispatcher = request.getRequestDispatcher("customerPayment.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
