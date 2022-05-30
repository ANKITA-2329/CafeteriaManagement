/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.Rosa.controller;

import com.Rosa.service.OrderService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

public class YearlyDetailsController extends HttpServlet {

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
        String year = request.getParameter("year");
        System.out.println(year);
        Map<String, Object> reportMap = OrderService.getOrderTotalYear(year);
        System.out.println(reportMap);
        if(reportMap != null)
            {
                request.setAttribute("reportMap", reportMap);
                request.setAttribute("year", year);
                RequestDispatcher dispatcher = request.getRequestDispatcher("YearlyDetails.jsp");
                dispatcher.forward(request, response);
            }
            else
            {
                request.setAttribute("message", "No Record available");
                RequestDispatcher dispatcher = request.getRequestDispatcher("YearlyDetails.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("com.Rosa.controller.AdminMainController.doGet()");
        String useremail = (String) request.getSession().getAttribute("useremail");	
	if(useremail == null) {
            System.out.println("Session Expired....please login");
            request.getRequestDispatcher("SessionExpired.jsp").forward(request, response);
	}
        else
        {
        RequestDispatcher dispatcher = request.getRequestDispatcher("YearlyDetails.jsp");
        dispatcher.forward(request, response);
        }
    }

    @Override
    public void destroy()
    {
        
    }

}
