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
 * Servlet implementation class RequestSuccessPage
 */
@WebServlet("/RequestSuccessPage")
public class RequestSuccessPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestSuccessPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html;charset=UTF-8");
	        response.setHeader("Refresh", "5;url=WelcomeServlet");
	        HttpSession session = request.getSession();
	        session.setAttribute("allmoduls2",   session.getAttribute("allmoduls"));
	        session.setAttribute("rid", session.getAttribute("id"));
	        try (PrintWriter out = response.getWriter()) {
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
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<meta charset='UTF-8'>");
	            out.println("<title>Redirect Page</title>");
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<h1 style='color:green'>Request Send Successfully...Please Wait... For Accept Your Request !!!</h1>");
	        
	           
	            out.println("</body>");
	            out.println("</html>");
	            out.close();
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
