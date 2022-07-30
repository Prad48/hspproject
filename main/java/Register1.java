

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register1
 */
//@WebServlet("/Register1")
public class Register1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter P1 = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentd","root","Seven696#");
			String s1 =  "insert into appoinment (name,age,MobileNo,doctorname,id,reason,gender,date) values (?,?,?,?,?,?,?,?)";
			PreparedStatement pt = con.prepareStatement(s1);
			/*int j=   Integer.parseInt(request.getParameter("uid"));
			String i=request.getParameter("uname");
		    String k = request.getParameter("upass");*/
			pt.setString(1,request.getParameter("uname"));
			pt.setString(2,request.getParameter("age"));
			pt.setString(3,request.getParameter("contact"));
			pt.setString(4,request.getParameter("dr"));
			pt.setString(5,request.getParameter("uid"));
			pt.setString(6,request.getParameter("num"));
			pt.setString(7,request.getParameter("num2"));
			pt.setString(8,request.getParameter("da"));
			pt.executeUpdate();
		   
		    RequestDispatcher rd =request.getRequestDispatcher("regis.html");
	    	rd.include(request, response);
	    	 
			 P1.println("<style>"); 
			 P1.println("h1 {");        // note leading brace
			 P1.println("color:white;");
			 P1.println("background-color:red;");
			 P1.println("border: 1px solid black;");
			 P1.println("text-align:center;");
			 P1.println("}");       
			 P1.println("</style>"); 
			 P1.println("<h1>You are successful registered<h1>");
		    
	    	
		}
		
		catch(Exception e) {
			P1.println(e);
		}
		P1.close();
		// TODO Auto-generated method stub
	}
		// TODO Auto-generated method stu

}
