/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Rosa.service;

import com.Rosa.util.DBConnectionUtil;
import java.sql.*;

/**
 *
 * @author Dell
 */
public class EmpAdminService {    
    public static Boolean verifyCredentials(String user_email, String password, String user_type)
    {
        
        try
        {
            Connection con = DBConnectionUtil.getConnection();
            Statement stmt = con.createStatement();
            if(user_type.equals("admin"))
            {
                ResultSet rs = stmt.executeQuery("Select admin_emailid, a_password from admin where admin_emailid = '"+user_email+"' and a_password = '"+password+"'");

                while(rs.next())
                {
                    if(rs.getString(1).equals(user_email) && rs.getString(2).equals(password))
                    {
                        return true;
                    }
                }
            }
            if(user_type.equals("employee"))
            {
                ResultSet rs = stmt.executeQuery("Select emp_emailid, e_password from employee where emp_emailid = '"+user_email+"' and e_password = '"+password+"'");

                while(rs.next())
                {
                    if(rs.getString(1).equals(user_email) && rs.getString(2).equals(password))
                    {
                        return true;
                    }
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
