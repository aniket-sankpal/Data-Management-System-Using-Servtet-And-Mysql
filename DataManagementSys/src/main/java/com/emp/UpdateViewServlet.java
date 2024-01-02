package com.emp;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/UpdateViewServlet")
public class UpdateViewServlet extends HttpServlet {
    // ... (no changes in the existing code)

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<center><h1>Employee List</h1></center>");
        out.println("<center><h4><a href='LogOut'>logout</a></h4></center>");

        List<Employee> list = EmployeeDao.getAllEmployee();

        out.println("<table border='2' width='100%'>");
        out.println("<tr>"
                + "<th>Id</th>"
                + "<th>Name</th>"
                + "<th>Password</th>"
                + "<th>Role</th>"
                + "<th>Edit</th>"
                + "</tr>");

        for (Employee e : list) {
            out.println("<tr>"
                    + "<td>" + e.getId() + "</td>"
                    + "<td>" + e.getName() + "</td>"
                    + "<td>" + e.getPassword() + "</td>"
                    + "<td>" + e.getRole() + "</td>"
                    + "<td><a href='EditServletForm?id=" + e.getId() + "'>Edit</a></td>"
                    + "</tr>");
        }

        out.println("</table>");
        out.close();
    }

    // ... (no changes in the existing code)



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
