package com.Rosa.service;

import com.Rosa.util.DBConnectionUtil;
import java.sql.*;

public class CustomerLoginService {
    public static Boolean verifyCredentials(String user_email, String password)
    {
        try
        {
        Connection con = DBConnectionUtil.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from customer ");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
