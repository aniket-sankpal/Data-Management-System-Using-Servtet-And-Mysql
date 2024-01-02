package com.emp;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RequestViewServlet
 */
@WebServlet("/RequestViewServlet")
public class RequestViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		   HttpSession session = request.getSession();
		 //  session.getAttribute("allmoduls2");
     	Moduls allmoduls = (Moduls) session.getAttribute("allmoduls");

     	if (allmoduls != null) {
     	    // Retrieve values one by one
     	    int mid = allmoduls.getMid();
     	    String mname = allmoduls.getMname();
     	    int employeeId = allmoduls.getEmployee_id();
     	    String status = allmoduls.getStatus();

     	    // Use the retrieved values as needed
     	    out.println("Mid: " + mid);
     	    out.println("Mname: " + mname);
     	    out.println("Employee ID: " + employeeId);
     	    out.println("Status: " + status);
     	} else {
     	    out.println("<p>No Moduls object found in the session.</p>");
     	}
	}
		   
		   
		
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		


	}
}