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

public class SearchItemController extends HttpServlet {

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
            String source = request.getParameter("action");
            String form = request.getParameter("update");
            Item item = new Item();
            String item_name = request.getParameter("iname");
            item.setItem_name(item_name);
            try {
                List <Item> result = ItemService.searchItem(item);
                request.setAttribute("result", result);
            } catch (SQLException ex) {
                Logger.getLogger(SearchItemController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(source.equals("delete"))
            {
                //request.setAttribute("message", "Record found successfully.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("deleteItem.jsp");
                dispatcher.forward(request, response);
            }
            if(source.equals("update"))
            {
                //request.setAttribute("message", "Record found successfully.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("updateItem.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

}
