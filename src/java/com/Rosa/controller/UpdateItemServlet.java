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
        Item item = new Item();
        String item_name = request.getParameter("iname");
        int price = Integer.parseInt(request.getParameter("iprice"));
        String status = request.getParameter("istatus");
        System.out.println(price + " " +status);
        request.setAttribute("message", "Record found successfully.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateItem.jsp");
        dispatcher.forward(request, response);
        
    }

}
