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

public class DeleteItemController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Item item = new Item();
        String item_name = request.getParameter("iname");
        System.out.println(item_name);
        item.setItem_name(item_name);
        try {
            List <Item> result = ItemService.searchItem(item);
            request.setAttribute("result", result);
            System.out.println(result);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("deleteItem.jsp");
        dispatcher.forward(request, response);
    }

}
