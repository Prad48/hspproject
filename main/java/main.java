

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class main
 */
//@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter P1 = response.getWriter();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentd","root","Seven696#");
		    
		    /*if (i.equals("Pradhumn")&& j == 1) {
		    	P1.println("Login Successful !!\n\n");
			    request.setAttribute("username",i);
			    RequestDispatcher rd =request.getRequestDispatcher("Suc");
			    rd.include(request, response);
		    } else{
		    	P1.println("Check username/Passsword");
		    	
		    }*/
			//String T =request.getParameter("test");
		    /*if(Re.next()) {
		    	P1.println("<h1> welcome to your profile<h1>");
		    } else {
		    	P1.println("<h1>Usernam or password erro<h1>");
		    	RequestDispatcher rd =request.getRequestDispatcher("LOCK.html");
		    	rd.include(request, response);
		    }*/
		    
			    RequestDispatcher rd =request.getRequestDispatcher("regis.html");
		    	rd.include(request, response);
		   
		    	RequestDispatcher rd1 =request.getRequestDispatcher("BloodDonation.html");
		        rd1.include(request, response);
		        
		        RequestDispatcher rd2 =request.getRequestDispatcher("LOCK.html");
		        rd1.include(request, response);
		        
		        RequestDispatcher rd3 =request.getRequestDispatcher("LabTest.html");
		        rd1.include(request, response);
		        
		        RequestDispatcher rd4 =request.getRequestDispatcher("Doctorlogin.html");
		        rd1.include(request, response);
		        
		     
		     
			
	    }catch(Exception e) {
			P1.println(e);
		}
		// TODO Auto-generated method stub
	}
}
