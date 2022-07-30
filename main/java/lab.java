

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
 * Servlet implementation class lab
 */
//@WebServlet("/lab")
public class lab extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter P1 = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentd","root","Seven696#");
			String s1 =  "insert into lab (name,test_name,email,contact,date) values (?,?,?,?,?)";
			PreparedStatement pk = con.prepareStatement(s1);
				/*int j=   Integer.parseInt(request.getParameter("uid"));
				String i=request.getParameter("uname");
			    String k = request.getParameter("upass");*/
			pk.setString(1,request.getParameter("num1"));
			pk.setString(2,request.getParameter("num2"));
			pk.setString(3,request.getParameter("num3"));
			pk.setString(4,request.getParameter("num4"));
			pk.setString(5,request.getParameter("num5"));
			pk.executeUpdate();
			RequestDispatcher rd =request.getRequestDispatcher("LabTest.html");
		    rd.include(request, response);
			
			P1.println("<style>");
			P1.println("h1{");
			P1.println("color:white;");
			P1.println("background-color:red;");
			P1.println("text-align:center");
			P1.println("}");
			P1.println("</style>");
			P1.println("<h1>You are successfully registered<h1>");
			
		}catch(Exception e) {
			P1.println(e);
		}
			P1.close();
		
	}
}	