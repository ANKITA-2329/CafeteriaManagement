package com.Rosa.util;
import java.sql.*;

public class DBConnectionUtil {
    private static String url = "jdbc:postgresql://localhost:5432/cafeteria_management";
    private static String user = "postgres";
    private static String password = "postgres";
    public static Connection getConnection()
    {
        Connection con = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
            return con;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return con;
    }
}
