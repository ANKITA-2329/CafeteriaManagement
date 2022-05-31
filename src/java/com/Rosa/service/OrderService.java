package com.Rosa.service;

import com.Rosa.bean.Customer;
import com.Rosa.bean.Order;
import com.Rosa.util.DBConnectionUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderService {
    static Connection con = DBConnectionUtil.getConnection();
    static PreparedStatement prepare = null;
    static ResultSet rs = null, rs1 = null;
    static Statement stmt;
    public static int AddOrder(Order order, String item_name[], String qty[], String useremail)
    {
        long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
        System.out.println(date);  
        order.setDate(date);
        StringBuffer sb = new StringBuffer();
        int result, emp_id = 0;
        for(int i = 0 ; i < qty.length ; i++)
        {
            item_name[i] = item_name[i] + " " +qty[i];
            sb.append(item_name[i]);
        }
        String order_details = sb.toString();
        order.setOrder_details(order_details);
        try
        {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select emp_id from employee where emp_emailid = '"+useremail+"'");
            while(rs.next())
            {
                order.setEmp_id(rs.getInt(1));
            }
            prepare = con.prepareStatement("Insert into orders (order_details, sub_amount, gst, cgst, total_amount, date, emp_id, order_type) values(?, ?, ?, ?, ?, ?, ?, ?)");
            prepare.setString(1, order.getOrder_details());
            prepare.setInt(2, order.getSubTotal());
            prepare.setDouble(3, order.getGst());
            prepare.setDouble(4, order.getCgst());
            prepare.setDouble(5, order.getGrandTotal());
            prepare.setDate(6, order.getDate());
            prepare.setInt(7, order.getEmp_id());
            prepare.setString(8, order.getOrder_type());
            result = prepare.executeUpdate();
            if(result == 1)
            {
                rs = stmt.executeQuery("Select order_id from orders where emp_id = '"+order.getEmp_id()+"'");
                while(rs.next())
                {
                    emp_id = rs.getInt(1);
                }
            }
            return emp_id;
        }
        catch(SQLException e)
        {
            e.printStackTrace();        
        }
        return emp_id;
    }
    public static int updateC_id(Customer c, int order_id)
    {
        int result = 0;
        try
        {
            int c_id = CustRegisterService.getC_id(c.getC_emailid());
            if(c_id != 0)
            {
                prepare = con.prepareStatement("Update orders set c_id = '"+c_id+"' where order_id = '"+order_id+"'");
                result = prepare.executeUpdate();
            }
            return result;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
    public static int addC_id(Customer c, int order_id)
    {
        int result = 0;
            result = updateC_id(c, order_id);
            if(result == 1)
            {
                return order_id;
            }
            else
            {
                c.setC_password(c.getC_name().trim());
                result = CustRegisterService.addCustomer(c);
                result = updateC_id(c, order_id);
                if(result == 1)
                {
                    return order_id;
                }
                else
                {
                    return result;
                }
            }
    }
    public static Order getOrderDetails(int order_id)
    {
        Order order = null;
        try
        {
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select order_details, order_type, order_status, date from orders where order_id = '"+order_id+"'");
            while(rs.next())
            {
                order = new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
            }
            return order;
        }
        catch(SQLException e)
        {
            e.printStackTrace();        
        }
        return order;
    }
    
    public static Map<String, Object> getOrderTotal(String date)
    {
        int total = 0;
        double t=0.0;
        
        Map<String, Object> reportMap = new LinkedHashMap<>();
        
        List ordertotal = new ArrayList();
        //Date d = Date.valueOf(date);
        System.out.println(date);
        try
        {
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select count(*) from orders where date = '"+date+"'");
//            System.out.println(rs.next());
            while(rs.next())
            {
                total = rs.getInt(1);
                ordertotal.add(total);
                reportMap.put("Total orders: ", total);
            }
            rs = stmt.executeQuery("SELECT count(*) FROM orders where date = '"+date+"' and order_status = 'delete'");
            while(rs.next())
            {
                total = rs.getInt(1);
                ordertotal.add(total);
                reportMap.put("Total deleted orders: ", total);
            }
            rs = stmt.executeQuery("Select count(*) from orders where date = '"+date+"' and order_status != 'delete'");
            while(rs.next())
            {
                total = rs.getInt(1);
                ordertotal.add(total);
                reportMap.put("Total completed orders: ", total);
            }
            rs = stmt.executeQuery("Select sum(sub_amount), sum(gst), sum(cgst) ,sum(total_amount) from orders where date = '"+date+"' and order_status != 'delete'");
            while(rs.next())
            {
                total = rs.getInt(1);
                reportMap.put("Sub Amount: ", total);
                t = rs.getDouble(2);
                ordertotal.add(t);
                reportMap.put("Total GST: ", t);
                t = rs.getDouble(3);
                ordertotal.add(t);
                reportMap.put("Total CGST: ", t);
                t = rs.getDouble(4);
                ordertotal.add(t);
                reportMap.put("Total cost: ", t);
            }
            System.out.println(ordertotal);
//            return ordertotal;
            return reportMap;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
//        return ordertotal;
    return reportMap;
    }
    
    public static int AddCustomerOrder(Order order, String item_name[], String qty[], String useremail)
    {
        long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
        System.out.println(date);  
        order.setDate(date);
        StringBuffer sb = new StringBuffer();
        int result, c_id = 0;
        for(int i = 0 ; i < qty.length ; i++)
        {
            item_name[i] = item_name[i] + " " +qty[i];
            sb.append(item_name[i]);
        }
        String order_details = sb.toString();
        order.setOrder_details(order_details);
        try
        {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select c_id from customer where c_emailid = '"+useremail+"'");
            while(rs.next())
            {
                order.setC_id(rs.getInt(1));
            }
            prepare = con.prepareStatement("Insert into orders (order_details, sub_amount, gst, cgst, total_amount, date, c_id, order_type) values(?, ?, ?, ?, ?, ?, ?, ?)");
            prepare.setString(1, order.getOrder_details());
            prepare.setInt(2, order.getSubTotal());
            prepare.setDouble(3, order.getGst());
            prepare.setDouble(4, order.getCgst());
            prepare.setDouble(5, order.getGrandTotal());
            prepare.setDate(6, order.getDate());
            prepare.setInt(7, order.getC_id());
            prepare.setString(8, order.getOrder_type());
            result = prepare.executeUpdate();
            if(result == 1)
            {
                rs = stmt.executeQuery("Select order_id from orders where c_id = '"+order.getC_id()+"'");
                while(rs.next())
                {
                    c_id = rs.getInt(1);
                }
            }
            return c_id;
        }
        catch(SQLException e)
        {
            e.printStackTrace();        
        }
        return c_id;
    }
    public static Map<String, Object> getOrderTotalMonth(String month)
    {
        int total = 0;
        double t=0.0;
        
        Map<String, Object> reportMap = new LinkedHashMap<>();
        
        List ordertotal = new ArrayList();
        //Date d = Date.valueOf(date);
        System.out.println(month);
        try
        {
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select count(*) from orders where EXTRACT(MONTH FROM date) = '"+month+"'");
//            System.out.println(rs.next());
            while(rs.next())
            {
                total = rs.getInt(1);
                ordertotal.add(total);
                reportMap.put("Total orders: ", total);
            }
            rs = stmt.executeQuery("SELECT count(*) FROM orders where EXTRACT(MONTH FROM date) = '"+month+"' and order_status = 'delete'");
            while(rs.next())
            {
                total = rs.getInt(1);
                ordertotal.add(total);
                reportMap.put("Total deleted orders: ", total);
            }
            rs = stmt.executeQuery("Select count(*) from orders where EXTRACT(MONTH FROM date) = '"+month+"' and order_status != 'delete'");
            while(rs.next())
            {
                total = rs.getInt(1);
                ordertotal.add(total);
                reportMap.put("Total completed orders: ", total);
            }
            rs = stmt.executeQuery("Select sum(sub_amount), sum(gst), sum(cgst) ,sum(total_amount) from orders where EXTRACT(MONTH FROM date) = '"+month+"' and order_status != 'delete'");
            while(rs.next())
            {
                total = rs.getInt(1);
                reportMap.put("Sub Amount: ", total);
                t = rs.getDouble(2);
                ordertotal.add(t);
                reportMap.put("Total GST: ", t);
                t = rs.getDouble(3);
                ordertotal.add(t);
                reportMap.put("Total CGST: ", t);
                t = rs.getDouble(4);
                ordertotal.add(t);
                reportMap.put("Total cost: ", t);
            }
            System.out.println(ordertotal);
//            return ordertotal;
            return reportMap;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
//        return ordertotal;
    return reportMap;
    }
    public static Map<String, Object> getOrderTotalYear(String year)
    {
        int total = 0;
        double t=0.0;
        
        Map<String, Object> reportMap = new LinkedHashMap<>();
        
        List ordertotal = new ArrayList();
        //Date d = Date.valueOf(date);
        System.out.println(year);
        try
        {
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select count(*) from orders where EXTRACT(YEAR FROM date) = '"+year+"'");
//            System.out.println(rs.next());
            while(rs.next())
            {
                total = rs.getInt(1);
                ordertotal.add(total);
                reportMap.put("Total orders: ", total);
            }
            rs = stmt.executeQuery("SELECT count(*) FROM orders where EXTRACT(YEAR FROM date) = '"+year+"' and order_status = 'delete'");
            while(rs.next())
            {
                total = rs.getInt(1);
                ordertotal.add(total);
                reportMap.put("Total deleted orders: ", total);
            }
            rs = stmt.executeQuery("Select count(*) from orders where EXTRACT(YEAR FROM date) = '"+year+"' and order_status != 'delete'");
            while(rs.next())
            {
                total = rs.getInt(1);
                ordertotal.add(total);
                reportMap.put("Total completed orders: ", total);
            }
            rs = stmt.executeQuery("Select sum(sub_amount), sum(gst), sum(cgst) ,sum(total_amount) from orders where EXTRACT(YEAR FROM date) = '"+year+"' and order_status != 'delete'");
            while(rs.next())
            {
                total = rs.getInt(1);
                reportMap.put("Sub Amount: ", total);
                t = rs.getDouble(2);
                ordertotal.add(t);
                reportMap.put("Total GST: ", t);
                t = rs.getDouble(3);
                ordertotal.add(t);
                reportMap.put("Total CGST: ", t);
                t = rs.getDouble(4);
                ordertotal.add(t);
                reportMap.put("Total cost: ", t);
            }
            System.out.println(ordertotal);
//            return ordertotal;
            return reportMap;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
//        return ordertotal;
    return reportMap;
    }
    public static Order getOrderDetailsCustomer(Customer c)
    {
        Order order = new Order();
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return order;
    }
    public static List <Order> getAllOrderDetails()
    {
        List <Order> order = new ArrayList<Order> ();
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select order_id, order_status from orders where order_status != 'Completed' and order_status != '' and order_status != 'delete' and date = current_date");
            while(rs.next())
            {
                Order o = new Order(rs.getInt(1), rs.getString(2));
                order.add(o);
            }
            return order;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return order;
    }
    public static int updateStatus(int order_id, String status)
    {
        int result = 0;
        try
        {
        prepare = con.prepareStatement("Update orders set order_status = '"+status+"' where order_id = '"+order_id+"' and order"
                    + "_status != 'Completed'");
            result = prepare.executeUpdate();
            return result;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    public static List <Order> getCustomerOrderDetails(String email)
    {
        List <Order> order = new ArrayList<Order> ();
        int id = 0;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select c_id from customer where c_emailid = '"+email+"'");
            while(rs.next())
            {
                id = rs.getInt(1);
            }
            System.out.println(id);
            rs = stmt.executeQuery("Select order_id, order_status from orders where order_status != 'Completed' and order_status != '' and order_status != 'delete' and date = current_date and c_id = '"+id+"'");
            while(rs.next())
            {
                Order o = new Order(rs.getInt(1), rs.getString(2));
                order.add(o);
            }
            return order;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return order;
    }
}
