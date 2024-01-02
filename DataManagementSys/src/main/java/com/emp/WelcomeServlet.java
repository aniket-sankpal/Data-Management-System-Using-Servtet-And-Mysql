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
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        HttpSession session = request.getSession();
	      String uname= (String) session.getAttribute("username");
	      //return to page session code============
	     // HttpSession session = request.getSession();
	    //  String currentURL = request.getRequestURL().toString();
	     // session.setAttribute("previousPage", currentURL);
	      // script====================================
	      out.println("<script>"
	    	        + "function validateForm() {"
	    	        + "    var checkboxes = document.getElementsByName('selection');"
	    	        + "    var checkedCount = 0;"
	    	        + ""
	    	        + "    for (var i = 0; i < checkboxes.length; i++) {"
	    	        + "        if (checkboxes[i].checked) {"
	    	        + "            checkedCount++;"
	    	        + "        }"
	    	        + "    }"
	    	        + ""
	    	        + "    if (checkedCount !== 1) {"
	    	        + "        alert('Please select exactly one option.');"
	    	        + "        return false;"
	    	        + "    }"
	    	        + ""
	    	        + "    return true;"
	    	        + "}"
	    	        + "</script>");

	        //=====================
	        out.println("<h2 style='color:green'>Login Successfully!.</h2>");
  	  out.println("<h2 style='color:purple'>"+"Welcome:"+uname+"</h2>");
  	 out.println("<h3 style='color:red'><a href='LogOut'>Logout</a></h3>");
	        //out.println("<h3 style='color:orange'>"+"Role:"+role+"</h3>");
	//req page
  	 

	  
	    out.println("<h2 style='color:blue'>"+"Request To Page :"+"</h2>");
     out.println("<form action='WaitingServlet' method='POST"
	    		+ "' onsubmit='return validateForm()'>");
	    out.println("<table border='2' width='100%' style='background-color: lightblue;'>");
	    out.println("<tr>"
	            + "<th> CREATE PAGE</th>"
	            + "<th> READ PAGE</th>"
	            + "<th> UPDATE PAGE</th>"
	            + "<th> DELETE PAGE</th>"
	            + "<th>Request</th>"
	            + "</tr>");

	    out.println("<tr>"
	            + "<td>"
	            + "<input type='checkbox' name='selection' value='CREATE ' checked>"
	            + "</td>"
	            + "<td>" + "<input type='checkbox' name='selection' value='READ '>"
	            + "</td>"
	            + "<td>" + "<input type='checkbox' name='selection' value='UPDATE '>"
	            + "</td>"
	            + "<td>" + "<input type='checkbox' name='selection' value='DELETE '>"
	            + "</td>"
	            + "<td>" + "<input type='submit' value='Send Request'>"
	            + "</td>"
	            + "</tr>");

	    out.println("</table>");
       out.println("<br><br>");
	 
	    
	    out.println("</form><br>");
	 // req table +++++++++++++++++++++++++++++++++++++++++++++++++++
	    out.println("Your Requests ");
	    out.println("<br><br>");
	    out.println("<center><h1>Request List</h1></center>");
	
	    int eid1 = 0;

	 // Check the name value
	 out.println("Check ename: " + uname);

	 // Get Employee by Name
	 Employee employee = EmployeeDao.getEmployeeByName(uname);

	 if (employee != null) {
	     eid1 = employee.getId();

	     // Check the id value
	     out.println("Check eid: " + eid1);

	     // Get Modules by Employee ID
	     List<Moduls> list2 = ModulsDao.getModulsById(eid1);

	     if (list2.isEmpty()) {
	         out.println("<p>No requests found for the user.</p>");
	     } else {
	         out.println("<table border='2' width='100%' style='background-color: lightblue;'>");
	         out.println("<tr>"
	                 + "<th>Request Id</th>"
	                 + "<th>Module Id</th>"
	                 + "<th>Module Name</th>"
	                 + "<th>Status</th>"
	                 + "<th>Open Pages</th>"
	                 + "</tr>");

	  

	         for (Moduls m : list2) {
	             out.println("<tr>"
	                     + "<td>" + m.getReqid() + "</td>"
	                     + "<td>" + m.getMid() + "</td>"
	                     + "<td>" + m.getMname() + "</td>"
	                     + "<td>" + m.getStatus() + "</td>");

	             String st = m.getStatus();
	             String page = m.getMname();
	             st = st.trim();
	             page = page.trim();

	             if ("Request Accepted".equalsIgnoreCase(st)) {
	            	    if ("CREATE".equals(page)) {
	            	        out.println("<td><a href='CreateViewServlet' style='color:green'>Open Page</a></td>");
	            	    } else if ("READ".equals(page)) {
	            	        out.println("<td><a href='ReadViewServlet' style='color:green'>Open Page</a></td>");
	            	    } else if ("UPDATE".equals(page)) {
	            	        out.println("<td><a href='UpdateViewServlet' style='color:green'>Open Page</a></td>");
	            	    } else if ("DELETE".equals(page)) {
	            	        out.println("<td><a href='DeleteViewServlet' style='color:green'>Open Page</a></td>");
	            	    } else {
	            	        // Default case: Redirect to CreateViewServlet
	            	    	 out.println("<td><a href='#' style='color:red'>Not Open Page!</a></td>");
	            	    }
	            	} else {
	            	    out.println("<td><a href='#' style='color:red'>Not Open Page!!</a></td>");
	            	}


	             out.println("</tr>");
	         }

	         out.println("</table>");
	         } 

	         // Extra closing curly brace
	         out.close();
	 }
	}
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++
//
//	        int mid = m.getMid();
//	        int rid = m.getReqid();
//	        String name = m.getMname();
//	        session.setAttribute("reqid", rid);
//	        session.setAttribute("mid", mid);
//	        session.setAttribute("mname1", name);
	       // session.setAttribute("permission", permission);
	    

	  
	
	
    // String username = (String) session.getAttribute("username");
   // out.println("id"+id);
   // out.println("name"+username);
//     String permission = request.getParameter("permission");
//	 
 
	  
	

	 

