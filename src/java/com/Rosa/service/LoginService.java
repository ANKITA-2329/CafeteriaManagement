package com.Rosa.service;

import com.Rosa.util.DBConnectionUtil;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginService {
    static Statement stmt = null;
    static ResultSet rs = null;
    
    public static Boolean customerVerification(String user_email, String password)
    {
        try
        {
            rs = stmt.executeQuery("Select c_emailid, c_password from customer where c_emailid = '"+user_email+"' and c_password = '"+password+"'");
            System.out.println(user_email + " " + password);
            while(rs.next())
            {
                
                if(rs.getString(1).equals(user_email) && rs.getString(2).equals(password))
                {
                    return true;
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
    public static Boolean verifyCredentials(String user_email, String password)
    {   
        Boolean result = false;
        Connection con = DBConnectionUtil.getConnection();
        try {
            stmt = con.createStatement();
            result = customerVerification(user_email, password);
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
}
