package com.Rosa.service;

import com.Rosa.bean.Item;
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

public class ItemService {
    static Connection con = DBConnectionUtil.getConnection();
    static Statement stmt = null;
    static ResultSet rs = null;
    static PreparedStatement prepare = null;
    public static int addItem(Item item)
    {
        int result = 0;
        try
        {
            prepare = con.prepareStatement("Insert into item (item_name, item_category, item_description, price, status) values(?, ?, ?, ?, ?)");
            prepare.setString(1, item.getItem_name());
            prepare.setString(2, item.getItem_category());
            prepare.setString(3, item.getItem_description());
            prepare.setInt(4, item.getPrice());
            prepare.setString(5, item.getStatus());
            result = prepare.executeUpdate();
            return result;
        }
        catch(SQLException e)
        {
              e.printStackTrace();      
        }
        return result;
    }
    
    public static List <Item> searchItem(Item item) throws SQLException
    {
        ArrayList <Item> item_details = new ArrayList <Item> ();
        String iname = item.getItem_name();
        System.out.println(iname);
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from item where item_name = '"+iname+"'");
            System.out.println(rs.next());
            while(rs.next())
            {
                System.out.println(rs.getInt(1));
            } 
            return item_details;
    }
    public static int deleteItem(Item item) {
        return 0;
    }
}
