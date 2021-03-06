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
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from item where item_name = '"+iname+"'");
            while(rs.next())
            {
                Item i = new Item(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
                item_details.add(i);
            } 
            return item_details;
    }
    public static int deleteItem(Item item) {
        String iname = item.getItem_name();
        int result = 0;
        try
        {
            String deleteCustomer = "delete from item where item_name = ?";
            prepare = con.prepareStatement(deleteCustomer);
            prepare.setString(1, iname);
            result = prepare.executeUpdate();
        return result;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
    public static int updateItem(Item item)
    {
        String iname = item.getItem_name();
        int result = 0;
        try
        {
            String updateCustomer = "update item set price = ?, status = ? where item_name = '"+iname+"'";
            prepare = con.prepareStatement(updateCustomer);
            prepare.setInt(1, item.getPrice());
            prepare.setString(2, item.getStatus());
            result = prepare.executeUpdate();
        return result;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
    public static List <Item> getItemCoffee()
    {
        ArrayList <Item> item_details = new ArrayList <Item> ();
             
        try
        {
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select item_name, item_description, price from item where item_category = 'Coffee' and status = 'Available'");
            while(rs.next())
            {
                Item i = new Item(rs.getString(1), rs.getString(2), rs.getInt(3));
                item_details.add(i);
            }
            return item_details;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return item_details;
    }
    
    public static List <Item> getItemBurger()
    {
        ArrayList <Item> item_details = new ArrayList <Item> ();
             
        try
        {
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select item_name, item_description, price from item where item_category = 'Burger' and status = 'Available'");
            while(rs.next())
            {
                Item i = new Item(rs.getString(1), rs.getString(2), rs.getInt(3));
                item_details.add(i);
            }
            return item_details;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return item_details;
    }
    public static List <Item> getItemSandwich()
    {
        ArrayList <Item> item_details = new ArrayList <Item> ();
             
        try
        {
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select item_name, item_description, price from item where item_category = 'Sandwich' and status = 'Available'");
            while(rs.next())
            {
                Item i = new Item(rs.getString(1), rs.getString(2), rs.getInt(3));
                item_details.add(i);
            }
            return item_details;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return item_details;
    }
    public static List <Item> getSelectedItem(String qty[], String item_name[], String item_price[])
    {
        ArrayList <Item> selected_item = new ArrayList <Item> ();
        for(int i = 0 ; i < item_name.length ; i++)
        {
            if(!qty[i].equals("0"))
            {
                int q = Integer.parseInt(qty[i]);
                int price = Integer.parseInt(item_price[i]);
                int total = q * price;
                Item item = new Item(item_name[i], price, q, total);
                selected_item.add(item);
            }
        }
        return selected_item;
    }
}
