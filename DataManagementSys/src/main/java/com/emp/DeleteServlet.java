package com.emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		String eid=request.getParameter("id");
		int id=Integer.parseInt(eid);
		int status=EmployeeDao.delete(id);
		
	
if(status >0) {
			
//			out.print("<h3 style='color:green'>deleted successfully !</h3>");
			request.getRequestDispatcher("ViewServlet").include(request,response);
		}else {
			
			out.print("<h3 style='color:red'>check your code !</h3>");
		}
		
	
	
	
	String mid=request.getParameter("mid");
	int id1=Integer.parseInt(mid);
	int status1=ModulsDao.delete(id1);
	

if(status1 >0) {
		
//		out.print("<h3 style='color:green'>deleted successfully !</h3>");
		request.getRequestDispatcher("ViewServlet").include(request,response);
	}else {
		
		out.print("<h3 style='color:red'>check your code !</h3>");
	}
	
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
