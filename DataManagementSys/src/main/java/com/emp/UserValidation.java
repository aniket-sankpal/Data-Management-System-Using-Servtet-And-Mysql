package com.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserValidation
 */
@WebServlet("/UserValidation")
public class UserValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
Connection con=null;
    /**
     * Default constructor. 
     */
    public UserValidation() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
protected  void service(HttpServletRequest request , HttpServletResponse response)
throws ServletException ,IOException{
	response.setContentType("text/html");
	PrintWriter out =response.getWriter();
	String name =request.getParameter("name");
	String password =request.getParameter("password");
	try {
		response.setContentType("text/html");
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test5?characterEncoding=utf8","root","root");
		String q="select * from employee where NAME=(?) and PASSWORD=(?)";
		PreparedStatement ps=con.prepareStatement(q);
		ps.setString(1,name);
		ps.setString(2,password);
		ResultSet rs =ps.executeQuery();
		if(rs.next()) {
		
			name=rs.getString(1);
			password=rs.getString(2);
			
			if(name.equalsIgnoreCase(name) && password.equalsIgnoreCase(password));
			{
				
				out.print("Login by emp id:"+name);
				HttpSession session =request.getSession();
				if(session !=null) {
					session .setAttribute("name",name);
					RequestDispatcher rd=request.getRequestDispatcher("ViewServlet");
					rd.include(request,response);
				}
			}
		
				}else {
					out.print("check user name and password");
					RequestDispatcher rd=request.getRequestDispatcher("LoginForm.html");
					rd.include(request,response);
				}
		con.close();
	}
	catch(Exception ex)
	{
		
		out.print(ex);
		out.close();
	}
}
}
