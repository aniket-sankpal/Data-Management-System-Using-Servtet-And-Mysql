package com.emp;

import java.io.IOException;


import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ViewServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	response.setContentType("text/html");
	PrintWriter out =response.getWriter();
	HttpSession session = request.getSession();
	String myname=(String)session.getAttribute("name");
	out.println("<center><h1>Employee List</h1></center>");
	out.println("<center><h1>Welcome:"+myname+"</h1></center>");
	out.println("<center><h2><a href='index.html' style='color:green'> Register New Employee</a></h2></center>");
	out.println("<center><h4><a href='LogOut'style='color:red'>logout</a></h4></center>");
	
	List <Employee>list =EmployeeDao.getAllEmployee();
	List <Moduls>list2 =ModulsDao.getAllModuls();
	
	out.println("<table border='2' width='100%'style='background-color: lightblue;'");
	out.println("<tr>"
			+ "<th>Id</th>"
			+ "<th>Name</th>"
			+ "<th>Password</th>"
			+ "<th>Role</th>"
			+ "<th>Edit</th>"
			+ "<th>Delete</th>"
			);
	for (Employee e : list) {
	    out.println("<tr>"
	            + "<td>" + e.getId() + "</td>"
	            + "<td>" + e.getName() + "</td>"
	            + "<td>" + e.getPassword() + "</td>"
	            + "<td>" + e.getRole() + "</td>"
	            + "<td><a href='EditServletForm?id=" + e.getId() + "'style='color:blue'>Edit</a></td>"
	            + "<td><a href='DeleteServlet?id=" + e.getId() + "'style='color:red'>Delete</a></td>"
	          
	          
		             + "</tr>");
	}

	out.println("</table>");
	out.println("<br><br>");
	out.println("<center><h1>Request List</h1></center>");
	out.println("<table border='2' width='100%' style='background-color: lightblue;'");
	out.println("<tr>"
	        + "<th>Request Id</th>"
	        + "<th>Employee Id</th>"
	        + "<th>Request Role</th>"
	        + "<th>Accept</th>"
	        + "<th>Denied</th>"
	        + "<th>Delete</th>"
	        + "<th>Status</th>"
	        + "</tr>");

	boolean permission = false;
	for (Moduls m : list2) {
	    out.println("<tr>"
	            + "<td>" + m.getReqid() + "</td>"
	            + "<td>" + m.getMid() + "</td>"
	            + "<td>" + m.getMname() + "</td>"
	            + "<td><a href='AcceptRequestServlet?reqid=" + m.getReqid() + "&id=" + m.getMid() + "&mname=" + m.getMname() + "&permission=true' style='color:blue'>Accept</a></td>"
	            + "<td><a href='AcceptRequestServlet?reqid=" + m.getReqid() + "&id=" + m.getMid() + "&mname=" + m.getMname() + "&permission=false' style='color:red'>Denied</a></td>"
	            + "<td><a href='DeleteRequestServlet?rid=" + m.getReqid() + "' style='color:blue'>Delete</a></td>"
	            + "<td>" + m.getStatus() + "</td>"
	            + "</tr>");

	    int mid = m.getMid();
	    int reqid = m.getReqid();
	    String name = m.getMname();
	    session.setAttribute("reqid", reqid);
	    session.setAttribute("mid", mid);
	    session.setAttribute("mname1", name);
	    session.setAttribute("permission", permission);
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
