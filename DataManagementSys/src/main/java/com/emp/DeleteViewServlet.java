package com.emp;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/DeleteViewServlet")
public class DeleteViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteViewServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	response.setContentType("text/html");
	PrintWriter out =response.getWriter();
	out.println("<center><h1>Employee List</h1></center>");
	
	out.println("<center><h4><a href='LogOut'>logout</a></h4></center>");
	
	List <Employee>list =EmployeeDao.getAllEmployee();
	
	out.println("<table border='2' width='100%' ");
	out.println("<tr>"
			+ "<th>Id</th>"
			+ "<th>Name</th>"
			+ "<th>pasword</th>"
			+ "<th>Role</th>"
			
			+ "<th>delete</th>");
	for (Employee e : list) {
	    out.println("<tr>"
	            + "<td>" + e.getId() + "</td>"
	            + "<td>" + e.getName() + "</td>"
	            + "<td>" + e.getPassword() + "</td>"
	            + "<td>" + e.getRole() + "</td>"
	         
	            + "<td><a href='DeleteServlet?id=" + e.getId() + "'>Delete</a></td>"
	            + "</tr>");
	}
	out.println("</table>");
	out.close();
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
