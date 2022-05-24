package com.Rosa.controller;

import com.Rosa.bean.Admin;
import com.Rosa.service.AdminService;
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

public class SearchAdminController extends HttpServlet {

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
            String source = request.getParameter("action");
            Admin admin = new Admin();
            int admin_id = Integer.parseInt(request.getParameter("aid"));
            admin.setAdmin_id(admin_id);
            try {
                
                List <Admin> result = AdminService.searchAdmin(admin);
                request.setAttribute("result", result);
                
            } catch (SQLException ex) {
                Logger.getLogger(SearchAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(source.equals("delete"))
            {
             //request.setAttribute("message", "Record found successfully.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("deleteAdmin.jsp");
                dispatcher.forward(request, response);
            }
            if(source.equals("update"))
            {
                //request.setAttribute("message", "Record found successfully.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("updateAdmin.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
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
            
            Admin admin = new Admin();
            admin.setAdmin_emailid(useremail);
        try{   
            
                List <Admin> a = AdminService.searchAdminEmail(admin);
                request.setAttribute("result", a);
            }
            catch (SQLException ex) {
                Logger.getLogger(SearchAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
                //request.setAttribute("message", "Record found successfully.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("updateAdmin.jsp");
                dispatcher.forward(request, response);
        }
    }

}
