package com.Rosa.controller;

import com.Rosa.service.OrderService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdminMainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("com.Rosa.controller.AdminMainController.doGet()");
        String useremail = (String) request.getSession().getAttribute("useremail");	
	if(useremail == null) {
            System.out.println("Session Expired....please login");
            request.getRequestDispatcher("SessionExpired.jsp").forward(request, response);
	}
        else
        {
            String date = request.getParameter("date");
            List orderTotal = new ArrayList();
            Map<String, Object> reportMap = OrderService.getOrderTotal(date);
            System.out.println(reportMap);
//            orderTotal = OrderService.getOrderTotal(date);
            System.out.println(orderTotal);
//            for(int i = 0 ; orderTotal.size() > i ; i++)
//            {
//                System.out.println(orderTotal.get(i));
//            }
            //int deleteTotal =OrderService.getOrderDeleteTotal(d1);
            //int confirmTotal = OrderService.getOrderConfirmTotal(d2);
            System.out.println(orderTotal);
            if(reportMap != null)
            {
                request.setAttribute("orderTotal", orderTotal);
                request.setAttribute("reportMap", reportMap);
                request.setAttribute("date", date);
                RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage.jsp");
                dispatcher.forward(request, response);
            }
            else
            {
                request.setAttribute("message", "No Record available");
                RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
    
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("com.Rosa.controller.AdminMainController.doPost()");
        String useremail = (String) request.getSession().getAttribute("useremail");	
	if(useremail == null) {
            System.out.println("Session Expired....please login");
            request.getRequestDispatcher("SessionExpired.jsp").forward(request, response);
	}
        
            else
            {
                request.setAttribute("message", "Login Successfully");
                RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage.jsp");
                dispatcher.forward(request, response);
            }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public void destroy() {
       
    }// </editor-fold>

}
