package com.Rosa.service;

import com.Rosa.bean.Order;
import com.Rosa.bean.Payment;
import com.Rosa.util.DBConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentService {
    static Connection con = DBConnectionUtil.getConnection();
    static PreparedStatement prepare = null;
    static ResultSet rs = null, rs1 = null;
    static Statement stmt = null;
    public static int addPayment(Payment payment)
    {
        int result = 0;
        long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
        System.out.println(date); 
        payment.setPayment_date(date);
        try 
        {
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select total_amount from orders where order_id = '"+payment.getOrder_id()+"'");
            while(rs.next())
            {
                payment.setPayment_amount(rs.getDouble(1));
            }
            System.out.println(payment.getPayment_amount());

                prepare = con.prepareStatement("Insert into payment (payment_mode, payment_status, order_id, payment_amount, payment_date) values (?, ?, ?, ?, ?)");
                prepare.setString(1, payment.getPayment_mode());
                prepare.setString(2, "Confirm");
                prepare.setInt(3, payment.getOrder_id());
                prepare.setDouble(4, payment.getPayment_amount());
                prepare.setDate(5, payment.getPayment_date());
                prepare.executeUpdate();
                prepare =con.prepareStatement("Update orders set order_status = 'Placed' where order_id = '"+payment.getOrder_id()+"'");
                prepare.executeUpdate();
            rs = stmt.executeQuery("Select payment_id from payment where order_id = '"+payment.getOrder_id()+"'");
            while(rs.next())
            {
                result = rs.getInt(1);
            }
            return result;
        } 
        catch (SQLException ex) {
                ex.printStackTrace();
            }
        return result;
    }
    public static Payment getPaymentDetails(int payment_id)
    {
        Payment payment = null;
        try
        {
            
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select payment_mode, order_id, payment_amount from payment where payment_id = '"+payment_id+"' and payment_status = 'Confirm'");
            while(rs.next())
            {
                payment = new Payment(rs.getString(1), rs.getInt(2), rs.getDouble(3));
            }
            return payment;
        }
        catch(SQLException e)
        {
            e.printStackTrace();        
        }
        return payment;
    }
    public static int deleteOrder(int payment_id)
    {
        System.out.println(payment_id);
        int result = 0;
        try
        {
            int order_id = 0;
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select order_id from payment where payment_id = '"+payment_id+"'");
            while(rs.next())
            {
                order_id = rs.getInt(1);
            }
            System.out.println(order_id);
            prepare = con.prepareStatement("Delete from payment where payment_id = '"+payment_id+"'");
            result = prepare.executeUpdate();
            System.out.println(result);
            prepare = con.prepareStatement("Update orders set order_status = 'delete' where order_id = '"+order_id+"'");
            result = prepare.executeUpdate();
            System.out.println(result);
            return result;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
    public static int updateOrder(int payment_id, String order_status)
    {
        System.out.println(payment_id);
        int result = 0;
        try
        {
            int order_id = 0;
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select order_id from payment where payment_id = '"+payment_id+"'");
            while(rs.next())
            {
                order_id = rs.getInt(1);
            }
            System.out.println(order_id);
            prepare = con.prepareStatement("Update orders set order_status = '"+order_status+"' where order_id = '"+order_id+"' and order"
                    + "_status != 'Completed'");
            result = prepare.executeUpdate();
            System.out.println(result);
            return order_id;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
    public static Payment[] getAllPaymentDetails()
    {
        Payment [] pay = null;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select order_id from order where order_status != 'Completed' and order_status != ''");
            while(rs.next())
            {
                prepare = con.prepareStatement("Select order_id, payment_mode, payment_amount, payment_id from orders where order_id = '"+rs.getInt(1)+"'");
                rs1 = prepare.executeQuery();
            }
            int i = 0;
            while(rs1.next())
            {
                pay[i] = new Payment(rs1.getInt(1), rs1.getString(2), rs1.getDouble(3), rs1.getInt(4));
            }
            System.out.println(pay);
            return pay;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pay;
    }
}
