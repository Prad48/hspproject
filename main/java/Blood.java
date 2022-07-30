

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Blood
 */
//@WebServlet("/Blood")
public class Blood extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter P1 = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentd","root","Seven696#");
			String s1 =  "insert into blooddoner(name,occupation,email,bloodgroup,age,gender,date) values (?,?,?,?,?,?,?)";
			PreparedStatement pk = con.prepareStatement(s1);
				/*int j=   Integer.parseInt(request.getParameter("uid"));
				String i=request.getParameter("uname");
			    String k = request.getParameter("upass");*/
			pk.setString(1,request.getParameter("name"));
			pk.setString(2,request.getParameter("address"));
			pk.setString(3,request.getParameter("email"));
			pk.setString(4,request.getParameter("bloodgroup"));
			pk.setString(5,request.getParameter("age"));
			pk.setString(6,request.getParameter("num2"));
			pk.setString(7,request.getParameter("num22"));
			pk.executeUpdate();
			P1.println("<h1>You are successfully registered<h1>");
			RequestDispatcher rd =request.getRequestDispatcher("BloodDonation.html");
		    rd.include(request, response);
			P1.println("<style>");
			P1.println("h1{");
			P1.println("color:white;");
			P1.println("background-color:red;");
			P1.println("text-align:center");
			P1.println("}");
			P1.println("</style>");
			
		    
		}catch(Exception e) {
			P1.println(e);
		}
			P1.close();
			// TODO Auto-generated method stub
	}
			// TODO Auto-generated method stu

		// TODO Auto-generated method stub
}

