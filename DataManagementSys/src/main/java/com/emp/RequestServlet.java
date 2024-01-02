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
 * Servlet implementation class RequestServlet
 */
@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		   HttpSession session = request.getSession();
		   
		
	       String username = (String) session.getAttribute("username");
	     // out.println("id"+id);
	      out.println("name"+username);
//	       String permission = request.getParameter("permission");
//		 
	     int id = (int) session.getAttribute("id");
	      String n=(String) session.getAttribute("name");
	    //  out.print("req name:"+ n);
	      session.setAttribute("name",n);
	   
		    out.println("<script>"
		            + "    function validateForm() {"
		            + "        var checkboxes = document.getElementsByName('selection');"
		            + "        var checkedCount = 0;"
		            + ""
		            + "        for (var i = 0; i < checkboxes.length; i++) {"
		            + "            if (checkboxes[i].checked) {"
		            + "                checkedCount++;"
		            + "            }"
		            + "        }"
		            + ""
		            + "        if (checkedCount !== 1) {"
		            + "            alert('Please select exactly one option.');"
		            + "            return false;"
		            + "        }"
		            + ""
		            + "        return true;"
		            + "    }"
		            + "</script>");
		    out.println("<h2 style='color:blue'>"+"Request To Page :"+"</h2>");
		    
		    //form
		    out.println("<form action='WaitingServlet' method='POST"
		    		+ "' onsubmit='return validateForm()'>");
		    out.println("<table border='2' width='100%' style='background-color: lightblue;'>");
		    out.println("<tr>"
		            + "<th> CREATE PAGE</th>"
		            + "<th> READ PAGE</th>"
		            + "<th> UPDATE PAGE</th>"
		            + "<th> DELETE PAGE</th>"
		            + "<th>Request Status</th>"
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
		            + "<td>" + "<input type='text' name='status' value=' ' readonly >"
		            + "</td>"
		            + "</tr>");

		    out.println("</table>");
		    out.println("<br><br>");
		    out.println("<input type='submit' value='Submit'>");
		    session.setAttribute("id",id);
		
		    out.println("</form><br>");

		 
		        out.close();
		    }

}

 
	    // Retrieve checkbox values
	   // String[] selectedValues = request.getParameterValues("selection");

//	    if (selectedValues != null && selectedValues.length > 0) {
//	        // Iterate through the selected checkbox values
//	        for (String value : selectedValues) {
//	            // Process each selected value as needed
//	            out.println("Selected Value: " + value);
//	        }
//	        
//	        // If you want to set them in the session, you can do something like:
//	        // HttpSession session = request.getSession();
//	        // session.setAttribute("selectedValues", selectedValues);
//	    } else {
//	        // Handle the case where no checkboxes are selected
//	       out.println("No checkboxes selected.");
//	    }
	  
	    
	



		   // Redirect to ViewServlet after successful login
//
//        switch (mn) {
//            case "CREATE":
//                request.getRequestDispatcher("CreateViewServlet").include(request, response);
//                break;
//            case "READ":
//                request.getRequestDispatcher("ReadViewServlet").include(request, response);
//                break;
//            case "UPDATE":
//                request.getRequestDispatcher("UpdateViewServlet").include(request, response);
//                break;
//            case "DELETE":
//                request.getRequestDispatcher("DeleteViewServlet").include(request, response);
//                break;
//           
//        }
		
		
		
		
	
	

	
	
