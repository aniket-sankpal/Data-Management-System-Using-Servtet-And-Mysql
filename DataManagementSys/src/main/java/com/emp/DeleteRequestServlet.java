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
 * Servlet implementation class DeleteRequestServlet
 */
@WebServlet("/DeleteRequestServlet")
public class DeleteRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		//HttpSession session = request.getSession();
	 //  int reqid3= (int) session.getAttribute("reqid");
	String reqid2=request.getParameter("rid");
	//out.println("id:"+reqid)
	int id1=Integer.parseInt(reqid2);
	int status1=ModulsDao.delete(id1);
	out.println("id:"+ id1);
	out.println("delete status:"+status1);

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
