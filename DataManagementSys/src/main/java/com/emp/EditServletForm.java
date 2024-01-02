package com.emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServletForm
 */
@WebServlet("/EditServletForm")
public class EditServletForm extends HttpServlet {
    // ... (no changes in the existing code)

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String eid = request.getParameter("id");
        int id = Integer.parseInt(eid);
        Employee e = EmployeeDao.getEmployeeById(id);

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<style type='text/css'>");
        out.print("  * {\r\n"
        		+ "  margin: 0;\r\n"
        		+ "  padding: 0;\r\n"
        		+ "  box-sizing: border-box;\r\n"
        		+ "  font-family: \"Roboto\", sans-serif;\r\n"
        		+ "  font-size: 100%;\r\n"
        		+ "  font-weight: 400;\r\n"
        		+ "}\r\n"
        		+ "body {\r\n"
        		+ "  min-height: 100vh;\r\n"
        		+ "  display: flex;\r\n"
        		+ "  justify-content: center;\r\n"
        		+ "  align-items: center;\r\n"
        		+ "  background: rgb(46, 159, 230);\r\n"
        		+ "  \r\n"
        		+ "}\r\n"
        		+ "form {\r\n"
        		+ "  background-color: #ffffff;\r\n"
        		+ "  border-radius: 20px;\r\n"
        		+ "  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);\r\n"
        		+ "  transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);\r\n"
        		+ "  height: fit-content;\r\n"
        		+ "  display: flex;\r\n"
        		+ "  justify-content: center;\r\n"
        		+ "  flex-direction: column;\r\n"
        		+ "  padding: 50px 40px 45px 40px;\r\n"
        		+ "  width: 400px;\r\n"
        		+ "}\r\n"
        		+ "form .head {\r\n"
        		+ "  text-align: center;\r\n"
        		+ "  margin-bottom: 20px;\r\n"
        		+ "}\r\n"
        		+ ".form-group {\r\n"
        		+ "  display: flex;\r\n"
        		+ "  justify-content: center;\r\n"
        		+ "  flex-direction: column;\r\n"
        		+ "}\r\n"
        		+ "form .head h2 {\r\n"
        		+ "  font-size: 2rem;\r\n"
        		+ "  font-weight: 700;\r\n"
        		+ "  line-height: 1.6;\r\n"
        		+ "}\r\n"
        		+ "form .head p,\r\n"
        		+ "form .head p a {\r\n"
        		+ "  font-weight: 300;\r\n"
        		+ "}\r\n"
        		+ "input {\r\n"
        		+ "  border-radius: 7px;\r\n"
        		+ "  border: none;\r\n"
        		+ "  background-color: #f8f8f8;\r\n"
        		+ "  padding: 15px;\r\n"
        		+ "  outline: none;\r\n"
        		+ "  transition: 0.3;\r\n"
        		+ "  font-weight: 300;\r\n"
        		+ "}\r\n"
        		+ "input:focus {\r\n"
        		+ "  background-color: #fff;\r\n"
        		+ "  box-shadow: 0 1px 5px rgba(107, 107, 107, 0.1),\r\n"
        		+ "    0 1px 3px rgba(107, 107, 107, 0.12);\r\n"
        		+ "  transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);\r\n"
        		+ "}\r\n"
        		+ "input::placeholder {\r\n"
        		+ "  font-size: 90%;\r\n"
        		+ "  font-weight: 300;\r\n"
        		+ "  font-style: italic;\r\n"
        		+ "  color: #ccc;\r\n"
        		+ "}\r\n"
        		+ ".bio {\r\n"
        		+ "  margin: 10px 0;\r\n"
        		+ "  display: flex;\r\n"
        		+ "  justify-content: space-between;\r\n"
        		+ "  transition: 0.3;\r\n"
        		+ "}\r\n"
        		+ ".bio input {\r\n"
        		+ "  width: 49%;\r\n"
        		+ "}\r\n"
        		+ ".submit {\r\n"
        		+ "  margin: 10px 0;\r\n"
        		+ "  background-color: #4896fe;\r\n"
        		+ "  border-radius: 7px;\r\n"
        		+ "  padding: 10px 15px;\r\n"
        		+ "  display: flex;\r\n"
        		+ "  justify-content: space-between;\r\n"
        		+ "  border: none;\r\n"
        		+ "  color: #fff;\r\n"
        		+ "  font-weight: 300;\r\n"
        		+ "  letter-spacing: 1.2px;\r\n"
        		+ "  outline: none;\r\n"
        		+ "}\r\n"
        		+ ".checkBox {\r\n"
        		+ "  display: flex;\r\n"
        		+ "  align-items: center;\r\n"
        		+ "  flex-wrap: wrap;\r\n"
        		+ "}\r\n"
        		+ ".checkBox input {\r\n"
        		+ "  margin-right: 10px;\r\n"
        		+ "  border: none;\r\n"
        		+ "  background-color: #f8f8f8;\r\n"
        		+ "}\r\n"
        		+ ".checkBox p,\r\n"
        		+ ".checkBox p a {\r\n"
        		+ "  font-weight: 300;\r\n"
        		+ "  font-size: 12px;\r\n"
        		+ "}\r\n"
        		+ "@media (max-width: 475px) {\r\n"
        		+ "  .bio {\r\n"
        		+ "    flex-direction: column;\r\n"
        		+ "  }\r\n"
        		+ "  .bio input {\r\n"
        		+ "    width: 100%;\r\n"
        		+ "  }\r\n"
        		+ "  .bio input:nth-child(1) {\r\n"
        		+ "    margin-bottom: 10px;\r\n"
        		+ "  }\r\n"
        		+ "}");
        out.print("</style>");
        out.print("</head>");
        out.print("<body>");

        out.print("<form action='EditServlet' method='post'>");
        out.print("<div class='head'>");
        out.print("<h2>Update Details</h2>");
        out.print("</div>");

        out.print("<div class='form-group'>");
        out.print("<div class='checkbox'>");
        out.print("</div>");
        out.print("<br><br>");
        out.print("Select Role:");
        out.print("<select name='role' style='width:150px'>");
        out.print("<option " + (e.getRole().equals("A") ? "selected" : "") + ">A</option>");
        out.print("<option " + (e.getRole().equals("C") ? "selected" : "") + ">C</option>");
        out.print("<option " + (e.getRole().equals("R") ? "selected" : "") + ">R</option>");
        out.print("<option " + (e.getRole().equals("U") ? "selected" : "") + ">U</option>");
        out.print("<option " + (e.getRole().equals("D") ? "selected" : "") + ">D</option>");
        out.print("</select>");
        out.print("<input type='hidden' name='id' value='" + e.getId() + "'/> <br><br>");
        out.print("<input type='text' value='" + e.getName() + "' name='name'> <br><br>");
        out.print("<br><br>");
        out.print("<input type='password' value='" + e.getPassword() + "' name='password'> <br><br>");
        out.print("<br><br>");
        out.print("<button class='submit'>");
        out.print("<div></div>");
        out.print("Submit");
        out.print("<i class='fas fa-long-arrow-alt-right'></i>");
        out.print("</button>");

        out.print("</div>");
        out.print("</form>");
        out.print("</body>");
        out.print("</html>");

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
