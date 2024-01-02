package com.emp;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SaveServlet() {
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
		// TODO Auto-generated method stub
	response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		String name =request.getParameter("name");
		String password =request.getParameter("password");
		String role =request.getParameter("role");
		
		Employee e =new Employee();
		e.setName(name);
		e.setPassword(password);
		e.setRole(role);
		
		
		int status =EmployeeDao.save(e);
		if(status >0) {
			
			out.print("<h3 style='color:green'>Record saved successfully !</h3>");
			request.getRequestDispatcher("LoginForm.html").include(request,response);
		}else {
			
			out.print("<h3 style='color:red'>check your code !</h3>");
			request.getRequestDispatcher("index.html").include(request,response);
		}
		out.close();
	}

}
