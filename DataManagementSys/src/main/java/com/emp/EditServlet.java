package com.emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    // ... (no changes in the existing code)

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            String eid = request.getParameter("id");
            int id = Integer.parseInt(eid);
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String role = request.getParameter("role");

            Employee e = new Employee();
            e.setRole(role);
            e.setId(id);
            e.setName(name);
            e.setPassword(password);

            int status = EmployeeDao.update(e);

            if (status > 0) {
                response.sendRedirect("UpdateViewServlet");
            } else {
                out.print("<h3 style='color:red'>Failed to update employee details!</h3>");
            }
        } catch (NumberFormatException e) {
            out.print("<h3 style='color:red'>Invalid ID format. Please provide a valid numeric ID!</h3>");
        } catch (Exception e) {
            e.printStackTrace();
            out.print("<h3 style='color:red'>An error occurred. Check your code!</h3>");
        } finally {
            out.close();
        }
    }


		}

