package com.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModulsDao {

	

	public static Connection getConnection() {
		Connection con=null;
		try
		{
			
			
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
	
	//get by id 
	public static List<Moduls> getModulsById(int moduleId) {
	    List<Moduls> list = new ArrayList<>();
	    try {
	        Connection con = ModulsDao.getConnection();
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM moduls WHERE mid = ?");
	        
	        // Set the parameter for the WHERE clause
	        ps.setInt(1, moduleId);

	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	        	Moduls m=new Moduls();
				m.setMid(rs.getInt(1));
				m.setMname(rs.getString(2));
				m.setStatus(rs.getString(4));
				m.setReqid(rs.getInt(5));
	            // Add the Moduls object to the list
	            list.add(m);
	        }
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}


	
	//all get 
	public static List<Moduls> getAllModuls()
	{
		List<Moduls> list =new ArrayList<Moduls>();
		try {
			Connection con =ModulsDao .getConnection();
			PreparedStatement ps=con.prepareStatement("select * from moduls");
		ResultSet rs =ps.executeQuery();
		while (rs.next())
		{
			
			Moduls m=new Moduls();
			m.setMid(rs.getInt(1));
			m.setMname(rs.getString(2));
			m.setStatus(rs.getString(4));
			m.setReqid(rs.getInt(5));
			list.add(m);
		}
			con.close();
		}
			catch(Exception e) {
				e.printStackTrace();
				
			}
			return list;
		
	}
//delete
	public static int delete(int reqid) {

		int status=0;
		try {
			Connection con =ModulsDao .getConnection();
			PreparedStatement ps=con.prepareStatement("delete from moduls where reqid=?");
			
			ps.setInt(1, reqid);
		
			status=ps.executeUpdate();
			con.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		return status;
	}
	//update
	public static int update(Moduls e) {
	    int status = 0;
	    
	    try (Connection con = ModulsDao.getConnection();
	         PreparedStatement ps = con.prepareStatement("UPDATE moduls SET mid = ?,mname = ?,employee_id = ?,status = ? WHERE req_id = ?")) {

	        // Set the parameters for the update statement
	    	  ps.setInt(1, e.getMid());
	        ps.setString(2, e.getMname());
	        ps.setInt(3, e.getEmployee_id());
	        ps.setString(4, e.getStatus());
	      
	        ps.setInt(5, e.getReqid());

	        // Execute the update statement
	        status = ps.executeUpdate();
	        
	    } catch (SQLException ex) {
	        // Handle SQLException (or log it) more gracefully
	        ex.printStackTrace();
	    } catch (Exception ex) {
	        // Handle other exceptions (or log them) more gracefully
	        ex.printStackTrace();
	    }
	    
	    return status;
	}
//get by req id
	public static List<Moduls> getModulsByReqId(int req_id) {
	    List<Moduls> modules = new ArrayList<>();
	    try (Connection con = ModulsDao.getConnection();
	         PreparedStatement ps = con.prepareStatement("SELECT * FROM moduls WHERE req_id=?")) {

	        ps.setInt(1, req_id);

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Moduls m = new Moduls();
	                m.setReqid(rs.getInt("req_id"));
	                m.setMid(rs.getInt("mid"));
	                m.setMname(rs.getString("mname"));
	                m.setEmployee_id(rs.getInt("employee_id"));
	                m.setStatus(rs.getString("status"));
	                // Add more properties as needed

	                modules.add(m);
	            }
	        }

	    } catch (SQLException ex) {
	        // Handle SQLException (or log it) more gracefully
	        ex.printStackTrace();
	    } catch (Exception ex) {
	        // Handle other exceptions (or log them) more gracefully
	        ex.printStackTrace();
	    }

	    return modules;
	}

//update by id
	public static int updateById(Moduls updatedModule) {
	    int status = 0;
	    try {
	        Connection con = ModulsDao.getConnection();
	        PreparedStatement ps = con.prepareStatement("UPDATE moduls SET mid=?,mname=?, employee_id=?, status=? WHERE reqid=?");

	        // Set the parameters for the update statement
	        ps.setInt(1, updatedModule.getMid());
	        ps.setString(2, updatedModule.getMname());
	        ps.setInt(3, updatedModule.getMid());
	        ps.setString(4, updatedModule.getStatus());
	        ps.setInt(5, updatedModule.getReqid());

  
	        // Execute the update statement
	        status = ps.executeUpdate();

	        // Close the connection
	        con.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return status;
	}

	//save
	public static int save(Moduls e)
	{
		
		int status=0;
		try {
			
			Connection con =ModulsDao .getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO moduls(mid,mname,employee_id,status ) VALUES(?,?,?,?)");
		ps.setInt(1, e.getMid());
		
			ps.setString(2, e.getMname());
			ps.setInt(3, e.getEmployee_id());
			
			ps.setString(4, e.getStatus());
		
		status=ps.executeUpdate();
		con.close();
		
		}
	catch(Exception ex)
		{
		
		ex.printStackTrace();
		}
		return status;
		}
	
	//get by name 
	public static List<Moduls> getModulsByName(String mname) {
	    List<Moduls> list = new ArrayList<>();
	    try {
	        Connection con = ModulsDao.getConnection();
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM moduls WHERE mname = ?");
	        
	        // Set the parameter for the WHERE clause
	        ps.setString(1, mname);

	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Moduls m = new Moduls();
	            m.setReqid(rs.getInt("reqid"));
	            m.setMid(rs.getInt("mid"));
	            m.setMname(rs.getString("mname"));
	            m.setStatus(rs.getString("status"));
	            // Add the Moduls object to the list
	            list.add(m);
	        }
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}


}
