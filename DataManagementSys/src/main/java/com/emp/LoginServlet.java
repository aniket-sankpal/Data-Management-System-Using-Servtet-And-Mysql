package com.emp;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	        PrintWriter out = response.getWriter();
String role=request.getParameter("role");
            
	        String username = request.getParameter("name");
	        String password = request.getParameter("password");
	        HttpSession session = request.getSession();
	        session.setAttribute("name", username);
	      



	        
			if (validateUser(username, password,role)) {
	          
	          
	  

	            switch (role) {
            
                case "ADMIN":
                	 out.println("<h2 style='color:green'>Login Successfully!.</h2>");
                	 out.println("<h3 style='color:purple'>"+"Welcome :"+username+"</h3>");
           	        out.println("<br>"+"<h3 style='color:orange'>"+"Role:"+role+"</h3>");
           	     session.setAttribute("name", username);
                    request.getRequestDispatcher("ViewServlet").include(request, response);
                    break;
                case "EMPLOYEE":
                	// out.println("<h2 style='color:green'>Login Successfully!.</h2>");
                	//  out.println("<h3 style='color:purple'>"+"Welcome:"+username+"</h3>");
          	      //  out.println("<h3 style='color:orange'>"+"Role:"+role+"</h3>");
          	      session.setAttribute("username", username);
          	      
                    request.getRequestDispatcher("WelcomeServlet").include(request, response);
                    break;
           }
	            ;

	            
	          
	          
	        } else {
	            out.println("<center><h4>Login Failed. Please check your username and password.</h4></center>");
	          
	            request.getRequestDispatcher("LoginForm.html").include(request, response);
	        }

	}

	    private boolean validateUser(String username, String password,String role) {
	        String jdbcUrl = "jdbc:mysql://localhost:3306/opm";
	        String dbUsername = "root";
	        String dbPassword = "root";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

	            String query = "SELECT * FROM employee WHERE  name = ? AND password = ? AND role = ?";
	            try (PreparedStatement ps = conn.prepareStatement(query)) {
	                
	                ps.setString(1, username);
	                ps.setString(2, password);
	                ps.setString(3,role);
	                
	             
	                ResultSet rs = ps.executeQuery();
	                return rs.next();
	            }
	        } catch (Exception e) {
	            e.printStackTrace(); // Log the exception in a production environment
	            return false;

	}

}
}
