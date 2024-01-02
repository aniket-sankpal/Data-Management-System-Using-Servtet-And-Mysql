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
 * Servlet implementation class WaitingServlet
 */
@WebServlet("/WaitingServlet")
public class WaitingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WaitingServlet() {
        super();
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
		
		 response.setContentType("text/html");
			PrintWriter out =response.getWriter();
			 HttpSession session = request.getSession();
			  String nm=(String) session.getAttribute("name");
			  Employee name = EmployeeDao.getEmployeeByName(nm);
			  //back page retun code=============================
			 // String previousPage = (String) session.getAttribute("previousPage");

		         //   response.sendRedirect(previousPage);
		            //================================
			    int  mid= name.getId();
			String mname1 = request.getParameter("selection");
		String status = request.getParameter("status"); 
			
	
		  Moduls moduls = new Moduls();
	        moduls.setMid(mid);
	        
	        moduls.setMname(mname1);
	        moduls.setEmployee_id(mid);
	        moduls.setStatus(status);
//			out.println(e.getMid());
//			out.println(e.getMname());
//			out.println(e.getEmployee_id());
//			out.println(e.getStatus());
	        int saveStatus = ModulsDao.save(moduls);
	      int rid=  moduls.getReqid();

	        if (saveStatus > 0) {
			    out.print("<h3 style='color:green'>Request Send!</h3>");
				session.setAttribute("id"+ rid, rid);
				  
			   response.sendRedirect("RequestSuccessPage");
				 //response.sendRedirect("WaitingServlet");
			} else {
			    out.print("<h3 style='color:red'>Check your code!</h3>");
			    request.getRequestDispatcher("RequestServlet").include(request, response);
			    //response.sendRedirect("WaitingServlet");
			}
			
			
			
			
			
		
	     

	    
			out.close();
}
}
			
			
//		int mi = (int) session.getAttribute("mid1");
//	        String mn = (String) session.getAttribute("mname1");
////		out.println("mid:"+mi);
////		out.println("mname:"+ mn);
//		request.getParameter("selection");
//		String permission=request.getParameter("permission");
//		int permission1 = Integer.parseInt(request.getParameter("permission"));
//		String selection = request.getParameter("selection");
//
//		if (permission1 != 0) {
//		    if (selection != null) {
//		        switch (selection) {
//		            case "CREATE":
//		                request.getRequestDispatcher("CreateViewServlet").include(request, response);
//		                break;
//		            case "READ":
//		                request.getRequestDispatcher("ReadViewServlet").include(request, response);
//		                break;
//		            case "UPDATE":
//		                request.getRequestDispatcher("UpdateViewServlet").include(request, response);
//		                break;
//		            case "DELETE":
//		                request.getRequestDispatcher("DeleteViewServlet").include(request, response);
//		                break;
//		            // Add more cases as needed
//
//		            default:
//		                // Handle unknown selection
//		                response.getWriter().println("Unknown selection: " + selection);
//		                break;
//		        }
//		    } else {
//		        // Handle null or empty selection
//		        response.getWriter().println("Selection is null or empty");
//		    }
//		} else {
//		    // Handle permission == 0
//		    response.getWriter().println("Permission is 0");
//		}

	


