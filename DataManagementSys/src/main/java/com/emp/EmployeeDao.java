package com.emp;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
public static Connection getConnection() {
	Connection con=null;
	try
	{
		
		
//	Class.forName("com.mysql.jdbc.Driver");
////
////		
//	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/opm?characterEncoding=utf8", "root", "root");
		 Class.forName("com.mysql.cj.jdbc.Driver");

   
    String jdbcUrl = "jdbc:mysql://localhost:3306/opm";
       String username = "root";
       String password = "root";
        con = DriverManager.getConnection(jdbcUrl, username, password);

	}
	catch(Exception e){
		
		System.out.println(e);
		
	}
	
	return con;
	
}
	public static int save(Employee e)
	{
		
		int status=0;
		try {
			
			Connection con =EmployeeDao .getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO employee(id,name ,password,role) VALUES(?,?,?,?)");
		ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
		ps.setString(3, e.getPassword());
		ps.setString(4, e.getRole());
		
		status=ps.executeUpdate();
		con.close();
		
		}
	catch(Exception ex)
		{
		
		ex.printStackTrace();
		}
		return status;
		}
	
	
	
	
	public static List<Employee> getAllEmployee()
	{
		List<Employee> list =new ArrayList<Employee>();
		try {
			Connection con =EmployeeDao .getConnection();
			PreparedStatement ps=con.prepareStatement("select * from employee");
		ResultSet rs =ps.executeQuery();
		while (rs.next())
		{
			
			Employee e=new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPassword(rs.getString(3));
			e.setRole(rs.getString(4));
			list.add(e);
		}
			con.close();
		}
			catch(Exception e) {
				e.printStackTrace();
				
			}
			return list;
		
	}
	public static int update(Employee e) {
	    int status = 0;
	    try {
	        try (Connection con = EmployeeDao.getConnection();
	             PreparedStatement ps = con.prepareStatement("update employee set role=?, name=?, password=? where id=?")) {

	            // Set parameters in the correct order
	            ps.setString(1, e.getRole());
	            ps.setString(2, e.getName());
	            ps.setString(3, e.getPassword());
	            ps.setInt(4, e.getId());

	            status = ps.executeUpdate();
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return status;
	}
		
		public static int delete(int id)
		{
			
			int status=0;
			try {
				Connection con =EmployeeDao .getConnection();
				PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
				
				ps.setInt(1, id);
			
				status =ps .executeUpdate();
				con.close();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				
			}
			return status;

		}
		
		
		
		public static Employee getEmployeeById(int id) {
		    Employee e = new Employee();
		    try {
		        Connection con = EmployeeDao.getConnection();
		        PreparedStatement ps = con.prepareStatement("select * from employee where id=?");
		        ps.setInt(1, id);
		        ResultSet rs = ps.executeQuery();
		        if (rs.next()) {
		            e.setId(rs.getInt(1));
		            e.setName(rs.getString(2));
		            e.setPassword(rs.getString(3));
		            e.setRole(rs.getString(4));
		        }
		        con.close();
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		    return e;
		}
		public static Employee getEmployeeByName(String name) {
		    Employee e = new Employee();
		    try {
		        Connection con = EmployeeDao.getConnection();
		        PreparedStatement ps = con.prepareStatement("select * from employee where name=?");
		        ps.setString(1, name);
		        ResultSet rs = ps.executeQuery();
		        if (rs.next()) {
		            e.setId(rs.getInt(1));
		            e.setName(rs.getString(2));
		            e.setPassword(rs.getString(3));
		            e.setRole(rs.getString(4));
		        }
		        con.close();
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		    return e;
		}

		

}
