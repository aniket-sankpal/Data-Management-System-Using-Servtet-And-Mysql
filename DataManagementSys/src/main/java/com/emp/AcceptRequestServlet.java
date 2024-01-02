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
 * Servlet implementation class AcceptRequestServlet
 */
@WebServlet("/AcceptRequestServlet")
public class AcceptRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // Retrieve parameters from the request
//		        int moduleId = Integer.parseInt(request.getParameter("id"));
//		        String moduleName = request.getParameter("mname");
//		        String permission = request.getParameter("permission");

		        // Use the retrieved parameters as needed
		        // ...

		        // Example: Print the values to the response
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		HttpSession session = request.getSession();
		
		// AcceptRequestServlet
		try {
	//	    HttpSession session = request.getSession();
		    
		    // Retrieve values from request parameters
		    int rid = Integer.parseInt(request.getParameter("reqid"));
		    int moduleId = Integer.parseInt(request.getParameter("id"));
		    String newMname = request.getParameter("mname");
		    int newEmployeeId = Integer.parseInt(request.getParameter("id"));
		    String newStatus = request.getParameter("permission");
out.println(rid);
out.println(moduleId);
out.println(newMname);
out.println(newEmployeeId);
out.println(newStatus);
		

		    // req true false
		    String newStatus1 = null;
		    if (newStatus != null && newStatus.equals("true")) {
		        newStatus1 = "Request Accepted";
		    } else if (newStatus != null && newStatus.equals("false")) {
		        newStatus1 = "Request Denied";
		    }

		    // Create a Moduls object with the updated data
		    Moduls updatedModule = new Moduls();
		    updatedModule.setMid(moduleId);
		    updatedModule.setMname(newMname);
		    updatedModule.setEmployee_id(moduleId);
		    updatedModule.setStatus(newStatus1);
		    updatedModule.setReqid(rid);

		    // Call the update method from ModulsDao
		    int updateStatus = ModulsDao.update(updatedModule);

		    // Check the update status
		    if (updateStatus > 0) {
		        response.getWriter().println("Update successful!");
		    } else {
		        response.getWriter().println("Update failed!");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}

		  //print values
//	    response.getWriter().println("req ID: " + rid);
//          response.getWriter().println("Module ID: " + moduleId);
//          response.getWriter().println("Module Name: " + newMname);
//          response.getWriter().println("Permission: " + newStatus1);
//	    
//
//
		}	          
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	


	}}
