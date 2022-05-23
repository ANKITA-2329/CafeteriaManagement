package com.Rosa.controller;

import com.Rosa.bean.Item;
import static com.Rosa.service.ItemService.addItem;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddItemController extends HttpServlet {

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
            Item item = new Item();
            RequestDispatcher dispatcher;
            String item_name = request.getParameter("iname");
            String item_category = request.getParameter("icategory");
            String item_description = request.getParameter("idesc");
            int price = Integer.parseInt(request.getParameter("iprice"));
            String status = request.getParameter("i1");
            item.setItem_name(item_name);
            item.setItem_category(item_category);
            item.setItem_description(item_description);
            item.setPrice(price);
            item.setStatus(status);
            int result = addItem(item);
            if(result == 1)
            {
                request.setAttribute("message", "Item Added Successfully");
                dispatcher = request.getRequestDispatcher("addItem.jsp");
                dispatcher.forward(request, response); 
            }
            else
            {
                request.setAttribute("message", "Item was not added. Maybe already exist");
                dispatcher = request.getRequestDispatcher("addItem.jsp");
                dispatcher.forward(request, response);
            }   
        }
    }
    public void destroy()
    {
        
    }
}
