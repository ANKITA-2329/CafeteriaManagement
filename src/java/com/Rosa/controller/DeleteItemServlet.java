package com.Rosa.controller;

import com.Rosa.bean.Item;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import com.Rosa.service.ItemService;
import jakarta.servlet.RequestDispatcher;

public class DeleteItemServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String useremail = (String) request.getSession(false).getAttribute("useremail");	
	if(useremail == null) {
            System.out.println("Session Expired....please login");
            request.getRequestDispatcher("SessionExpired.jsp").forward(request, response);
	}
        else
        {
            RequestDispatcher dispatcher;
            String item_name = request.getParameter("iname");
            Item item = new Item();
            item.setItem_name(item_name);
            int result = ItemService.deleteItem(item);
            if(result == 1)
            {
                request.setAttribute("message", "Record deleted successfully.");
                dispatcher = request.getRequestDispatcher("deleteItem.jsp");
                dispatcher.forward(request, response);
            }
            else
            {
                request.setAttribute("message", "Record deletion was unsuccessfully.");
                dispatcher = request.getRequestDispatcher("deleteItem.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    public void destroy()
    {
        
    }
}
