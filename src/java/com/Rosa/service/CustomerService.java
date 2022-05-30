package com.Rosa.service;

import com.Rosa.bean.Customer;
import com.Rosa.util.DBConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    static Connection con = DBConnectionUtil.getConnection();
    static Statement stmt = null;
    static ResultSet rs = null;
    static PreparedStatement prepare = null;
    public static int changePassword(Customer cust)
    {
        String C_emailid = cust.getC_emailid();
        int result = 0;
        try
        {
            String updateAdmin = "update customer set c_password = ? where c_emailid = '"+C_emailid+"'";
            prepare = con.prepareStatement(updateAdmin);
            prepare.setString(1, cust.getC_password());
            result = prepare.executeUpdate();
        return result;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
    public static List<Customer> searchCustomerEmail(Customer c) throws SQLException {
        ArrayList <Customer> c_details = new ArrayList <Customer> ();
        String c_emailid = c.getC_emailid();
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select c_id, c_name, c_emailid, address, pin, mobile_no from customer where c_emailid = '"+c_emailid+"'");
            while(rs.next())
            {
                Customer e = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getLong(6));
                c_details.add(e);
            } 
            return c_details;
    }
    public static int updateEmployeeProfile(Customer c)
    {
        String c_emailid = c.getC_emailid();
        int result = 0;
        try
        {
            String updateCustomer = "update customer set c_name = ?, address = ?, pin = ?, mobile_no = ? where c_emailid = '"+c_emailid+"'";
            prepare = con.prepareStatement(updateCustomer);
            prepare.setString(1, c.getC_name());
            prepare.setString(2, c.getAddress());
            prepare.setInt(3, c.getPin());
            prepare.setLong(4, c.getMobile_no());
            result = prepare.executeUpdate();
        return result;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
