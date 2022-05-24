package com.Rosa.controller;

import com.Rosa.bean.Item;
import com.Rosa.service.ItemService;
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

public class UpdateItemServlet extends HttpServlet {

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
            Item item = new Item();
            String item_name = request.getParameter("iname");
            int price = Integer.parseInt(request.getParameter("iprice"));
            String status = request.getParameter("istatus");
            item.setItem_name(item_name);
            item.setPrice(price);
            item.setStatus(status);
            int result = ItemService.updateItem(item);
            if(result == 1)
            {
                request.setAttribute("message", "Record updated successfully.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("updateItem.jsp");
                dispatcher.forward(request, response);
            }
            else
            {
                request.setAttribute("message", "Record was not updated.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("updateItem.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

}
