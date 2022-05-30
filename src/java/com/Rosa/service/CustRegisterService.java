package com.Rosa.service;

import com.Rosa.bean.Customer;
import com.Rosa.util.DBConnectionUtil;
import java.sql.*;

public class CustRegisterService {
    public static int addCustomer(Customer c)
    {
        int result = 0;
        try
        {
            Connection con = DBConnectionUtil.getConnection();
            PreparedStatement stmt = con.prepareStatement("Insert into customer (c_name, c_emailid, address, pin, mobile_no, c_password) values(?, ?, ?, ?, ?, ?)");
            stmt.setString(1, c.getC_name());
            stmt.setString(2, c.getC_emailid());
            stmt.setString(3, c.getAddress());
            stmt.setInt(4, c.getPin());
            stmt.setLong(5, c.getMobile_no());
            stmt.setString(6, c.getC_password());
            result = stmt.executeUpdate();
            return result;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
    public static int getC_id(String email)
    {
        int result = 0;
        try
        {
            Connection con = DBConnectionUtil.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select c_id from customer where c_emailid = '"+email+"'");
            while(rs.next())
            {
                result = rs.getInt(1);
            }
            return result;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
