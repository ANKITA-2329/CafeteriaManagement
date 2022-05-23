package com.Rosa.service;

import com.Rosa.bean.Employee;
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

public class EmployeeService {
    static Connection con = DBConnectionUtil.getConnection();
    static Statement stmt = null;
    static ResultSet rs = null;
    static PreparedStatement prepare = null;
    public static int addEmployee(Employee emp)
    {
        int result = 0;
        try
        {
            prepare = con.prepareStatement("Insert into employee (emp_id, emp_name, emp_emailid, workplace, mobile_no, e_password) values(?, ?, ?, ?, ?, ?)");
            prepare.setInt(1, emp.getEmp_id());
            prepare.setString(2, emp.getEmp_name());
            prepare.setString(3, emp.getEmp_emailid());
            prepare.setString(4, emp.getWorkplace());
            prepare.setLong(5, emp.getMobile_no());
            prepare.setString(6, emp.getPassword());
            result = prepare.executeUpdate();
            return result;
        }
        catch(SQLException e)
        {
              e.printStackTrace();      
        }
        return result;
    }
    
    public static List <Employee> searchEmployee(Employee emp) throws SQLException
    {
        ArrayList <Employee> emp_details = new ArrayList <Employee> ();
        int emp_id = emp.getEmp_id();
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select emp_id, emp_name, emp_emailid, workplace, mobile_no from employee where emp_id = '"+emp_id+"'");
            while(rs.next())
            {
                Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5));
                emp_details.add(e);
            } 
            return emp_details;
    }
    public static int deleteEmployee(Employee emp) {
        int emp_id = emp.getEmp_id();
        int result = 0;
        try
        {
            String deleteEmployee = "delete from employee where emp_id = '"+emp_id+"'";
            prepare = con.prepareStatement(deleteEmployee);
            result = prepare.executeUpdate();
        return result;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
    public static int updateEmployee(Employee emp)
    {
        int emp_id = emp.getEmp_id();
        int result = 0;
        try
        {
            String updateEmployee = "update employee set workplace = ? where emp_id = '"+emp_id+"'";
            prepare = con.prepareStatement(updateEmployee);
            prepare.setString(1, emp.getWorkplace());
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