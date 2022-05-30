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
import java.util.List;

public class GetMenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String useremail = (String) request.getSession().getAttribute("useremail");	
	if(useremail == null) {
            System.out.println("Session Expired....please login");
            request.getRequestDispatcher("SessionExpired.jsp").forward(request, response);
	}  
        else
        {
            List <Item> coffee = ItemService.getItemCoffee();
            List <Item> burger = ItemService.getItemBurger();
            List <Item> sandwich = ItemService.getItemSandwich();
            request.setAttribute("coffee", coffee);
            request.setAttribute("burger", burger);
            request.setAttribute("sandwich", sandwich);
            RequestDispatcher dispatcher = request.getRequestDispatcher("menu1.jsp");
            dispatcher.forward(request, response);
        }
    }

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
            String qty[] = request.getParameterValues("qty");
            String item_name [] = request.getParameterValues("iname");
            String item_price [] = request.getParameterValues("iprice");
            List <Item> selected_Item = ItemService.getSelectedItem(qty, item_name, item_price);
            if(!selected_Item.equals(null))
            {
                int subTotal = 0; 
                float gst = 0, cgst =0;
                for(Item i : selected_Item)
                {
                    subTotal += i.getTotal();
                }
                gst = cgst = (float) ((subTotal * 5.0)/100);
                float grandTotal = subTotal+gst+cgst;
                request.setAttribute("subTotal", subTotal);
                request.setAttribute("gst", gst);
                request.setAttribute("cgst", cgst);
                request.setAttribute("grandTotal", grandTotal);
                request.setAttribute("selected_Item", selected_Item);
                RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
                dispatcher.forward(request, response);
            }
            else
            {
                request.setAttribute("message", "Menu not selected.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("menu1.jsp");
                dispatcher.forward(request, response);
            }
        }
        
    }

    @Override
    public void destroy(){
        
    }
}
