package com.Rosa.service;

import com.Rosa.bean.Admin;
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

public class AdminService {
    static Connection con = DBConnectionUtil.getConnection();
    static Statement stmt = null;
    static ResultSet rs = null;
    static PreparedStatement prepare = null;
    public static int addAdmin(Admin admin)
    {
        int result = 0;
        try
        {
            prepare = con.prepareStatement("Insert into admin (admin_id, admin_name, admin_emailid, mobile_no, a_password) values(?, ?, ?, ?, ?)");
            prepare.setInt(1, admin.getAdmin_id());
            prepare.setString(2, admin.getAdmin_name());
            prepare.setString(3, admin.getAdmin_emailid());
            prepare.setLong(4, admin.getMobile_no());
            prepare.setString(5, admin.getA_password());
            result = prepare.executeUpdate();
            return result;
        }
        catch(SQLException e)
        {
              e.printStackTrace();      
        }
        return result;
    }
    
    public static List <Admin> searchAdmin(Admin admin) throws SQLException
    {
        ArrayList <Admin> admin_details = new ArrayList <Admin> ();
        int admin_id = admin.getAdmin_id();
        System.out.println(admin_id);
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select admin_id, admin_name, admin_emailid, mobile_no from admin where admin_id = '"+admin_id+"'");
            while(rs.next())
            {
                Admin a = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4));
                admin_details.add(a);
            } 
            return admin_details;
    }
    public static int deleteAdmin(Admin admin) {
        int admin_id = admin.getAdmin_id();
        int result = 0;
        try
        {
            String deleteAdmin = "delete from admin where admin_id = '"+admin_id+"'";
            prepare = con.prepareStatement(deleteAdmin);
            result = prepare.executeUpdate();
        return result;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
    public static int updateAdmin(Admin admin)
    {
        String admin_emailid = admin.getAdmin_emailid();
        int result = 0;
        try
        {
            String updateAdmin = "update admin set admin_name = ?, mobile_no = ? where admin_emailid = '"+admin_emailid+"'";
            prepare = con.prepareStatement(updateAdmin);
            prepare.setString(1, admin.getAdmin_name());
            prepare.setLong(2, admin.getMobile_no());
            result = prepare.executeUpdate();
        return result;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Admin> searchAdminEmail(Admin admin) throws SQLException {
        ArrayList <Admin> admin_details = new ArrayList <Admin> ();
        String admin_emailid = admin.getAdmin_emailid();
        System.out.println(admin_emailid);
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select admin_id, admin_name, admin_emailid, mobile_no from admin where admin_emailid = '"+admin_emailid+"'");
            while(rs.next())
            {
                Admin a = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4));
                admin_details.add(a);
            } 
            return admin_details;
    }
}