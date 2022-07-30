

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
 * Servlet implementation class D1
 */
//@WebServlet("/D1")
public class D1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter P1 = response.getWriter();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentd","root","Seven696#");
		    //String s1 =  "select * from studentda where Student_id = ?";
		    //String s2 = "insert into studentda values(?,?,?)";
		    String s1= "delete from doctordetail where doctorId =?";
		    //String s1 =  "select * from userlogin where uname =? and uid =?";
			PreparedStatement pt = con.prepareStatement(s1);
			
		    String n=   request.getParameter("uid2");
		    //String T =request.getParameter("test");
			
			pt.setString(1,n);
		    int r =pt.executeUpdate();
		    RequestDispatcher rd =request.getRequestDispatcher("editDetail.html");
	    	rd.include(request, response);
	    	if(r==1) {
	    		P1.println("<h1>Your deatail deleted<h1>");
	    	}else {
	    		P1.println("<h1>Incorrect ID!<h1>");
	    	}
		    P1.println("");
			P1.println("");
			P1.println("<style>");
			P1.println("h1{");
			P1.println("color:white;");
			P1.println("background-color:red;");
			P1.println("text-align:center");
			//P1.println("border: 1px solid black;");
			P1.println("}");
			P1.println("</style>");
			
		    /*while(Re.next()) {
		    	P1.println(Re.getString(1)+" "+Re.getString(2)+" "+Re.getString(3));	
		    }*/
			con.close();
		}catch(Exception e) {
			P1.println(e);
		}
	}

}
